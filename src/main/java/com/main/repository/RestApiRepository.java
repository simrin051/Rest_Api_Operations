package com.main.repository;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.model.RestApiModel;

public interface RestApiRepository  extends JpaRepository<RestApiModel, Long> {
	

	public RestApiModel findByUrl(String url);
	
	
	

}
