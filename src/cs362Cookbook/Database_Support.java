package cs362Cookbook;

import java.sql.*;

import Interfaces.Database_Support_I;
import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;

/*
 * Needed Tables
 * 
 * CREATE TABLE `db362grp09`.`Recipe` (
 * `id` INT NOT NULL AUTO_INCREMENT,
 * `author` CHAR(30) NULL,
 * `name` CHAR(30) NULL,
 * `instruction` CHAR(250) NULL,
 * `favorite` TINYINT NULL DEFAULT 0,
 * PRIMARY KEY (`id`),
 * UNIQUE INDEX `id_UNIQUE` (`id` ASC));
 * 
 * 
 */

public class Database_Support implements Database_Support_I {
	
	private final String url = "jdbc:mysql://mysql.cs.iastate.edu/db362grp09";
	private final String user = "dbu362grp09";
	private final String password = "kpeq8ggdry4";
	
	/**
	 * The connection to the database
	 */
	private Connection database = null;
	
	/**
	 * The query object
	 */
	private Statement query = null;
	
	/**
	 * Makes the connection to the database
	 */
	public Database_Support() {
		
		// Load the driver 
	    try {   
	         // Load the driver (registers itself)
	         Class.forName ("com.mysql.jdbc.Driver"); 
	    } catch (Exception E) {
	    	System.err.println ("Unable to load driver.");
	    	E.printStackTrace ();
	    }
	    
	    // Setup the connection
	    try {
			database = DriverManager.getConnection (url, user, password);
			query = database.createStatement();
		} catch (SQLException e) {
			System.err.println("Unable to make connection.");
			e.printStackTrace();
		}
	}

	@Override
	public int putRecipe(Recipe_I R) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Recipe_I getRecipe(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRecipe(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putIngredient(Ingredient_I I) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ingredient_I getIngredient(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteIngredient(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
