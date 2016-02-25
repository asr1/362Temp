package cs362Cookbook;

import Interfaces.Cookbook_Controller_I;
import Interfaces.Cookbook_I;


public class Cookbook_Controller implements Cookbook_Controller_I
{
	
	private Cookbook_I cookbook;
	
	public Cookbook_Controller() {
		cookbook = new Cookbook();
	}
	
	//Returns the ID of the created recipe, or -1 if
	//The add failed.
	public int addRecipe(Recipe rec)
	{
		//TODO
		//Will pass each parameter of the recipe to the database with SQL.
		
		return -1;
	}
	
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeIngredient(String ing)
	{
		//TODO
		//Get ingredient from the database,
		//Ingredient ingredient = getfromdatabase(int)
		
		//Then, if that ingredient isn't null, remove it
		//From the database.
		//If it wasn't in the database, return false
		
		//Else continue to iterate
		//Iterate through each recipe that the ingredient has
		//List<Recipe> allRecipes = ingredient.getRecipes();
		//Each ingredient knows which recipes it exists in.
		
		//We'll have to actually perform a get for each,
		//So it will look like this:
		
		//for(int i : allRecpies)
		//{Recipe r = getRecipeFromDatabase(i);
		//for(ingredient in : r)
		//Then delete any ingredients with a name of ing from each recipe
		//{if ing.name.equal(ing)
		//{r.removeIngredient(i)}}}
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

	@Override
	public boolean addIngredient(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addRecipe(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean discardRecipe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int duplicateRecipe(int ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean editRecipe(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceIngredient(String oName, String nName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveRecipe() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
