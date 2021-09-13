package com.linhkien.controller.admin;

import java.io.IOException;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.linhkien.model.CartItem;
import com.linhkien.service.CartItemService;
import com.linhkien.service.CartService;

import com.linhkien.service.impl.CartServiceImpl;
import com.linhkien.service.impl.CartServiceItemImpl;


@WebServlet(urlPatterns = { "/admin/order/list" })
public class OrderListController extends HttpServlet {
	CartItemService cartItemService = new CartServiceItemImpl();
	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CartItem> listCartItem = cartItemService.getAll();
		req.setAttribute("listCartItem", listCartItem);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-order.jsp");
		dispatcher.forward(req, resp);
	}

}
