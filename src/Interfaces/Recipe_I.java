package Interfaces;

import java.util.List;

import cs362Cookbook.Category;

public interface Recipe_I {

	public boolean editRecipe(int ID);
	public boolean discardRecipe();
	public Recipe_I copyRecipe();
	public boolean addIngredient(Ingredient_I I);
	public boolean addIngredient(Integer I);
	public boolean removeIngredient(Ingredient_I I);
	public List<Integer> getIngredients();
	public boolean removeCategory(Category category);
	public boolean unrate();
	public List<Ingredient_I> getIngredients(Database_Support_I db);
	public void show();
	public String getName();
	public String getInstruction();
	public String getAuthor();
	
	//Needed to confirm copy succeeds
	@Override
	public boolean equals(Object aThat);
	
	// Database Support needed calls
	public int getID();

}
