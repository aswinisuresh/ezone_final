package com.niit.ezone.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodid;	//pid
	private String prodname; //pname
	private String proddesc;
	private int suppid;
	private int catid;
	private int prodquan;
	private int prodcost;
	
	@Transient
	private MultipartFile pimage;
	
/*	@ManyToOne
	@JoinColumn(name = "suppid", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "catid", nullable = false, updatable = false, insertable = false)
	private Category category;	*/
	
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public int getSuppid() {
		return suppid;
	}
	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getProdquan() {
		return prodquan;
	}
	public void setProdquan(int prodquan) {
		this.prodquan = prodquan;
	}
	public int getProdcost() {
		return prodcost;
	}
	public void setProdcost(int prodcost) {
		this.prodcost = prodcost;
	}
	
	

}
