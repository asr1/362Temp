package Interfaces;

import java.util.List;

public interface Recipe_I {

	public boolean editRecipe(int ID);
	public boolean discardRecipe();
	public Recipe_I copyRecipe();
	public boolean addIngredient(Ingredient_I I);
	public boolean removeIngredient(Ingredient_I I);
	public List<Ingredient_I> getIngredients();
	
}
