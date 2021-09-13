package com.linhkien.controller;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.linhkien.model.Cart;
import com.linhkien.model.User;
import com.linhkien.model.CartItem;
import com.linhkien.service.CartItemService;
import com.linhkien.service.CartService;
import com.linhkien.service.UserService;
import com.linhkien.service.impl.CartServiceImpl;
import com.linhkien.service.impl.CartServiceItemImpl;
import com.linhkien.service.impl.UserServiceImpl;
import com.linhkien.tool.SendMail;
import com.linhkien.util.RandomUUID;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartServiceItemImpl();
	long time = System.currentTimeMillis();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("account");
		User buyer = (User) obj;
		Cart cart = new Cart();
		cart.setBuyer(buyer);
		cart.setBuyDate(new java.sql.Date(time));
		cart.setId(RandomUUID.getRandomID());
		cartService.insert(cart);

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			// ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

			for (CartItem cartItem : map.values()) {
				cartItem.setCart(cart);
				cartItem.setId(RandomUUID.getRandomID());
				SendMail sm = new SendMail();
				
				cartItemService.insert(cartItem);
				
			}
			System.out.println("**********inserted oder to db***********");

		}
		session.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
