package cs362Cookbook;

import java.util.List;

import Interfaces.*;

public class Cookbook implements Cookbook_I
{
	
	private Database_Support_I db;
	
	public Cookbook() {
		db = null;
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
		
		Ingredient_I I = new Ingredient(name);
		
		return db.putIngredient(I);
		
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
	public int duplicateRecipe(int ID) {
		
		Recipe_I R1 = db.getRecipe(ID);
		
		if(R1 == null) {
			
			return -1;
			
		}
		
		Recipe_I R2 = R1.copyRecipe();
		
		return db.putRecipe(R2);
		
	}

	@Override
	public boolean editRecipe(int ID)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeIngredient(String name)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRecipe(int ID)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Takes a old name and a new name then replaces the old ingredient with the new ingredient. 
	 * Returns a boolean whether it was successful or not.
	 * 
	 * @param old name, new name
	 * @return boolean
	 */
	@Override
	public boolean replaceIngredient(String oName, String nName) {
		
		Ingredient_I I1 = db.getIngredient(oName);
		
		Ingredient_I I2 = db.getIngredient(nName);
		
		if(I1 == null || I2 == null) {
			
			return false;
			
		}
		
		List<Recipe_I> L = I1.getRecipes();
		
		for(Recipe_I R : L) {
			
			R.removeIngredient(I1);
			
			R.addIngredient(I2);
			
			I2.addRecipe(R);
			
		}
		
		return db.putIngredient(I2) && db.deleteIngredient(I1.getName());
		
	}

	@Override
	public boolean saveRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addRecipe(Recipe recipe)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
