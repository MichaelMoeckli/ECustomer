package ch.bbw.ecustomer;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
@Repository
@RequestScope
public class CustomerDao implements Serializable{
	 
	private static Logger log = Logger.getLogger(CustomerDao.class.getSimpleName());
	 // Die Liste der Kunden
	 private List<Customer> customers = new ArrayList<Customer>();
	 // Die Datenbank connection
	 private Connection connection;
	
	
	
	 @PostConstruct
	 private void init() {
		 log.info("-------- MySQL JDBC Connection Testing ------------");
		
		 try {
			// Treiber-Klasse Laden
			Class.forName("com.mysql.jdbc.Driver");
			log.info("the driver is loaded");
		 } catch (ClassNotFoundException e) {
			 log.info("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		 }
		 
		 	log.info("MySQL JDBC Driver Registered!");
		 	connection = null;
		try {
			// Verbindung aufbauen
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_customer", "root", "");
		} catch (SQLException e) {
			log.info("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (connection != null) {
			log.info("You made it, take control your database now!");
		} else {
			log.info("Failed to make connection!");
		}
	 }
	 
	@PreDestroy
	public void destroy() {
		try {
		connection.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	public List<Customer> getCustomers() {
		// Hier kommt die Verarbeitung der Datenbank auslesen und anzeigen
		ResultSet rs = null;
		PreparedStatement pst = null;
		String stm = "Select * from customer where id=1";
		
		try {
			// Treiber-Klasse Laden
			Class.forName("com.mysql.jdbc.Driver");
			log.info("the driver is loaded");
		 } catch (ClassNotFoundException e) {
			 log.info("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		 }
		 
		 	log.info("MySQL JDBC Driver Registered!");
		 	connection = null;
		try {
			// Verbindung aufbauen
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_customer", "root", "");
		} catch (SQLException e) {
			log.info("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (connection != null) {
			log.info("You made it, take control your database now!");
		} else {
			log.info("Failed to make connection!");
		}	
		
		
		try {
			pst = connection.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				customer.setFirstname(rs.getString(2));
				customer.setLastname(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMessage(rs.getString(5));
				log.info("customer: "+customer);
				customers.add(customer);
			}
			// alle objecte schliessen
			pst.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}
	public void deleteCustomer() {
		customers.remove(0);
	}


}
