package com.linhkien.dao;

import java.util.List;

import com.linhkien.model.Product;

public interface ProductDao {
	void insert(Product product);

	void edit(Product product);

	void delete(int id);

	Product get(int id);

	List<Product> getAll();

	List<Product> search(String username);
	
	List<Product> seachByCategory(int cate_id);
	
	List<Product> seachByName(String productName);
	int tongSoTrang(int soDongTrang);
	 List<Product> phanTrangProduct(int soDongTrang,int trang);
	 List<Product> getAllPage(String sql);
}
