package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

public class Cookbook_Controller extends Cookbook
{
	
	//Returns the ID of the created recipe, or -1 if
	//The add failed.
	public int addRecipe(Recipe rec)
	{
		return -1;
	}
	

	
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeIngredient(String ing)
	{
		//TODO
		//Get ingredients from the database,
		//Remove any that match ing for name.
		//If there aren't any, return false
		//Else if there are, continue to iterate
		//Through each recipe (get ALL recipes from database)
		ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) getAllRecipes();
		//Then delete any ingredients with a name of ing from each ingredient
		//For(Recipe r : allRecipes)
		//for(Ingredient i : r)
		//{if i.name.equal(ing)
		//{r.removeIngredient(i)}}
		//Then return true
		
		
		return false;
	}
	
	//Takes the ID of the recipe to be removed.
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeRecipe(int id)
	{
		//TODO
		//Get the recipe ID from the database.
		//If(id is not in database)
		//{return false}
		//Else
		//database.remove(ID)
		//Return true
		
		return false;
	}
	
	//Returns all recipes from the database.
	private List<Recipe> getAllRecipes()
	{
		return null;
	}
}
