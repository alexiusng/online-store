package com.onlinestore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinestore.model.Product;


public class ProductDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
	private String jdbcProductname = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_PRODUCT_SQL = "INSERT INTO products" + "  (name, price) VALUES " + " (?, ?);";
	private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM products where id =?";
	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
	private static final String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE id = ?;";
	private static final String UPDATE_PRODUCT_SQL = "UPDATE products SET name = ?, price = ? WHERE id = ?;";

	public ProductDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcProductname, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertProduct(Product product) throws SQLException {
		System.out.println(INSERT_PRODUCT_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
				preparedStatement.setString(1, product.getName());
				preparedStatement.setDouble(2, product.getPrice());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Product selectProduct(int id) {
		Product product = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				product = new Product(id, name, price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return product;
	}

	public List<Product> selectAllProducts() {

		List<Product> products = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				products.add(new Product(id, name, price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return products;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateProduct(Product product) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
				statement.setString(1, product.getName());
				statement.setDouble(2, product.getPrice());
				statement.setInt(3, product.getId());

				rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
