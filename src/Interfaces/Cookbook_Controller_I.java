package Interfaces;
import java.util.List;


public interface Cookbook_Controller_I {
	
	public boolean addIngredient(String name);
	public boolean addRecipe(String name, String author, List<Integer> ingredients, String instruction);
	public boolean discardRecipe();
	public boolean duplicateRecipe(int ID);
	public boolean editRecipe(int ID);
	public boolean removeIngredient(String name);
	public boolean removeRecipe(int ID);
	public boolean replaceIngredient(String oName, String nName);
	public boolean saveRecipe();
	public boolean removeCategory(String name, int ID);
	public boolean unrate(int ID);
	public boolean show(int ID);
}
