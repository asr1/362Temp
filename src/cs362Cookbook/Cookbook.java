package cs362Cookbook;

import Interfaces.Cookbook_I;
import Interfaces.Database_Support_I;

public class Cookbook implements Cookbook_I
{
	
	private Database_Support_I db;
	
	public Cookbook() {
		db = null;
	}

	@Override
	public boolean addIngredient(String name)
	{
		// TODO Auto-generated method stub
		return false;
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
