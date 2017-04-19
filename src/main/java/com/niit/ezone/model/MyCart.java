package com.niit.ezone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class MyCart {
	@Id
	private int cartid;
	private String id;
	private String prodname;
	private int prodcost;
	private String status;
	private int prodquan;
	private Date dateadded;	
	@Column(name="CARTSUM")
	private int sum;
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getProdcost() {
		return prodcost;
	}
	public void setProdcost(int prodcost) {
		this.prodcost = prodcost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProdquan() {
		return prodquan;
	}
	public void setProdquan(int prodquan) {
		this.prodquan = prodquan;
	}
	public Date getDateadded() {
		return dateadded;
	}
	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
		
	}