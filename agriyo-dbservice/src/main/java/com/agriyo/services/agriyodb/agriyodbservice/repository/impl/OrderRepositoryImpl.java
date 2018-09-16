package com.agriyo.services.agriyodb.agriyodbservice.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.agriyo.services.agriyodb.agriyodbservice.dto.SearchInput;
import com.agriyo.services.agriyodb.agriyodbservice.dto.SearchResult;
import com.agriyo.services.agriyodb.agriyodbservice.model.Order;
import com.agriyo.services.agriyodb.agriyodbservice.model.OrderAssign;
import com.agriyo.services.agriyodb.agriyodbservice.repository.OrderRepositoryCustom;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

	@Autowired
	private EntityManager em;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Order> findByOrderByAssignedId(Integer farmerId) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> query = cb.createQuery(Order.class);
		Root<Order> order = query.from(Order.class);
		Root<OrderAssign> orderAssign = query.from(OrderAssign.class);
		Join<Order, Order> orderAssigns = order.join("orderAssigns");
		query.select(order).where(cb.equal(orderAssign.get("userId"), farmerId));
		return em.createQuery(query).getResultList();

	}

	// @Transactional(propagation = Propagation.REQUIRED)
	@Transactional
	@Override
	public void saveAssignedOrder(List<OrderAssign> orderAssignList) {
		for (OrderAssign orderAssign : orderAssignList)
			em.persist(orderAssign);
	}

	@Override
	public Set<Order> findAllAssginedOrders(Integer userId) {
		Set<Order> orderSet = new HashSet<Order>();
		Query orderAssignQuery = em.createQuery("SELECT o FROM OrderAssign o WHERE user_id = :userId");
		orderAssignQuery.setParameter("userId", userId);

		List<OrderAssign> orderAssigns = orderAssignQuery.getResultList();

		if (orderAssigns != null && !orderAssigns.isEmpty()) {
			List<Integer> orderIdList = new ArrayList();
			for (OrderAssign orderAssign : orderAssigns)
				orderIdList.add(orderAssign.getOrderId());
			Query orderQuery = em.createQuery("SELECT o FROM Order o WHERE id IN :orderIdList");
			orderQuery.setParameter("orderIdList", orderIdList);
			orderSet.addAll(orderQuery.getResultList());
		}

		return orderSet;
	}

	@Override
	public List<SearchResult> search(SearchInput searchInput) {
		StringBuilder queryStringBuilder = new StringBuilder(
				"select c.Id as id, c.CROP_NAME as cropName, sum(IFNULL(fc.volume,0)) as volume "
				+ ",concat(u.CITY,', ',u.STATE) as location from t_farmer_crop fc "
				+ "join m_crop_product c on fc.CROP_ID=c.ID join  t_user u on fc.FARMER_ID=u.ID left outer join t_order o on o.CROP_ID=fc.ID "
				+ "where c.CROP_NAME like ? ");
		
		StringBuilder orderQueryStringBuilder = new StringBuilder(
				"select c.Id as id, sum(IFNULL(o.quantity,0)) as volume "
				+" from m_crop_product c "
				+ "join t_order o on o.CROP_ID=c.ID join t_user u on u.ID=o.ORDER_RECEIVED_BY "
				+ "where c.CROP_NAME like ? ");

		

		if (searchInput.getLocation() != null) {
			queryStringBuilder.append(" and (u.CITY like ? or u.STATE like ? or u.COUNTRY like ?)");
			orderQueryStringBuilder.append(" and (u.CITY like ? or u.STATE like ? or u.COUNTRY like ?)");
		}
		queryStringBuilder.append(" group by c.CROP_NAME ");
		orderQueryStringBuilder.append(" group by c.CROP_NAME ");

		Query query = em.createNativeQuery(queryStringBuilder.toString());
		query.setParameter(1, searchInput.getCropName());
		Query orderQuery = em.createNativeQuery(orderQueryStringBuilder.toString());
		orderQuery.setParameter(1, searchInput.getCropName());
		if (searchInput.getLocation() != null) {
			query.setParameter(2, searchInput.getLocation());
			query.setParameter(3, searchInput.getLocation());
			query.setParameter(4, searchInput.getLocation());
			orderQuery.setParameter(2, searchInput.getLocation());
			orderQuery.setParameter(3, searchInput.getLocation());
			orderQuery.setParameter(4, searchInput.getLocation());
		}
		List<Object[]> crops = query.getResultList();
		List<Object[]> orders = orderQuery.getResultList();
		List<SearchResult> searchResults= new ArrayList<>();
		crops.stream().forEach((record) -> {
			SearchResult result= new SearchResult();
			result.setId((Integer)record[0]);
			result.setCropName((String)record[1]);
			result.setVolume(((BigDecimal)record[2]).intValue());
			result.setLocation((String)record[3]);
			for(Object[] order:orders) {
				if((Integer)order[0]==result.getId()) {
					result.setVolume(result.getVolume()-((BigDecimal)order[1]).intValue());
					break;
				}
			}
			
	       searchResults.add(result);
	});
		return searchResults;

	}
	

}

/*
 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<FarmerCrop> query
 * = cb.createQuery(FarmerCrop.class); Root<FarmerCrop> farmerCrop =
 * query.from(FarmerCrop.class); Join<FarmerCrop, Crop> cropJoin =
 * farmerCrop.join("crop"); query.select(farmerCrop); Predicate likeCropName =
 * cb.like(cropJoin.get("cropName"), searchInput.getCropName());
 * if(searchInput.getLocation()!=null) { Join<FarmerCrop, Crop> cropJoin =
 * farmerCrop.join("crop"); Predicate likeCity =
 * cb.like(cropJoin.get("cropName"), searchInput.getCropName());
 * 
 * query.where(equalCropName); } else { query.where(likeCropName); }
 */
