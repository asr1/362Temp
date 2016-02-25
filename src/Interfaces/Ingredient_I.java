package Interfaces;

import java.util.List;

public interface Ingredient_I {
	
	// Class diagram fragment
	public List<Recipe_I> getRecipes();
	public boolean removeRecipe(Recipe_I R);
	public boolean addRecipe(Recipe_I R);
	
	// Database Support needed calls
	public String getName();

}
