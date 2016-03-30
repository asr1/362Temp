package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Category_I;
import Interfaces.Ingredient_I;

public class Category implements Category_I
{
	String name;
	List<Recipe> recipes = new ArrayList<Recipe>();

	@Override
	public boolean removeRecipe(Recipe rec)
	{
		return recipes.remove(rec);
	}
}
