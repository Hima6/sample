package com.sample.project.expensereport.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitializeConfig {

	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void initialize(){
	/*	try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE IF EXISTS UserLogin");
			statement.executeUpdate(
					"CREATE TABLE expense(" +
					"id INTEGER Primary key, " +
					"billType varchar(30) not null," +
					"amount varchar(30) ," +
					"created_date timestamp) "  
					);
		
			statement.close();
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}
