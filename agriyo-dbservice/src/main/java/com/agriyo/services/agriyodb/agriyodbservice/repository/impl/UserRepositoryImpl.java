package com.agriyo.services.agriyodb.agriyodbservice.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerCrop;
import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerDetail;
import com.agriyo.services.agriyodb.agriyodbservice.model.User;
import com.agriyo.services.agriyodb.agriyodbservice.model.UserRequest;
import com.agriyo.services.agriyodb.agriyodbservice.repository.UserRepositoryCustom;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	private EntityManager em;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<User> getElibleFarmerForOrder(Integer cropId) {
		
		
		Query farmerQuery = em.createQuery(
	            "SELECT o FROM FarmerCrop o WHERE (crop_id = :cropId)");
		farmerQuery.setParameter("cropId",cropId);
		
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FarmerCrop> query = cb.createQuery(FarmerCrop.class);
		Root<FarmerCrop> farmerCrop = query.from(FarmerCrop.class);
		query.select(farmerCrop).where(cb.equal(farmerCrop.get("cropId"), cropId));
		*/
		List<FarmerCrop> farmerCrops =farmerQuery.getResultList();
		
		if(farmerCrops!=null && !farmerCrops.isEmpty()) {
		List<Integer> userIdList=new ArrayList();
		for(FarmerCrop crop:farmerCrops)
			userIdList.add(crop.getFarmerId());
		Query userQuery = em.createQuery(
	            "SELECT o FROM User o WHERE (id IN :userIdList)");
		userQuery.setParameter("userIdList",userIdList);
		return userQuery.getResultList();
		}
		return new ArrayList<User>();
		}

	@Transactional
	@Override
	public void saveFarmerCrops(List<FarmerCrop> farmerCrops) {
		
		/*Query deleteQuery = em.createQuery(
	            "DELETE FROM FarmerCrop o WHERE farmerId = :farmerId");
		deleteQuery.setParameter("farmerId",farmerCrops.get(0).getFarmerId());
		deleteQuery.executeUpdate();*/
//		em.flush();
		for (FarmerCrop farmerCrop : farmerCrops) {
			if (farmerCrop.getId() != null) {
				FarmerCrop tempFarmerCrop = em.find(FarmerCrop.class,
						farmerCrop.getId());
				tempFarmerCrop.setCrop(farmerCrop.getCrop());
				tempFarmerCrop.setFarmerId(farmerCrop.getFarmerId());
				farmerCrop = tempFarmerCrop;
			}
			em.persist(farmerCrop);
		}

	}

	@Transactional
	@Override
	public FarmerDetail saveFarmerDetail(FarmerDetail farmerDetail) {
		if (farmerDetail.getId() != null) {
			FarmerDetail tempFarmerDetail = em.find(FarmerDetail.class,
					farmerDetail.getId());
			tempFarmerDetail
					.setLandSize(farmerDetail.getLandSize());
			tempFarmerDetail.setNearestMandi(farmerDetail.getNearestMandi());
			tempFarmerDetail.setLandUnit(farmerDetail.getLandUnit());
			tempFarmerDetail.setIsLandAvailable(farmerDetail.getIsAssetAvailable());
			tempFarmerDetail.setNearestMarket(farmerDetail.getNearestMarket());
			tempFarmerDetail.setFarmingType(farmerDetail.getFarmingType());
			tempFarmerDetail.setProfession(farmerDetail.getProfession());
			tempFarmerDetail.setIncome(farmerDetail.getIncome());
			tempFarmerDetail.setFamilyMember(farmerDetail.getFamilyMember());
			tempFarmerDetail.setAdhaar(farmerDetail.getAdhaar());
			tempFarmerDetail.setBankAccount(farmerDetail.getBankAccount());
			tempFarmerDetail.setIsAssetAvailable(farmerDetail.getIsAssetAvailable());
			tempFarmerDetail.setAssetType(farmerDetail.getAssetType());
			tempFarmerDetail.setAsset(farmerDetail.getAsset());
			
			farmerDetail=tempFarmerDetail;
		}
		em.persist(farmerDetail);
		return farmerDetail;
	}

	@Transactional
	
	@Override
	public void saveUserRequest(UserRequest userRequest) {
	em.persist(userRequest);	
	}

	@Override
	public FarmerDetail getFarmerDetail(Integer farmerId) {
		Query farmerCropQuery = em.createQuery(
	            "SELECT o FROM FarmerDetail o WHERE farmerId = :farmerId");
		farmerCropQuery.setParameter("farmerId",farmerId);
		return (FarmerDetail) farmerCropQuery.getSingleResult();
	}
	
	@Override
	public List<FarmerCrop> getFarmerCrops(Integer farmerId) {
		Query farmerCropQuery = em.createQuery(
	            "SELECT o FROM FarmerCrop o WHERE farmerId = :farmerId");
		farmerCropQuery.setParameter("farmerId",farmerId);
		return farmerCropQuery.getResultList();
		
	}
}
