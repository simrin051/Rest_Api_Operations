package com.main.services;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.main.model.RestApiModel;
import com.main.repository.RestApiRepository;

import net.bytebuddy.utility.RandomString;

@Component
public class RestApiService {
	
@Autowired	
RestApiRepository repository;
	

@Async
public CompletableFuture<RestApiModel> storeUrl(String url)
{
	RestApiModel model = new RestApiModel(1L,url,0,getRandomString(url.length()));
	repository.save(model);
	System.out.println("Saved" +repository.findAll());
	return CompletableFuture.completedFuture(model);
}

@Async
public CompletableFuture<String> findByUrl(String url)
{
	RestApiModel model=repository.findByUrl(url);
	int count=model.getCount()+1;
	repository.save(new RestApiModel(model.getId(),model.getUrl(),count,model.getShortKey()));
	return CompletableFuture.completedFuture(model.getShortKey());
		
}

@Async
public CompletableFuture<Page<RestApiModel>> getUrls(Pageable pageable)
{
	Page<RestApiModel> list=repository.findAll(pageable);
	System.out.println(list);
	return CompletableFuture.completedFuture(list);
}

@Async
public CompletableFuture<Integer> getCount(String url)
{
	RestApiModel model=repository.findByUrl(url);
	return CompletableFuture.completedFuture(model.getCount());
}

public String getRandomString(int n)
{
	return RandomStringUtils.random(n);
}

}
