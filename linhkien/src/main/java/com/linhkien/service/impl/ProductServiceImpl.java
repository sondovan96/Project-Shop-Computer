package com.linhkien.service.impl;

import java.io.File;
import java.util.List;


import com.linhkien.dao.ProductDao;

import com.linhkien.dao.impl.ProductDaoImpl;

import com.linhkien.model.Product;

import com.linhkien.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();

	@Override
	public void insert(Product product) {
		productDao.insert(product);

	}

	@Override
	public void edit(Product newProduct) {
		
		Product oldProduct = productDao.get(newProduct.getId());

		oldProduct.setName(newProduct.getName());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setCategory(newProduct.getCategory());
		oldProduct.setDes(newProduct.getDes());
		if (newProduct.getImage() != null) {
			oldProduct.setImage(newProduct.getImage());
		}
		
		productDao.edit(oldProduct);

	}

	@Override
	public void delete(int id) {
		productDao.delete(id);

	}

	@Override
	public Product get(int id) {
		return productDao.get(id);
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public List<Product> search(String product) {
		return productDao.search(product);
	}

	@Override
	public List<Product> seachByCategory(int cate_id) {
		return productDao.seachByCategory(cate_id);
	}

	@Override
	public List<Product> seachByName(String productName) {
		return productDao.seachByName(productName);
	}
	@Override
	public int tongSoTrang(int soDongTrang)
	{
		return productDao.tongSoTrang(soDongTrang);
	}
	@Override
	public List<Product> phanTrangProduct(int soDongTrang,int trang)
	{
		return productDao.phanTrangProduct(soDongTrang, trang);
	}
	@Override
	public List<Product> getAllPage(String sql)
	{
		return productDao.getAllPage(sql);
	}

}
