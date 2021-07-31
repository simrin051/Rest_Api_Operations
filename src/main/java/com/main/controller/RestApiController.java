package com.main.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.RestApiModel;
import com.main.repository.RestApiRepository;
import com.main.services.RestApiService;

@RestController
public class RestApiController {

	Pageable pageable;
	
	@Autowired
	RestApiService service;
	
	@RequestMapping("/storeurl")
	public void storeUrl(@RequestParam String url)
	{
		service.storeUrl(url);
		
	}
	
	@RequestMapping("/get")
	public CompletableFuture<String> findByUrl(@RequestParam String url)
	{
		return service.findByUrl(url);
	}
	
	@RequestMapping("/list")
	public void getUrls(Pageable pageable)
	{
		service.getUrls(pageable);
	
	}
	
	@RequestMapping("/count")
	public CompletableFuture<Integer> getCount(@RequestParam String url)
	{
		return service.getCount(url);
	}
}


