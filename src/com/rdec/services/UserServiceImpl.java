package com.rdec.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rdec.models.Card;
import com.rdec.models.Product;
import com.rdec.models.User;

import dao.UserDAO;
import dao.UserDAOImpl;

import util.HibernateUtil;

public class UserServiceImpl implements UserService {
	
	@Override
	public String addUser(User user){
		//System.out.println(" 5555555555"+user.getName()+" "+user.getAddress()+" "+user.getDob()+" "+user.getMobile()+" "+user.getEmail());
		UserDAO dao=new UserDAOImpl();
		String res=dao.addUser(user);
		System.out.println(res);
		return res;
	}

	@Override
	public User loginUser(User user) {
		UserDAO dao=new UserDAOImpl();
		User res=dao.loginUser(user);
	
		return res;
	}

	@Override
	public String setLoginStatus(User user) {
		String res="FAil";
		UserDAO dao=new UserDAOImpl();
		res=dao.setLoginStatus(user);
		return res;
	}

	@Override
	public String addProduct(Product product) {
		String res="FAil";
		UserDAO dao=new UserDAOImpl();
		res=dao.addProduct(product);
		return res;
		
	}

	@Override
	public List<Product> getProduct() {
		UserDAO dao=new UserDAOImpl();
		List<Product> res=dao.getProduct();

		return res;
	}
	public List<String> getCatagery(){
		UserDAO dao=new UserDAOImpl();
		List<String> res=dao.getCatagery();
		return res;
	}
		
/*
	@Override
	public String deleteUser(User user) {
		String res=null;
		try {
			res=dao.deleteUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		}
*/
	@Override
	public String updateUser(User user) {
		String res=null;
		UserDAO dao=new UserDAOImpl();
		res=dao.updateUser(user);
		return res;
		}
	@Override
	public String deleteUser(User user){
		String res=null;
		UserDAO dao=new UserDAOImpl();
		res=dao.deleteUser(user);
		return res;
		}

/*
	@Override
	public User getUserbyName(String name) {
		User user=null;
		try {
			user=dao.getUserbyName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
*/
	@Override
	public User getUserbyId(int id)  {
		UserDAO dao=new UserDAOImpl();
		User user=null;
		user=dao.getUserbyId(id);
		return user;
		}

	@Override
	public List<User> getAllUser() {
		List<User> list=null;
		UserDAO dao=new UserDAOImpl();
		list=dao.getAll();
				return list;
		}

	@Override
	public String addCard(Card card) {
		String res="FAil";
		UserDAO dao=new UserDAOImpl();
		res=dao.addCard(card);
		return res;
	}

	@Override
	public List<Card> getCard(int uid) {
		List<Card> res=null;
		UserDAO dao=new UserDAOImpl();
		res=dao.getCard(uid);
		return res;
	}

	@Override
	public String deleteProduct(Product product) {
		String res=null;
		UserDAO dao=new UserDAOImpl();
		res=dao.deleteProduct(product);
		return res;
// TODO Auto-generated method stub
		
	}

	@Override
	public String delCart( int id) {
		
		// TODO Auto-generated method stub
		String res=null;
		UserDAO dao=new UserDAOImpl();
		res=dao.delCart(id);
		return res;
	}
	
	}



