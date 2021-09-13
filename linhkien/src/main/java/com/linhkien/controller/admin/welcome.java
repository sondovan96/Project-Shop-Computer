package com.linhkien.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.linhkien.model.CartItem;
import com.linhkien.model.Category;
import com.linhkien.model.Product;
import com.linhkien.model.User;
import com.linhkien.service.CartItemService;
import com.linhkien.service.CategoryService;
import com.linhkien.service.ProductService;
import com.linhkien.service.UserService;
import com.linhkien.service.impl.CartServiceItemImpl;
import com.linhkien.service.impl.CategoryServiceImpl;
import com.linhkien.service.impl.ProductServiceImpl;
import com.linhkien.service.impl.UserServiceImpl;

@WebServlet(urlPatterns="/admin")
public class welcome extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	UserService userService = new UserServiceImpl();
	CartItemService cartItemService=new CartServiceItemImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj=session.getAttribute("account");
		User user=(User) obj;
		req.setAttribute("username", user.getUsername());
		
		List<Product> proList = productService.getAll();
		List<User> userList = userService.getAll();
		List<Category> catList = cateService.getAll();
		List<CartItem> cartItemList = cartItemService.getAll();
		
		System.out.println("Total user="+userList.size());
		System.out.println("Total product="+proList.size());
		System.out.println("Total category="+catList.size());
		System.out.println("Total cart item="+cartItemList.size());
		
		req.setAttribute("total_user", userList.size());
		req.setAttribute("total_pro", proList.size());
		req.setAttribute("total_cat", catList.size());
		req.setAttribute("total_cart", cartItemList.size());
		
		req.getRequestDispatcher("/view/admin/view/index.jsp").forward(req, resp);
	}

}
