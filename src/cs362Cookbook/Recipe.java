package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;
public class Recipe implements Recipe_I
{
	int id;
	boolean isFavorite;
	String author;
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	List<Category> categories = new ArrayList<Category>();
	String name;
	Rating rating = Rating.NONE;
	
	@Override
	public boolean editRecipe(int ID)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean discardRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Recipe_I copyRecipe()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addIngredient(Ingredient_I I)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeIngredient(Ingredient_I I)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Ingredient_I> getIngredients()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}