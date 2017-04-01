package com.niit.ezone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Supplier {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
 private int suppid;
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
