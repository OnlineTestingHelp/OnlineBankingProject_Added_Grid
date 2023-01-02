package com.obs.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBConnectToMySQL {

	@Test
	public void DBConnect() {

		Connection connection = null;
		try {
			// below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root@123");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM store.customers;");
			int customer_Id;
			String Name;
			while (resultSet.next()) {
				customer_Id = resultSet.getInt("customer_id");
				Name = resultSet.getString("first_name").trim();
				System.out.println("CustomerID : " + customer_Id + " Name : " + Name);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
