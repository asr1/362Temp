package Interfaces;

import java.util.List;

import cs362Cookbook.Category;
import cs362Cookbook.Rating;

public interface Recipe_I {

	public boolean editRecipe(int ID);
	public boolean discardRecipe();
	public Recipe_I copyRecipe();
	public boolean addIngredient(Ingredient_I I);
	public boolean addIngredient(Integer I);
	public boolean removeIngredient(Ingredient_I I);
	public List<Integer> getIngredients();
	public boolean removeCategory(Category category);
	public void rate(Rating rating);
	public void unrate();
	public boolean hide();
	public String export(Database_Support_I db);
	public List<Ingredient_I> getIngredients(Database_Support_I db);
	public void show();
	public void favorite();
	public void unfavorite();
	public List<Category_I> getCategories(Database_Support_I db);
	
	//Needed to confirm copy succeeds
	@Override
	public boolean equals(Object aThat);
	
	// Database Support needed calls
	public int getID();
	public String getName();
	public String getInstruction();
	public String getAuthor();

}
