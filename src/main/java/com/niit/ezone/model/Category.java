package com.niit.ezone.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category {
	@Id
	private int catid;
	private String catname;
	private String catdesc;
	
	/*@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	private Set<Product> productsInCategory;
	
	public Set<Product> getProductsInCategory() {
		return productsInCategory;
	}
	public void setProductsInCategory(Set<Product> productsInCategory) {
		this.productsInCategory = productsInCategory;
	}*/
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatdesc() {
		return catdesc;
	}
	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}
/*	@Override
	public String toString() {
		return "Category [categoryID=" + catid + ", categoryName=" + catname + ", categorydescription="
				+ catdesc + "]";
	}*/
}
