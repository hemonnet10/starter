package com.agriyo.services.agriyodb.agriyodbservice.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.agriyo.services.agriyodb.agriyodbservice.model.Country;
import com.agriyo.services.agriyodb.agriyodbservice.model.District;
import com.agriyo.services.agriyodb.agriyodbservice.model.State;
import com.agriyo.services.agriyodb.agriyodbservice.repository.MasterRepositoryCustom;

public class CountryRepositoryImpl implements MasterRepositoryCustom {

	@Autowired
	private EntityManager em;

	@Override
	public List<Country> fetchAllCountries(String status) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> query = cb.createQuery(Country.class);
		Root<Country> country = query.from(Country.class);
		query.select(country).where(cb.equal(country.get("isActive"), status));
		return em.createQuery(query).getResultList();

	}

	@Override
	public List<State> fetchAllStates(Integer cid, String status) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<State> query = cb.createQuery(State.class);
		Root<State> state = query.from(State.class);
		query.select(state).where(cb.equal(state.get("cId"), cid),cb.equal(state.get("isActive"), status));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<District> fetchAllDistrict(Integer sid, String status) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<District> query = cb.createQuery(District.class);
		Root<District> district = query.from(District.class);
		query.select(district).where(cb.equal(district.get("sId"), sid),cb.equal(district.get("isActive"), status));
		return em.createQuery(query).getResultList();
	}

}