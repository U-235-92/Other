package com.other.db;

import java.sql.Connection;

@FunctionalInterface
public interface Connector {

	Connection getConnection();
}
