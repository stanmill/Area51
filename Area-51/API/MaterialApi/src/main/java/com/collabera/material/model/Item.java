package com.collabera.material.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material_list")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String cost;
	private int num;
	private String picture;
	
	public Item() {
		
	}
	
	public Item(Long id, String name, String cost, int num, String picture) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.num = num;
		this.picture = picture;
	}
	
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
