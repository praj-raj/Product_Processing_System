package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rdec.models.Card;
import com.rdec.models.Product;
import com.rdec.models.User;
import util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public String addUser(User user) {
		String res="FAIL";
	
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.getTransaction();
			tx.begin();
			System.out.println(user);
			session.save(user);
			tx.commit();
			res="SUCCESS";
			
		}
		catch(HibernateException e) {
			System.out.println(e);
			if(tx!=null) {
				tx.rollback();
			}
			
		}
		return res;
	}
	public User getUserbyId(int id)  {
		User result=null;
		Session session=null;
		session=HibernateUtil.getSessionFactory().openSession();
		Query  queary=session.createQuery("from User log where log.id=:id",User.class);
	
			queary.setParameter("id",id);
			
			result= (User)queary.getSingleResult();
			
		return result;
	}
	@Override
	public String updateUser(User u) {
		String res="FAIL";
		Session session=null;
		Transaction tx=null;
		
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.getTransaction();
			tx.begin();
			session.update(u);
			tx.commit();
			res="SUCCESS";
			
		}
		catch(HibernateException e) {
			System.out.println(e);
			if(tx!=null) {
				tx.rollback();
			}
			
		}
		return res;
	}/*
	@Override
	public Employee findById(int id) {
		Employee e=null;
		Session session=null;
		session=HibernateUtil.getSessionFactory().openSession();
		e=session.get(Employee.class,id);
		return e;
	}
	public String delete(Employee employee) {
		String res="FAIL";
		Session session=null;
		Transaction tx=null;
		
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.getTransaction();
			tx.begin();
			session.delete(employee);
			tx.commit();
			res="SUCCESS";
			
		}
		catch(HibernateException e) {
			System.out.println(e);
			if(tx!=null) {
				tx.rollback();
			}
			
		}
		return res;
	}*/
	@Override
	public String deleteUser(User user) {

		String res="FAIL";
		Session session=null;
		Transaction tx=null;
		
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.getTransaction();
			tx.begin();
			session.delete(user);
			tx.commit();
			res="SUCCESS";
			
		}
		catch(HibernateException e) {
			System.out.println(e);
			if(tx!=null) {
				tx.rollback();
			}
			
		}
		return res;
	
		}

	@Override
	public User loginUser(User user) {
		User result=null;
		Session session=null;
		session=HibernateUtil.getSessionFactory().openSession();
		Query  queary=session.createQuery("from User log where log.email=:username and log.pass=:upassword",User.class);
		//System.out.println(user.getName());
		System.out.println(user.getPass());
		queary.setParameter("username",user.getEmail());
		queary.setParameter("upassword",user.getPass());
			result= (User)queary.getSingleResult();
			
			
	//System.out.println(result.getName());
		return result;
	}
	public String setLoginStatus(User user) {
		String res="FAIL";
		Session session=null;
		Transaction tx=null;
		
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.getTransaction();
			tx.begin();
			session.update(user);
			tx.commit();
			res="SUCCESS";
			
		}
		catch(HibernateException e) {
			System.out.println(e);
			if(tx!=null) {
				tx.rollback();
			}
		}

		return res;
		}

	@Override
	public String addProduct(Product product) {
		String res="FAIL";
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.getTransaction();
			tx.begin();
			session.save(product);
			tx.commit();
			res="SUCCESS";
			
		}
		catch(HibernateException e) {
			System.out.println(e);
			if(tx!=null) {
				tx.rollback();
			}
			
		}
		return res;
	
	}
public List<Product> getProduct() {
	
	Session session=null;
	session=HibernateUtil.getSessionFactory().openSession();
	Query  queary=session.createQuery("from Product",Product.class);
	//queary.setParameter("c",cat);
	List<Product> result=queary.getResultList();
	for(Product i:result) {
	System.out.println(i.getPname()+" "+i.getPcatagery());}
	return result;
}
public List<String> getCatagery(){
	Session session=null;
	session=HibernateUtil.getSessionFactory().openSession();
	Query  queary=session.createQuery("select pcatagery from Product",Product.class);
	List<String> result=queary.getResultList();
	return result;
}
@Override
public List<User> getAll() {
	Session session=null;
	session=HibernateUtil.getSessionFactory().openSession();
	List<User> result=session.createQuery("from User",User.class).list();
	//List<User> result=queary.getResultList();
	return result;
}
@Override
public String addCard(Card card) {
	String res="FAIL";
	Session session=null;
	Transaction tx=null;
	try {
		session=HibernateUtil.getSessionFactory().openSession();
		tx= session.getTransaction();
		tx.begin();
		session.save(card);
		tx.commit();
		res="SUCCESS";
		
	}
	catch(HibernateException e) {
		System.out.println(e);
		if(tx!=null) {
			tx.rollback();
		}
		
	}
	return res;
}
@Override
public List<Card> getCard(int uid) {
	Session session=null;
	
	session=HibernateUtil.getSessionFactory().openSession();
	Query queary=session.createQuery("from Card where uid=:a",Card.class);
	queary.setParameter("a",uid);
	List<Card> result=queary.getResultList();
	System.out.println(uid);
	for(Card i:result) {
		System.out.println(i.getPid()+" "+i.getUid()+"     22222222225555");
	}
	System.out.println(result+"33333333");
	return result;
	

	// TODO Auto-generated method stub
	
}
@Override
public String deleteProduct(Product product) {
	String res="FAIL";
	Session session=null;
	Transaction tx=null;
	
	try {
		session=HibernateUtil.getSessionFactory().openSession();
		tx= session.getTransaction();
		tx.begin();
		session.delete(product);
		tx.commit();
		res="SUCCESS";
		
	}
	catch(HibernateException e) {
		System.out.println(e);
		if(tx!=null) {
			tx.rollback();
		}
		
	}
	return res;

}
@Override
public String delCart(int id) {
	String res="FAIL";
	Session session=null;
	Transaction tx=null;
	Card cart=new Card();
	cart.setId(id);
	try {
		session=HibernateUtil.getSessionFactory().openSession();
		tx= session.getTransaction();
		tx.begin();
		session.delete(cart);
		tx.commit();
		res="SUCCESS";
		
	}
	catch(HibernateException e) {
		System.out.println(e);
		if(tx!=null) {
			tx.rollback();
		}
		
	}
	return res;

	
}

	
	

}
