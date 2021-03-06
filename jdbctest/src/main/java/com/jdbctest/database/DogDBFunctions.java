package com.jdbctest.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Dog;

public class DogDBFunctions {

	Setup sup = new Setup("root", "password", "jdbc:mysql://localhost:3306/dogs");

	// CREATE STATEMENT
	public void create(Dog dog) {
		Connection c1;
		try {
			System.out.println("Connecting... please wait");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("I have the access codes to the Xion Mainframe");

			System.out.println("Attempting to create dog " + dog.getName());
			Statement query = c1.createStatement();
			query.executeUpdate("INSERT INTO dog (dogName, breed, age, size) VALUES ('" + dog.getName() + "', '" + dog.getBreed() + "', "
					+ dog.getAge() + ", " + dog.getSize() + ");");
			System.out.println("Add complete");
			c1.close();

		} catch (SQLException exception) {
			System.out.println("Adding failed, check stack trace");
			exception.printStackTrace();
		}
	}
	
	
	// CREATE PREPARED STATEMENT
	public void createPrepared(Dog dog) {
		Connection c1;
		try {
			System.out.println("Connecting... please wait");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("I have the access codes to the Xion Mainframe");
			
			PreparedStatement query = c1.prepareStatement("INSERT INTO dog (dogName, breed, age, size) VALUES (?,?,?,?)");
			query.setString(1, dog.getName());
			query.setString(2, dog.getBreed());
			query.setInt(3, dog.getAge());
			query.setFloat(4, dog.getSize());	
			
			System.out.println("Attempting to insert " + dog.getName() + " into your database");
			query.execute();
			System.out.println("Query executed successfully");
			
		} catch (SQLException exception) {
			System.out.println("Adding failed, check stack trace");
			exception.printStackTrace();
		}
		
	}

	// DELETE STATEMENT
	public void delete(int id) {
		Connection c1;
		try {
			System.out.println("Connecting... please wait");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("I have the access codes to the Xion Mainframe");

			System.out.println("Attempting to delete entry " + id);
			Statement query = c1.createStatement();
			query.executeUpdate("DELETE FROM dog WHERE id = " + id);
			System.out.println("Deletion complete");
			c1.close();

		} catch (SQLException exception) {
			System.out.println("Delete failed, check stacktrace");
			exception.printStackTrace();
		}

	}
	
	// DELETE PREPARED STATEMENT
	public void deletePrepared(int id) {
		Connection c1;
		try {
			System.out.println("Connecting... please wait");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("I have access to their systems, we're good to go");
			
			PreparedStatement query = c1.prepareStatement("DELETE FROM dog WHERE id = ?");
			query.setInt(1, id);
			System.out.println("Attempting to delete entry number " + id);
			query.execute();
			System.out.println("Deletion complete");
			c1.close();
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	// UPDATE STATEMENT
	public void update(int id, Dog dog) {
		Connection c1;
		try {
			System.out.println("Connecting... please wait");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("I have the access codes to the Xion Mainframe");

		
			Statement query = c1.createStatement();
			System.out.println("Attempting to replace dog in position " + id );
			query.executeUpdate("UPDATE dog SET dogName = '" + dog.getName() + "', breed = '" + dog.getBreed() + "', age = "
					+ dog.getAge() + ", size = " + dog.getSize() + "WHERE id = " + id);
			System.out.println("Successfully replaced dog with " + dog.getName());
			c1.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

	}
	
	
	// UPDATE PREPARED STATEMENT
	public void updatePrepared(int id, Dog dog) {
		Connection c1;
		try {
			System.out.println("Connecting... please wait");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("I'm in");
			PreparedStatement query = c1.prepareStatement("UPDATE dog SET dogName = ?, breed = ?, age = ?, size = ? WHERE id = " + id);
			query.setString(1, dog.getName());
			query.setString(2, dog.getBreed());
			query.setInt(3, dog.getAge());
			query.setFloat(4, dog.getSize());
			System.out.println("Attempting to update table entry " + id);
			query.execute();
			System.out.println("It worked! Huzzah!");
			c1.close();
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	// RESULT SET
	public Dog dogResults(ResultSet results) throws SQLException{
		int id = results.getInt("id");
		String name = results.getString("dogName");
		String breed = results.getString("breed");
		int age = results.getInt("age");
		float size = results.getFloat("size");
		return new Dog (id, name, breed, age, size);
	}
	
	
	// READ ALL 
	public List<Dog> readAll() {
		Connection c1;
		try {
			System.out.println("Attempting connection...");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("Connection established");
			
			
			
			Statement query = c1.createStatement();
			ResultSet results = query.executeQuery("SELECT * FROM dog");
			
			List<Dog> dogs = new ArrayList();
			while (results.next()) {
				dogs.add(dogResults(results));
			}
			return dogs;
			
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	
	// READ BY ID
	public Dog readByID(int id) {
		Connection c1;
		try {
			System.out.println("Connecting... you know the drill by now");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("yayyyy....");
			
			
			Statement query = c1.createStatement();
			ResultSet results = query.executeQuery("SELECT * FROM dog WHERE ID = " + id);
			results.next();
			return dogResults(results);
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	//READ BY ID PREPARED
	public Dog readByIDPrepared(int id) {
		Connection c1;
		try {
			System.out.println("Connecting");
			c1 = DriverManager.getConnection(sup.getUrl(), sup.getUn(), sup.getPw());
			System.out.println("Yup");
			
			PreparedStatement query = c1.prepareStatement("SELECT * FROM dog WHERE ID = ?");
			query.setInt(1, id);
			ResultSet results = query.executeQuery();
			
			System.out.println("Attempting to read entry at " + id);
			results.next();
			System.out.println("Success");
			return dogResults(results);
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
