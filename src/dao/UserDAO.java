package dao;

import java.util.List;

import com.rdec.models.Card;
import com.rdec.models.Product;

//import java.util.List;

import com.rdec.models.User;

public interface UserDAO {
	public String addUser(User user);
	public User loginUser(User user);
	public String setLoginStatus(User user);
	public String addProduct(Product product);
	public List<Product> getProduct();
	public List<String> getCatagery();
	public List<User> getAll();
	public User getUserbyId(int id); 
	public String updateUser(User u);
	public String deleteUser(User user);
	//public Employee findById(int id);
	public String deleteProduct(Product product);
	public String delCart(int id);
	public String addCard(Card card);
	public List<Card> getCard(int uid);
}
