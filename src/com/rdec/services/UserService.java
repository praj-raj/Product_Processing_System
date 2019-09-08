package com.rdec.services;



import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.rdec.models.Card;
import com.rdec.models.Product;
import com.rdec.models.User;

public interface UserService {
	public String addUser(User user);
	public User loginUser(User user);
	public String setLoginStatus(User user);
	public String addProduct(Product product);
	public List<Product> getProduct();
	public List<String> getCatagery();
	public String updateUser(User user);
	public String deleteUser(User user);
	public String addCard(Card card);
	public List<Card> getCard(int uid);
	public String deleteProduct(Product product);
	public String delCart(int id);
	//public User getUserbyName(String name);
	public User getUserbyId(int id);
public List<User> getAllUser();
}
		
	


