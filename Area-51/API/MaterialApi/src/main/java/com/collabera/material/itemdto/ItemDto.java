package com.collabera.material.itemdto;

public class ItemDto {
	
	private Long id;
	private String name;
	private String cost;
	private int numOfItems;
	private String picture;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public int getNumOfItems() {
		return numOfItems;
	}
	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}	

}
