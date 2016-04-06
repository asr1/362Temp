package Interfaces;

import java.util.List;

public interface Category_I {
	
	// Class diagram fragment
	public List<Recipe_I> getRecipes(Database_Support_I db);
	public boolean removeRecipe(Recipe_I R);
	public boolean addRecipe(Recipe_I R);
	
	// Database Support needed calls
	public String getName();
	public Integer getID();

	
		
}
