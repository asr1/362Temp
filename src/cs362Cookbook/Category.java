package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Category_I;
import Interfaces.Ingredient_I;

public class Category implements Category_I
{
	String name;
	List<Recipe> recipes;
	
	/**
	 * Public constructor for a Category
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
		this.recipes = new ArrayList<Recipe>();
	}

	@Override
	public boolean removeRecipe(Recipe rec)
	{
		return recipes.remove(rec);
	}
}
