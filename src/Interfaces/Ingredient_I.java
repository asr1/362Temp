package Interfaces;

import java.util.List;

public interface Ingredient_I {
	
	public List<Recipe_I> getRecipes();
	public boolean removeRecipe(Recipe_I R);
	public boolean addRecipe(Recipe_I R);

}
