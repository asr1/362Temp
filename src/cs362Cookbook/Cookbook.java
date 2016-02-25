package cs362Cookbook;

import Interfaces.Cookbook_I;
import Interfaces.Database_Support_I;
import Interfaces.Ingredient_I;

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
	public int addRecipe(String name)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean discardRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int duplicateRecipe(int ID)
	{
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public boolean replaceIngredient(String oName, String nName)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
