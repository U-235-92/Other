package com.other.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DAOManager {

	private Connector simpleConnector = () -> {
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:src/com/other/db/books_db.db";
			Connection connection = DriverManager.getConnection(url);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	};

	@SuppressWarnings("unused")
	private Connector pooledConnector = () -> {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("org.sqlite.JDBC");
			cpds.setJdbcUrl("jdbc:sqlite:E:\\eclipse-workspace\\Other\\src\\com\\other\\db\\books_db.db");
			Connection connection = cpds.getConnection();
			return connection;
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	};

	public void addBooks(List<Book> books) {
		try (Connection connection = simpleConnector.getConnection()) {
			for (Book book : books) {
				ResultSet authorsGeneratedKeys = addAuthors(connection, book.getAuthors());
				addBook(connection, book);
				bindAuthorsAndBooks(connection, book.getIsbn(), authorsGeneratedKeys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ResultSet addAuthors(Connection connection, List<String> authors) throws SQLException {
		connection.setAutoCommit(false);
		String sql = "INSERT INTO Authors VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		for (String author : authors) {
			statement.setObject(1, null);
			statement.setString(2, author);
			statement.addBatch();
		}
		statement.executeBatch();
		ResultSet generatedKeys = statement.getGeneratedKeys();
		connection.setAutoCommit(true);
		statement.close();
		return generatedKeys;
	}

	private void addBook(Connection connection, Book book) throws SQLException, IOException {
		String sql = "INSERT INTO Books (isbn, title, price) VALUES (?, ?, ?)";
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, book.getIsbn());
		statement.setString(2, book.getTitle());
		statement.setDouble(3, book.getPrice());
		statement.executeUpdate();
//		connection.rollback();
		connection.commit();
		connection.setAutoCommit(true);
		statement.close();
	}

	private void bindAuthorsAndBooks(Connection connection, String isbn, ResultSet authorsGeneratedKeys)
			throws SQLException {
		connection.setAutoCommit(false);
		String sql = "INSERT INTO Author_Book VALUES (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		while (authorsGeneratedKeys.next()) {
			System.out.println(authorsGeneratedKeys.getInt(1));
			statement.setString(1, isbn);
			statement.setInt(2, authorsGeneratedKeys.getInt(1));
			statement.setObject(3, null);
			statement.addBatch();
		}
		statement.executeBatch();
		connection.setAutoCommit(true);
		statement.close();
	}

	public void addBook(Book book) {
		try (Connection connection = simpleConnector.getConnection()) {
			addBook(connection, book);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testRowSet() {
		CachedRowSet cachedRowSet = null;
		try (Connection connection = simpleConnector.getConnection()) {
			String sql = "SELECT * FROM Books";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			cachedRowSet = rowSetFactory.createCachedRowSet();
			cachedRowSet.populate(resultSet);
			cachedRowSet.setTableName("Books");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(cachedRowSet.next()) {
				String title = cachedRowSet.getString("title");
				System.out.println(title);
			}
			cachedRowSet.moveToInsertRow();
			cachedRowSet.updateString("isbn", "id-9999");
			cachedRowSet.updateString("title", "TEST");
			cachedRowSet.updateDouble("price", 99.99);
			cachedRowSet.insertRow();
			cachedRowSet.moveToCurrentRow();
			cachedRowSet.beforeFirst();
			System.out.println("Insert a new book:");
			while(cachedRowSet.next()) {
				String title = cachedRowSet.getString("title");
				System.out.println(title);
			}
			Connection tmpConnection = simpleConnector.getConnection();
			cachedRowSet.acceptChanges(tmpConnection);
			tmpConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
