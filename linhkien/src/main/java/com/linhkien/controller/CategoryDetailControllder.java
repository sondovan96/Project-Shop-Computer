package com.linhkien.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linhkien.model.Category;
import com.linhkien.service.CategoryService;
import com.linhkien.service.ProductService;
import com.linhkien.service.impl.CategoryServiceImpl;


@WebServlet(urlPatterns="/category/detail")
public class CategoryDetailControllder extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category cat = categoryService.get(Integer.parseInt(id));

		req.setAttribute("category", cat);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/category-detail.jsp");
		dispatcher.forward(req, resp);
	}

}
