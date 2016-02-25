package Interfaces;

import cs362Cookbook.Recipe;

public interface Cookbook_I {
	
	public boolean addIngredient(String name);
	public int addRecipe(Recipe recipe);
	public boolean discardRecipe();
	public int duplicateRecipe(int ID);
	public boolean editRecipe(int ID);
	public boolean removeIngredient(String name);
	public boolean removeRecipe(int ID);
	public boolean replaceIngredient(String oName, String nName);
	public boolean saveRecipe();
	
}