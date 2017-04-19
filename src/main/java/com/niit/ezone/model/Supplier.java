package com.niit.ezone.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Supplier {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)

/*@OneToMany(mappedBy="supplier",fetch = FetchType.EAGER)
private Set<Product> products;
*/
private int suppid;
 
/*public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}*/
private String suppname;
private String suppaddress;
public int getSuppid() {
	return suppid;
}
public void setSuppid(int suppid) {
	this.suppid = suppid;
}
public String getSuppname() {
	return suppname;
}
public void setSuppname(String suppname) {
	this.suppname = suppname;
}
public String getSuppaddress() {
	return suppaddress;
}
public void setSuppaddress(String suppaddress) {
	this.suppaddress = suppaddress;
}



}
