package com.main.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.main.model.RestApiModel;

/**
@Component
public class RestApiRepositoryImpl {
	

    @PersistenceContext
    private EntityManager entityManager;
    
	public RestApiModel findByUrl(String url)
	{
		String sql="select from RestApiModel where url = :url";
		 TypedQuery<RestApiModel> query = entityManager.createQuery(sql, RestApiModel.class);
	        query.setParameter("url", url);
	        return query.getSingleResult();
	}
}
**/