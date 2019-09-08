package com.rdec.models;

import java.io.FileInputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String pname;
	@Column(name="Catagery")
	private String pcatagery;
	@Column(name="Fprice")
	private float price;
	@Column(name="Quantity")
	private int quantity;
	@Column(name="Image")
	private byte[] im;
	@Column(name="Sprice")
	private float sprice;
	
	public Product() {
		
	}
	
	public Product(String pname, String pcatagery, float price,float sprice, int quantity, byte[] im) {
		super();
		this.pname = pname;
		this.pcatagery = pcatagery;
		this.price = price;
		this.quantity = quantity;
		this.im=im;
		this.sprice = sprice;
	}
	
	public byte[] getIm() {
		return im;
	}

	public void setIm(byte[] im) {
		this.im = im;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcatagery() {
		return pcatagery;
	}
	public void setPcatagery(String pcatagery) {
		this.pcatagery = pcatagery;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSprice() {
		return sprice;
	}

	public void setSprice(float sprice) {
		this.sprice = sprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
