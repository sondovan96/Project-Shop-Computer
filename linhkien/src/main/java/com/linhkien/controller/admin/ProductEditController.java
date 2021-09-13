package com.linhkien.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.linhkien.model.Category;
import com.linhkien.model.Product;
import com.linhkien.model.User;
import com.linhkien.service.CategoryService;
import com.linhkien.service.ProductService;
import com.linhkien.service.UserService;
import com.linhkien.service.impl.CategoryServiceImpl;
import com.linhkien.service.impl.ProductServiceImpl;
import com.linhkien.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/edit" })
public class ProductEditController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		List<Category> categories = categoryService.getAll();

		req.setAttribute("categories", categories);

		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/edit-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		diskFileItemFactory.setRepository(repository);
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.getFieldName().equals("id")) {
					product.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("name")) {
					product.setName(item.getString());

				} else if (item.getFieldName().equals("cate")) {
					product.setCategory(categoryService.get(item.getString()));
				} else if (item.getFieldName().equals("des")) {
					
					System.out.println("Description "+item.getString());
					product.setDes(item.getString());
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Long.parseLong(item.getString()));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {// neu co file d
						Path path = Paths.get(item.getName());
						String storePath = servletContext.getRealPath("/Images");
						File uploadFile = new File(storePath + "/" + path.getFileName());
						item.write(uploadFile);
						System.out.println(storePath + "/" + path.getName(0));
						System.out.println(uploadFile);				
						product.setImage(item.getName());
					}
					else
					{
						System.out.println(item.getName() + "k edit hinh");
						product.setImage(null);
					}
				}

			}
			productService.edit(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
