package com.collabera.material.model;

public class Item {

	/* 
	id
	name
	cost
	num
	picture
	 */
	
	private int id;
	private String name;
	private int cost;
	private int num;
	private String picture;
	
	public Item() {
		
	}
	
	public Item(int id, String name, int cost, int num, String picture) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.num = num;
		this.picture = picture;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + 
				", cost=" + cost + ", num=" + num + 
				", picture=" + picture + "]";
	}
	
	
	
}
