package Interfaces;

public interface Database_Support_I {

	public int putRecipe(Recipe_I R);
	public Recipe_I getRecipe(int ID);
	public boolean deleteRecipe(Recipe_I R);
	public boolean putIngredient(Ingredient_I I);
	public Ingredient_I getIngredient(String name);
	public Ingredient_I getIngredient(int ID);
	public boolean deleteIngredient(Ingredient_I I);
	public Category_I getCategory(String name);
	public boolean putCategory(Category_I C);
}
