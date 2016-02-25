package cs362Cookbook;

public class Cookbook_Controller extends Cookbook
{
	
	//Returns the ID of the created recipe, or -1 if
	//The add failed.
	public int addRecipe(Recipe rec)
	{
		return -1;
	}
	
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeIngredient(Ingredient ing)
	{
		return false;
	}
	
	//Takes the ID of the recipe to be removed.
	//Returns true if the remove succeeded, or false otherwise.
	public boolean removeRecipe(int id)
	{
		return false;
	}
}
