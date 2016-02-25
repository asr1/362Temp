package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;

public class Ingredient implements Ingredient_I
{
	String name;
	List<Recipe> recipes = new ArrayList<Recipe>();
	@Override
	public List<Recipe_I> getRecipes()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getName()
	{
		return name;
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
