package com.linhkien.controller.admin;


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

import com.linhkien.service.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryeListController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> cateList = cateService.getAll();
		req.setAttribute("catList", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-category.jsp");
		dispatcher.forward(req, resp);
	}

}
