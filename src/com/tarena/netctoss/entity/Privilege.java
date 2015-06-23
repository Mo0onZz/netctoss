package com.tarena.netctoss.entity;

import java.util.ArrayList;
import java.util.List;

public class Privilege extends Entity{
	private String id;
	private String name;
	private List<String> urls = new ArrayList<String>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

}
