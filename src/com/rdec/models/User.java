package com.rdec.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coustmer")


public class User {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="Email")
	private String email;

	@Column(name="PASSWORD")
	private String pass;
	@Column(name="loginStatus")
	private byte loginStatus;
	@Column(name="userType") 
	private char userType;
	
	
		public User() {
	}


		public User( String email, String pass, byte loginStatus, char userType) {
			super();
			
			this.email = email;
			this.pass = pass;
			this.loginStatus = loginStatus;
			this.userType = userType;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPass() {
			return pass;
		}


		public void setPass(String pass) {
			this.pass = pass;
		}


		public byte getLoginStatus() {
			return loginStatus;
		}


		public void setLoginStatus(byte loginStatus) {
			this.loginStatus = loginStatus;
		}


		public char getUserType() {
			return userType;
		}


		public void setUserType(char userType) {
			this.userType = userType;
		}
		
			
	
	
}
