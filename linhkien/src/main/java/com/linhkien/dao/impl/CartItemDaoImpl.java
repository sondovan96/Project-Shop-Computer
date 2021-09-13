package com.linhkien.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.linhkien.dao.CartItemDao;
import com.linhkien.dao.UserDao;
import com.linhkien.jdbc.JDBCConnection;
import com.linhkien.model.Cart;
import com.linhkien.model.CartItem;
import com.linhkien.model.Product;
import com.linhkien.model.User;
import com.linhkien.service.CartService;
import com.linhkien.service.ProductService;
import com.linhkien.service.impl.CartServiceImpl;
import com.linhkien.service.impl.ProductServiceImpl;


public class CartItemDaoImpl extends JDBCConnection implements CartItemDao {
	CartService cartService = new CartServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserDao userDao = new UserDaoImpl();
	
	
	@Override
	public void insert(CartItem cartItem) {
		String sql = "INSERT INTO cart_item(id,quantity,unit_price,pro_id,cat_id) VALUES (?,?,?,?,?)";
		Connection con = null;
		try {
			con = super.getJDBCConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cartItem.getId());
			ps.setString(5, cartItem.getCart().getId());
			ps.setInt(4, cartItem.getProduct().getId());
			ps.setInt(2, cartItem.getQuantity());
			ps.setLong(3, cartItem.getUnitPrice());

			ps.executeUpdate();

//			ResultSet generatedKeys = ps.getGeneratedKeys();
//			if (generatedKeys.next()) {
//				int id = generatedKeys.getInt(1);
//				cartItem.setId(id);
//			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartItem cartItem) {
		String sql = "UPDATE cart_item SET cat_id = ?, pro_id = ?, quantity = ?, unit_price=? WHERE id = ?";
		Connection con = null;
		try {
			con = super.getJDBCConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cartItem.getCart().getId());
			ps.setInt(2, cartItem.getProduct().getId());
			ps.setInt(3, cartItem.getQuantity());
			ps.setLong(4, cartItem.getUnitPrice());
			ps.setString(5, cartItem.getId());
			
			
			ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM cart_item WHERE id = ?";
		Connection con = null;
		try {
			con = super.getJDBCConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CartItem get(int id) {
		String sql = "SELECT " + 
				"cart_item.id, " + 
				"cart_item.quantity, " + 
				"cart_item.unit_price, " + 
				"cart.u_id, " + 
				"cart.buyDate, " + 
				"product.name, " + 
				"product.price " + 
				"FROM cart_item " + 
				"INNER JOIN cart " + 
				"ON cart_item.cart_id = cart.id " + 
				"INNER JOIN product " + 
				"ON cart_item.pro_id = product.id " +
				"WHERE cart_item.id = ?";
		Connection con = null;
		try {
			con = super.getJDBCConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = userDao.get(rs.getInt("u_id"));
				
				Cart cart = new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getLong("unit_price"));
				
				
				return cartItem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartItem> getAll() {
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		String sql = "SELECT " + 
				"cart_item.id, " + 
				"cart_item.quantity, " + 
				"cart_item.unit_price, " + 
				"cart.u_id, " + 
				"cart.buyDate, " + 
				"product.name, " + 
				"product.price " + 
				"FROM cart_item " + 
				"INNER JOIN Cart " + 
				"ON cart_item.cat_id = cart.id " + 
				"INNER JOIN Product " + 
				"ON cart_item.pro_id = product.id ";
		Connection con = null;
		try {
			con = super.getJDBCConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = userDao.get(rs.getInt("u_id"));
				
				Cart cart = new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getString("id"));
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getLong("unit_price"));

				cartItemList.add(cartItem);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartItemList;
	}

	public List<CartItem> search(String name) {
		return null;
	}

	@Override
	public CartItem get(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
