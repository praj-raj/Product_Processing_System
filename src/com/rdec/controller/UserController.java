package com.rdec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdec.models.Card;
import com.rdec.models.Product;
//import com.rdec.dao.UserDAOImpl;
import com.rdec.models.User;
import com.rdec.services.UserService;
import com.rdec.services.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("111111111111111");
		User result1 = null;

		UserService obj = new UserServiceImpl();
		String action = request.getParameter("action");
		System.out.println("Action " + action);
		RequestDispatcher rd = null;

	
		 if (action.equals("insert")) {
			System.out.println("2222222222222");
			String email = request.getParameter("name");
			
			String pass = request.getParameter("password");
			byte b=0;
			User user=new User(email,pass,b,'U');
			String result = obj.addUser(user);
			System.out.println("Result " + result);
			if (result.equals("SUCCESS")) {

				rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Registration Successfull");
			} else if (result.equals("FAIL")) {

				rd = request.getRequestDispatcher("Registration.jsp");
				request.setAttribute("msg", "Registration Fail");
			} else {

				rd = request.getRequestDispatcher("Registration.jsp");
				request.setAttribute("msg", "Registration Fail");
			}

		} else if (action.equals("login")) {
			String email = request.getParameter("name");
			String pass = request.getParameter("password");
			User user = new User();
			user.setEmail(email);
			user.setPass(pass);
			result1 = obj.loginUser(user);
			if (result1 != null && result1.getUserType() =='U') {
				byte status = 1;
				result1.setLoginStatus(status);
				String res = obj.setLoginStatus(result1);
				//List<Product> a = obj.getProduct();
				if (res.equals("SUCCESS")) {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", result1);
					//session.setAttribute("var", result1.getName());
					List<Card> a=obj.getCard(result1.getId());
					System.out.println();
					rd = request.getRequestDispatcher("index1.jsp");
					request.setAttribute("use", result1.getEmail());
					session.setAttribute("a", a);
				} else if (res.equals("FAIL")) {

					rd = request.getRequestDispatcher("Logout.jsp");
					request.setAttribute("msg", "Login Fail");
				} else {

					rd = request.getRequestDispatcher("Logout.jsp");
					request.setAttribute("msg", "Login Fail");
				}

			} else if (result1 != null && result1.getUserType() == 'A') {
				System.out.println("admin");
				byte status = 1;
				result1.setLoginStatus(status);
				System.out.println(result1+"aaaaabbbbbbb");
				String res = obj.setLoginStatus(result1);
				System.out.println(res);
				List<Product> a = obj.getProduct();
				System.out.println("ok");
				if (res.equals("SUCCESS")) {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", result1);
					
					System.out.println("isNew: " + session.isNew());
					
					session.setMaxInactiveInterval(500);
					System.out.println("session 1:" + session.getId());
					//session.setAttribute("var", result1.getName());
					rd = request.getRequestDispatcher("admin.jsp");
					request.setAttribute("list", a);
				} else if (res.equals("FAIL")) {

					rd = request.getRequestDispatcher("admin.jsp");
					request.setAttribute("msg", "Login Fail");
				} else {

					rd = request.getRequestDispatcher("admin.jsp");
					request.setAttribute("msg", "Login Fail");
				}
			}

		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			 result1 = (User) session.getAttribute("user");
			
			if (result1 != null) {
				byte status = 0;
				result1.setLoginStatus(status);
				
				obj.setLoginStatus(result1);
				System.out.println("isNew: " + session.isNew());

				session.invalidate();

			
				// session=null;
				rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Login Fail");

			}
		}
	
				else if (action.equals("insertProduct")) {
			
			String name = request.getParameter("name");
			String catr = request.getParameter("catagery");
			int price = Integer.parseInt(request.getParameter("price"));
			int quant = Integer.parseInt(request.getParameter("quantity"));
			String im = request.getParameter("image");
			int price1 = Integer.parseInt(request.getParameter("sprice"));
			File image = new File(im);
			FileInputStream imag = new FileInputStream(image);
			byte[] b = new byte[(int) image.length()];
			imag.read(b);
			imag.close();
			Product product = new Product(name, catr, price,price1, quant, b);
				//product.setSprice(price1);
			String result = obj.addProduct(product);
			System.out.println(result);
			if (result.equals("SUCCESS")) {

				rd = request.getRequestDispatcher("admin2.jsp");
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				System.out.println("User ="+user);
				request.setAttribute("list",user);
				rd = request.getRequestDispatcher("Product.jsp");
				request.setAttribute("msg", "Prodact Add Succesfull");
			} else if (result.equals("FAIL")) {

				rd = request.getRequestDispatcher("Product.jsp");
				request.setAttribute("msg", "Registration Fail");
			} else {

				rd = request.getRequestDispatcher("Product.jsp");
				request.setAttribute("msg", "Registration Fail");
			}

		} else if (action.equals("displayAll")) {
			List<User> list = obj.getAllUser();
			System.out.println("success");

			rd = request.getRequestDispatcher("displayAll.jsp");
			request.setAttribute("list", list);

		}else if(action.equals("searchByIdFordelete")) { String id =
				  request.getParameter("id"); int i = Integer.parseInt(id); User user = new
					 User(); user.setId(i); System.out.println("Result" + obj.deleteUser(user));
					  rd = request.getRequestDispatcher("UserController?action=displayAll");
					  
					 }
		else if(action.equals("delP")) {
			 String i=request.getParameter("pid");
			 int id=Integer.parseInt(i);
			 Product product=new Product();
			 product.setId(id);
			 obj.deleteProduct(product);
			 rd=request.getRequestDispatcher("admin.jsp");
			 
		 }

		/*
		 * else if (action.equals("delete")) { String id = request.getParameter("id");
		 * int i = Integer.parseInt(id); User user = new User(); user.setId(i);
		 * System.out.println("Result" + obj.deleteUser(user));
		 */ 
		 
		
		else if (action.equals("update")) {
			String id = request.getParameter("id");
			char ut=request.getParameter("type").charAt(0); 
			System.out.println(id);
		
		
		String email = request.getParameter("email");
		
		String pass = request.getParameter("password");
		
		User user = new User();
		
		user.setId(Integer.parseInt(id));
		user.setUserType(ut);
		user.setEmail(email);
		user.setPass(pass);
	
		  System.out.println("Result " + obj.updateUser(user)); 
		  rd =request.getRequestDispatcher("UserController?action=displayAll");
		}
		  
		 else if (action.equals("searchByIdForUpdate")) { String id =
		  request.getParameter("id");
		   System.out.println(id);
		  User u =obj.getUserbyId(Integer.parseInt(id)); 
		  System.out.println("1111999");
		  rd =request.getRequestDispatcher("updateUser.jsp"); 
		  request.setAttribute("user", u); 
		  }
		  else if (action.equals("SearchById")) { String id =
		  request.getParameter("id"); User user =
		  obj.getUserbyId(Integer.parseInt(id)); rd =
		  request.getRequestDispatcher("display.jsp"); 
		  request.setAttribute("user",user);
		  }
		  else if (action.equals("Catagery")) {
			  System.out.println("787878");
			  List<Product> b = obj.getProduct();
			  String Catagery=request.getParameter("Catagery");
			  List<Product> a = new ArrayList<Product>();
			  if(Catagery.equals("Men")) {
				  
				  for(Product p:b) {
					  if(p.getPcatagery().equals("Men's Wear")) {
						  a.add(p);
					  }
				  }
				 
			  rd=request.getRequestDispatcher("NewFile.jsp"); 
			  request.setAttribute("list",a);
			  }else if(Catagery.equals("Women")) {
				  for(Product p:b) {
					  if(p.getPcatagery().equals("Women's Wear")) {
						  a.add(p);
					  }
				  }
				  rd=request.getRequestDispatcher("Womens.jsp"); 
				  request.setAttribute("list",a);
			  }
			  else if(Catagery.equalsIgnoreCase("Electronics")) {
				  for(Product p:b) {
					  if(p.getPcatagery().equals("Electronics")) {
						  a.add(p);
					  }
				  }
				  rd=request.getRequestDispatcher("electronics.jsp"); 
				  request.setAttribute("list",a);

			  }
			  

			  
		  }
		  else if (action.equals("Search")) {
				String search = request.getParameter("ser");
				String catr = request.getParameter("country");
				System.out.println(search);
				System.out.println(catr); 
				  rd=request.getRequestDispatcher("Product1.jsp"); 
				  request.setAttribute("a",search);
				  request.setAttribute("b",catr);

		  }
		  else if(action.equals("cart")) {
			  String Pid = request.getParameter("Pid");
				String Uid = request.getParameter("Uid");
				int pid=Integer.parseInt(Pid);
				int uid=Integer.parseInt(Uid);
				Card card=new Card(uid,pid);
				System.out.println(obj.addCard(card)+" yyyyyyyyyyyyy");
				List<Card> a=obj.getCard(uid);
			
				 
				  rd=request.getRequestDispatcher("checkout.jsp"); 
				  request.setAttribute("emp", a);
			  
		  }
		  else if(action.equals("del")) {
			  System.out.println(request.getParameter("id"));
			  
			  int id=Integer.parseInt(request.getParameter("id"));
				HttpSession session = request.getSession();
				User u=(User)session.getAttribute("user");
				
			String s=  obj.delCart(id);
			List<Card> a=obj.getCard(u.getId());
			  System.out.println(s+" 258258");
			  rd=request.getRequestDispatcher("checkout.jsp"); 
			  request.setAttribute("emp", a);
		  }
		 /* } else if (action.equals("SearchByName")) { String name =
		 * request.getParameter("name"); User user = obj.getUserbyName(name); rd =
		 * request.getRequestDispatcher("display.jsp"); request.setAttribute("user",
		 * user); } else if (action.equals("displayAll")) { List<User> list =
		 * obj.getAllUser(); System.out.println("success");
		 * 
		 * rd = request.getRequestDispatcher("displayAll.jsp");
		 * request.setAttribute("list", list);
		 * 
		 * }
		 */
		rd.forward(request, response);

	}

}
