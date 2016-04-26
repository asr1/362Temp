package cs362Cookbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Category_I;
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
 * CREATE TABLE `db362grp09`.`Ingredient` (
 * `id` INT NOT NULL AUTO_INCREMENT,
 * `name` CHAR(30) NULL,
 * PRIMARY KEY (`id`),
 * UNIQUE INDEX `id_UNIQUE` (`id` ASC));
 * 
 * CREATE TABLE `db362grp09`.`RtoI` (
 * `idRecipe` INT NOT NULL,
 * `idIgredient` INT NOT NULL,
 * PRIMARY KEY (`idRecipe`, `idIgredient`));
 * 
 * CREATE TABLE `db362grp09`.`Category` (
 * `id` INT NOT NULL AUTO_INCREMENT,
 * `name` CHAR(30) NULL,
 * PRIMARY KEY (`id`),
 * UNIQUE INDEX `id_UNIQUE` (`id` ASC));
 * 
 * CREATE TABLE `db362grp09`.`RtoC` (
 * `idRecipe` INT NOT NULL,
 * `idCategory` INT NOT NULL,
 * PRIMARY KEY (`idRecipe`, `idCategory`));
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
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception E) {
			System.err.println("Unable to load driver.");
			E.printStackTrace();
		}

		// Setup the connection
		try {
			database = DriverManager.getConnection(url, user, password);
			query = database.createStatement();
		} catch (SQLException e) {
			System.err.println("Unable to make connection.");
			e.printStackTrace();
		}
	}
	

	
	@Override
	public int putRecipe(Recipe_I R) {
		int id = -1;
		
		try {
			
			if(R.getID() == -1) {
				// INSERT
				query.executeQuery("Insert into db362grp09.Recipe" + 
					"(name)" + 
					"Values" +
					"(" + R.getName() +")");
				
				ResultSet r;
				
				r = query.executeQuery("Select id" +
					"From db362grp09.Recipe" +
					"Where name = " + R.getName());
				
				id = r.getInt(1);
				
				for(Integer I : R.getIngredients()) {
					query.executeQuery("Insert into db362grp09.RtoI" +
						"(idRecipe, idIgredient)" +
						"Values" +
						"(" + R.getID() + ", " + I + ")");
				}
			}
		
			else {
				// UPDATE
				for(Integer I : R.getIngredients()) {
					query.executeQuery("Insert into db362grp09.RtoI" +
						"(idRecipe, idIgredient)" +
						"Values" +
						"(" + R.getID() + ", " + I + ")");
				}
			}
			
		} catch (SQLException e) {
			return -1;
		}
		
		return id;
	}

	@Override
	public Recipe_I getRecipe(int ID) {
		Recipe_I result;
		
		try {
			
			ResultSet r = query.executeQuery("Select name" +
					"From db362grp09.Recipe" +
					"Where id = " + ID);
			
			String author = r.getString(1);
			String name = r.getString(2);
			String instruction = r.getString(3);
			boolean favorite  = Integer.parseInt(r.getString(4)) > 0;
			
			r = query.executeQuery("Select idIgredient" +
					"From db362grp09.RtoI" +
					"Where idRecipe = " + ID);
			
			
			List<Integer> ingredients = new ArrayList<Integer>();
			
			while(r.next()) {
				ingredients.add(r.getInt(1));
			}
			
			result = new Recipe(name, author, ingredients, instruction, favorite);

			
		} catch (SQLException e) {
			result = null;
		}
				
		return result;

		
	}

	@Override
	public boolean deleteRecipe(Recipe_I R) {
		try {
			
			query.executeQuery("Delete from db362grp09.RtoI" +
					"Where idRecipe = " + R.getID());
			
			query.executeQuery("Delete from db362grp09.Recipe" +
					"Where id = " + R.getID());
			
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean putIngredient(Ingredient_I I) {		
		try {
			
			if(I.getID() == -1) {
				// INSERT
				query.executeQuery("Insert into db362grp09.Ingredient" + 
					"(name)" + 
					"Values" +
					"(" + I.getName() +")");
				
				ResultSet r;
				
				r = query.executeQuery("Select id" +
					"From db362grp09.Ingredient" +
					"Where name = " + I.getName());
				
				int id = r.getInt(1);
				
				for(Recipe_I R : I.getRecipes(this)) {
					query.executeQuery("Insert into db362grp09.RtoI" +
						"(idRecipe, idIgredient)" +
						"Values" +
						"(" + R.getID() + ", " + id + ")");
				}
			}
		
			else {
				// UPDATE
				for(Recipe_I R : I.getRecipes(this)) {
					query.executeQuery("Insert into db362grp09.RtoI" +
						"(idRecipe, idIgredient)" +
						"Values" +
						"(" + R.getID() + ", " + I.getID() + ")");
				}
			}
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Ingredient_I getIngredient(String name) {
		
		Ingredient_I result;
		
		try {
			
			ResultSet r = query.executeQuery("Select id" +
					"From db362grp09.Ingredient" +
					"Where name = " + name);
			
			int id = r.getInt(1);
			
			r = query.executeQuery("Select idRecipe" +
					"From db362grp09.RtoI" +
					"Where idIgredient = " + id);
			
			List<Integer> Recipes = new ArrayList<Integer>();
			
			while(r.next()) {
				Recipes.add(r.getInt(1));
			}
			
			result = new Ingredient(id, name, Recipes);
			
		} catch (SQLException e) {
			result = null;
		}
				
		return result;
	}
	
	@Override
	public Ingredient_I getIngredient(int id) {
		
		Ingredient_I result;
		
		try {
			
			ResultSet r = query.executeQuery("Select name" +
					"From db362grp09.Ingredient" +
					"Where id = " + id);
			
			String name = r.getString(1);
			
			r = query.executeQuery("Select idRecipe" +
					"From db362grp09.RtoI" +
					"Where idIgredient = " + id);
			
			List<Integer> Recipes = new ArrayList<Integer>();
			
			while(r.next()) {
				Recipes.add(r.getInt(1));
			}
			
			result = new Ingredient(id, name, Recipes);
			
		} catch (SQLException e) {
			result = null;
		}
				
		return result;
	}

	@Override
	public boolean deleteIngredient(Ingredient_I I) {
		try {
			
			query.executeQuery("Delete from db362grp09.RtoI" +
					"Where idIgredient = " + I.getID());
			
			query.executeQuery("Delete from db362grp09.Ingredient" +
					"Where id = " + I.getID());
			
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean putCategory(Category_I C) {
		try {
			
			if(C.getID() == -1) {
				// INSERT
				query.executeQuery("Insert into db362grp09.Category" + 
					"(name)" + 
					"Values" +
					"(" + C.getName() +")");
				
				ResultSet r;
				
				r = query.executeQuery("Select id" +
					"From db362grp09.Category" +
					"Where name = " + C.getName());
				
				int id = r.getInt(1);
				
				for(Recipe_I R : C.getRecipes(this)) {
					query.executeQuery("Insert into db362grp09.RtoC" +
						"(idRecipe, idCategory)" +
						"Values" +
						"(" + R.getID() + ", " + id + ")");
				}
			}
		
			else {
				// UPDATE
				for(Recipe_I R : C.getRecipes(this)) {
					query.executeQuery("Insert into db362grp09.RtoC" +
						"(idRecipe, idCategory)" +
						"Values" +
						"(" + R.getID() + ", " + C.getID() + ")");
				}
			}
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Category_I getCategory(String name) {

		Category_I result;
		
		try {
			
			ResultSet r = query.executeQuery("Select id" +
					"From db362grp09.Category" +
					"Where name = " + name);
			
			int id = r.getInt(1);
			
			r = query.executeQuery("Select idRecipe" +
					"From db362grp09.RtoC" +
					"Where idCategory = " + id);
			
			List<Integer> Recipes = new ArrayList<Integer>();
			
			while(r.next()) {
				Recipes.add(r.getInt(1));
			}
			
			result = new Category(id, name, Recipes);
			
		} catch (SQLException e) {
			result = null;
		}
				
		return result;
	}



	@Override
	public Category_I getCategory(int id) {
		
		Category_I result;
		
		try {
			
			ResultSet r = query.executeQuery("Select name" +
					"From db362grp09.Category" +
					"Where id = " + id);
			
			String name = r.getString(1);
			
			r = query.executeQuery("Select idRecipe" +
					"From db362grp09.RtoC" +
					"Where idCategory = " + id);
			
			List<Integer> Recipes = new ArrayList<Integer>();
			
			while(r.next()) {
				Recipes.add(r.getInt(1));
			}
			
			result = new Category(id, name, Recipes);
			
		} catch (SQLException e) {
			result = null;
		}
				
		return result;
	}



	@Override
	public List<Recipe_I> getAllRecipes() {
		
		List<Recipe_I> result = new ArrayList<Recipe_I>();
		
		try {
			
			ResultSet r = query.executeQuery("Select id" +
					"From db362grp09.Recipe");
			
			while(r.next()) {
				result.add(this.getRecipe(r.getInt(1)));
			}
			
		} catch (SQLException e) {
			result = null;
		}
				
		return result;
		
	}
}
