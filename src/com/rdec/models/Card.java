package com.rdec.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cart")
public class Card {
	
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="UserId")
	private Integer uid;
	
	@Column(name="ProductId")
	private Integer pid;
	
	
	public Card() {
		
	}
	public Card(int uid, int pid) {
		super();
		this.uid = uid;
		this.pid = pid;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
