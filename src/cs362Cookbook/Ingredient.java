package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Database_Support_I;
import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;

public class Ingredient implements Ingredient_I
{
	/**
	 * Stores the Database id
	 */
	private int id;
	
	/**
	 * Stores the name
	 */
	private String name;
	
	/**
	 * Stores the list of recipes' id
	 */
	private List<Integer> Recipes;
	
	/**
	 * Constructor for Ingredient
	 * 
	 * @param name
	 */
	public Ingredient(String name) {
		this.name = name;
		this.Recipes = new ArrayList<Integer>();
		this.id = -1;
	}
	
	/**
	 * Constructor for Database_Support
	 * @param id
	 * @param name
	 */
	public Ingredient(int id, String name, List<Integer> Recipes) {
		this(name);
		this.id = id;
		this.Recipes = Recipes;
	}
	
	@Override
	public List<Recipe_I> getRecipes(Database_Support_I db) {
		List<Recipe_I> result = new ArrayList<Recipe_I>();
		
		for(Integer i : Recipes) {
			result.add(db.getRecipe(i));
		}
		
		return result;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Integer getID() {
		return id;
	}
	
	@Override
	public boolean removeRecipe(Recipe_I R)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addRecipe(Recipe_I R)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
