package Interfaces;
import java.util.List;
import cs362Cookbook.Ingredient;


public interface Cookbook_Controller_I {
	
	public boolean addIngredient(String name);
	public int addRecipe(String name, String author, List<Ingredient_I> ingredients, String instruction);
	public boolean discardRecipe();
	public int duplicateRecipe(int ID);
	public boolean editRecipe(int ID);
	public boolean removeIngredient(String name);
	public boolean removeRecipe(int ID);
	public boolean replaceIngredient(String oName, String nName);
	public boolean saveRecipe();
			
}
