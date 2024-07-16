package com.springwithtesting.productapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	private String productname;
	private String productinfo;
	private Double productprice;
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductinfo() {
		return productinfo;
	}
	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}
	public Double getProductprice() {
		return productprice;
	}
	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}
	
	public Product() {
		super();
	}
	public Product(String productname, String productinfo, Double productprice) {
		super();
		this.productname = productname;
		this.productinfo = productinfo;
		this.productprice = productprice;
	}
}
