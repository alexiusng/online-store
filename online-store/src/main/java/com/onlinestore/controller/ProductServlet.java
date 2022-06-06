package com.onlinestore.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestore.dao.ProductDAO;
import com.onlinestore.model.Product;


@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	
	public void init() {
		productDAO = new ProductDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/home":
				homepage(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertProduct(request, response);
				break;
			case "/delete":
				deleteProduct(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void homepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listProduct = productDAO.selectAllProducts();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product existingProduct = productDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		request.setAttribute("product", existingProduct);
		dispatcher.forward(request, response);

	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		Product newProduct = new Product(name, price);
		productDAO.insertProduct(newProduct);
		response.sendRedirect("list");
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));

		Product book = new Product(id, name, price);
		productDAO.updateProduct(book);
		response.sendRedirect("list");
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteProduct(id);
		response.sendRedirect("list");

	}

}
