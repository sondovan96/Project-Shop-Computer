package com.linhkien.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.linhkien.model.Product;
import com.linhkien.model.User;
import com.linhkien.service.CategoryService;
import com.linhkien.service.ProductService;

import com.linhkien.service.impl.CategoryServiceImpl;
import com.linhkien.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/product/list" })
public class ProductListClientController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = productService.getAll();
		req.setAttribute("productList", productList);
		
		int tongSoTrang=productService.tongSoTrang(5);
		int trang;
		if (req.getParameter("trang")==null) 
			trang=1;
		else
			trang=Integer.parseInt(req.getParameter("trang"));
		List<Product> dsma=productService.phanTrangProduct(5,trang);
		req.setAttribute("trang", trang);
		req.setAttribute("tongSoTrang", tongSoTrang);
		req.setAttribute("dsma", dsma);
		
		//Get session username
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/product-list.jsp");
		dispatcher.forward(req, resp);
	}

}
