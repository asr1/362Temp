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
	public boolean addRecipe(String name, String author, List<Integer> ingredients, String instruction)
	{
		//TODO
		return cookbook.addRecipe(name, author, ingredients, instruction);
	}
	
	public boolean removeCategory(String name, int ID)
	{
		return cookbook.removeCategory(name, ID);
	}

	public boolean rate(int ID, Rating rating)
	{
		return cookbook.rate(ID, rating);
	}
	
	public boolean unrate(int ID)
	{
		return cookbook.unrate(ID);
	}
	
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeIngredient(String ing)
	{
		return cookbook.removeIngredient(ing);
	}
	
	//Takes the ID of the recipe to be removed.
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeRecipe(int ID)
	{
		return cookbook.removeRecipe(ID);
	}

	/**
	 * Takes a name and adds that ingredient to the cookbook. 
	 * Returns a boolean whether it was successful or not.
	 * 
	 * @param name
	 * @return boolean
	 */
	@Override
	public boolean addIngredient(String name) 
	{
		return cookbook.addIngredient(name);
	}

	@Override
	public boolean discardRecipe() 
	{
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
	public boolean duplicateRecipe(int ID) 
	{
		return cookbook.duplicateRecipe(ID);
	}

	@Override
	public boolean editRecipe(int ID) 
	{
		return cookbook.editRecipe(ID);
	}

	@Override
	public boolean replaceIngredient(String oName, String nName) 
	{
		return cookbook.replaceIngredient(oName, nName);
	}

	@Override
	public boolean saveRecipe() 
	{
		return cookbook.saveRecipe();
	}

	@Override
	public boolean show(int ID)
	{
		return cookbook.show(ID);
	}

	@Override
	public boolean addCategory(String name) {
		return cookbook.addCategory(name);
	}

	@Override
	public boolean hideRecipe(int ID) {
		return cookbook.hideRecipe(ID);
	}
	
	@Override
	public boolean favoriteRecipe(int ID){
		return cookbook.favoriteRecipe(ID);
	}
	
	@Override
	public boolean unfavoriteRecipe(int ID){
		return cookbook.unfavoriteRecipe(ID);
	}

	@Override
	public String share(int ID) {
		return cookbook.share(ID);
	}
	
}
