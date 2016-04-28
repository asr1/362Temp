package Interfaces;

import java.util.List;

import cs362Cookbook.Rating;


public interface Cookbook_I {
	
	public boolean addIngredient(String name);
	public boolean addRecipe(String name, String author, List<Integer> ingredients, String instruction);
	public boolean discardRecipe();
	public boolean duplicateRecipe(int ID);
	public boolean editRecipe(int ID);
	public boolean removeIngredient(String name);
	public boolean removeRecipe(int ID);
	public boolean replaceIngredient(String oName, String nName);
	public boolean saveRecipe();
	public boolean addCategory(String name);
	public boolean removeCategory(String name, int ID);
	public boolean hideRecipe(int ID);
	public boolean unrate(int ID);
	public boolean rate(int ID, Rating rating);
	public boolean show(int ID);
	public String share(int ID);
	public boolean favoriteRecipe(int ID);
	public boolean unfavoriteRecipe(int ID);
	public List<Recipe_I> search();
	public List<Recipe_I> sortCategory(List<Recipe_I> L);
	public List<Recipe_I> sortRating(List<Recipe_I> L);
	public List<Recipe_I> filterSource(String source);
	public List<Recipe_I> filterCategory(String category);

}