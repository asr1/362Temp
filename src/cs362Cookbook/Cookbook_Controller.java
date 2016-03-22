package cs362Cookbook;

import java.util.List;

import Interfaces.Cookbook_Controller_I;
import Interfaces.Cookbook_I;
import Interfaces.Ingredient_I;


public class Cookbook_Controller implements Cookbook_Controller_I
{
	
	private Cookbook_I cookbook;
	
	public Cookbook_Controller() {
		cookbook = new Cookbook();
	}
	
	//Returns the ID of the created recipe, or -1 if
	//The add failed.
	@Override
	public int addRecipe(String name, String author, List<Ingredient_I> ingredients, String instruction)
	{
		//TODO
		return -1;
	}
	
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeIngredient(String ing)
	{
		//TODO
		//Get ingredients from the database,
		//Ingredient ingredient = getfromdatabase(int)
		//Remove any that match ing for name.
		//If there aren't any, return false
		//Else if there are, continue to iterate
		//Iterate through each recipe that the ingredient has
		//List<Recipe> allRecipes = ingredient.getRecipes();
		//Each ingredient knows which recipes it exists in.
		
		//We'll have to eactually perform a get for each,
		//So it will look like this:
		
		//for(int i : allRecpies)
		//{Recipe r = getRecipeFromDatabase(i);
		//for(ingredient in : r)
		//{if ing.name.equal(ing)
		//{r.removeIngredient(i)}}}
		//Then return true
		
		//Then delete any ingredients with a name of ing from each ingredient
		//For(Recipe r : allRecipes)
		//for(Ingredient i : r)

		
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

	/**
	 * Takes a name and adds that ingredient to the cookbook. 
	 * Returns a boolean whether it was successful or not.
	 * 
	 * @param name
	 * @return boolean
	 */
	@Override
	public boolean addIngredient(String name) {
		return cookbook.addIngredient(name);
	}

	@Override
	public boolean discardRecipe() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Takes a ID number for a recipe and makes a duplicate of that recipe. 
	 * Returns the ID of the newly created recipe.
	 * 
	 * @param ID
	 * @return int
	 */
	@Override
	public int duplicateRecipe(int ID) {
		return cookbook.duplicateRecipe(ID);
	}

	@Override
	public boolean editRecipe(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceIngredient(String oName, String nName) {
		return cookbook.replaceIngredient(oName, nName);
	}

	@Override
	public boolean saveRecipe() {
		// TODO Auto-generated method stub
		return false;
	}


	
}
