package com.other.spring_fast.chapter_12.db.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.other.spring_fast.chapter_12.db.model.Purchase;

@Repository
public class PurchaseRepository {

	private final JdbcTemplate jdbc;

	public PurchaseRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	public void storePurchase(Purchase purchase) {
		String sql = "INSERT INTO purchase(product, price) VALUES (?, ?)";
		jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
	}
	
	public List<Purchase> findAllPurchases() {
		String sql = "SELECT * FROM purchase";
		RowMapper<Purchase> purchaseRowMapper = (resultSet, numberOfRow) -> {
			Purchase rowObject = new Purchase();
			rowObject.setId(resultSet.getInt("id"));
			rowObject.setProduct(resultSet.getString("product"));
			rowObject.setPrice(resultSet.getBigDecimal("price"));
			return rowObject;
		};
		return jdbc.query(sql, purchaseRowMapper);
	}
}
