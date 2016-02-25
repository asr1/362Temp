package Interfaces;

public interface Database_Support_I {

	public int putRecipe(Recipe_I R);
	public Recipe_I getRecipe(int ID);
	public boolean deleteRecipe(int ID);
	public boolean putIngredient(Ingredient_I I);
	public Ingredient_I getIngredient(String name);
	public boolean deleteIngredient(String name);
	
}
