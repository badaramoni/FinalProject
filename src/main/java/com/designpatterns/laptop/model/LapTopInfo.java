package com.designpatterns.laptop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LapTopDB")
public class LapTopInfo {
	@Id
	private String id;
	private String brand;
	private String laptopColor;
	private int price ;
	
	/**
	 * default constructor
	 */
	public LapTopInfo() {

	}

	/**
	 * @param id
	 * @param brand
	 * @param laptopColor
	 * @param price
	 */
	public LapTopInfo(String id, String brand, String laptopColor, int price) {
		super();
		this.id = id;
		this.brand = brand;
		this.laptopColor = laptopColor;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLaptopColor() {
		return laptopColor;
	}

	public void setLaptopColor(String laptopColor) {
		this.laptopColor = laptopColor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LapTopInfo [id=" + id + ", brand=" + brand + ", laptopColor=" + laptopColor + ", price=" + price + "]";
	}
	
}

