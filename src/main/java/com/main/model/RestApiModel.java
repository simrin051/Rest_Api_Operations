package com.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="RestApis")
public class RestApiModel {

@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
Long Id;

String url;

int count;

String shortKey;

public RestApiModel()
{
	
}

public RestApiModel(Long Id,String url, int count, String shortKey) {
	super();
	this.Id=Id;
	this.url = url;
	this.count = count;
	this.shortKey=shortKey;
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getShortKey() {
	return shortKey;
}

public void setShortKey(String shortKey) {
	this.shortKey = shortKey;
}

}
