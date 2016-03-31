package Interfaces;

import java.util.List;


public interface Cookbook_I {
	
	public boolean addIngredient(String name);
	public int addRecipe(String name, String author, List<Integer> ingredients, String instruction);
	public boolean discardRecipe();
	public int duplicateRecipe(int ID);
	public boolean editRecipe(int ID);
	public boolean removeIngredient(String name);
	public boolean removeRecipe(int ID);
	public boolean replaceIngredient(String oName, String nName);
	public boolean saveRecipe();
	public boolean removeCategory(String name, int ID);
	public  boolean unrate(int ID);
	public boolean show(int ID);
	
}