package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Category_I;
import Interfaces.Database_Support_I;
import Interfaces.Recipe_I;

public class Category implements Category_I
{
	String name;
	int id;
	List<Integer> Recipes;
	
	/**
	 * Public constructor for a Category
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
		this.Recipes = new ArrayList<Integer>();
		this.id = -1;
	}
	
	/**
	 * Constructor for Database_Support
	 * @param id
	 * @param name
	 */
	public Category(int id, String name, List<Integer> Recipes) {
		this(name);
		this.id = id;
		this.Recipes = Recipes;
	}
	

	@Override
	public boolean removeRecipe(Recipe_I R) {
		Integer i = R.getID();
		return Recipes.remove(i);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getID() {
		return id;
	}

	@Override
	public List<Recipe_I> getRecipes(Database_Support_I db) {
		List<Recipe_I> result = new ArrayList<Recipe_I>();
		
		for(Integer i : Recipes) {
			result.add(db.getRecipe(i));
		}
		
		return result;
	}

	@Override
	public boolean addRecipe(Recipe_I R) {
		return Recipes.add(R.getID());
	}

	@Override
	public boolean compare(Category_I C) {
		if(C == null) {
			return true;
		}
		else {
			return name.compareTo(C.getName()) < 0;
		}
	}
}
