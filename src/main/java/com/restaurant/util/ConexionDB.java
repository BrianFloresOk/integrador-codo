package com.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	private static final String URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=yes&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al establecer la conexión a la base de datos");
		}

	}

	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
