package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Database_Support_I;
import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;
public class Recipe implements Recipe_I
{
	int id;
	boolean isFavorite;
	String author;
	List<Integer> ingredients;
	List<Category> categories = new ArrayList<Category>();
	String name;
	Rating rating = Rating.NONE;
	String instruction;
	private boolean isHidden;
	
	public Recipe(String new_name, String new_author, List<Integer> new_ingredients, String new_instruction)
	{
		this.name = new_name;
		this.author = new_author;
		this.isFavorite = false;
		
		ingredients = new ArrayList<Integer>();
		
		for(Integer I : new_ingredients) {
			this.addIngredient(I);
		}
		
		this.instruction = new_instruction;
	}
	
	public Recipe(String new_name, String new_author, List<Integer> new_ingredients, String new_instruction, boolean newFav)
	{
		this.name = new_name;
		this.author = new_author;
		this.isFavorite = newFav;
		
		ingredients = new ArrayList<Integer>();
		
		for(Integer I : new_ingredients) {
			this.addIngredient(I);
		}
		
		this.instruction = new_instruction;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public String getAuthor()
	{
		return author;
	}
	
	@Override
	public String getInstruction()
	{
		return instruction;
	}
	
	@Override
	public boolean removeCategory(Category category)
	{
		return categories.remove(category);
	}
	
	@Override
	public void unrate()
	{
		rating = Rating.NONE;
	}
	
	@Override
	public boolean editRecipe(int ID)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean discardRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Returns a proper copy of this recipe
	 * @return Recipe_I
	 */
	@Override
	public Recipe_I copyRecipe() {
		
		Recipe R;
		
		try {
			
			R = (Recipe) this.clone();
			
		} catch (CloneNotSupportedException e) {
			
			R = new Recipe(this.name, this.author, new ArrayList<Integer>(), this.instruction);
			
		}
		
		// lets not trust .clone()
		R.id = -1;
		R.isFavorite = this.isFavorite;
		R.author = this.author;
		R.name = this.name;
		
		// lists
		R.ingredients = new ArrayList<Integer>();
		
		for(Integer i : this.ingredients) {
			
			R.ingredients.add(i);
			
		}
		
		return R;
		
	}
	
	@Override
	public boolean addIngredient(Ingredient_I I) {
		return ingredients.add(I.getID());
	}
	
	@Override
	public boolean addIngredient(Integer I) {
		return ingredients.add(I);
	}
	
	
	@Override
	public boolean removeIngredient(Ingredient_I I) {
		return ingredients.remove(I.getID());
	}
	
	@Override
	public List<Ingredient_I> getIngredients(Database_Support_I db)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object that)
	{
		//Equality
		if(this == that)
		{
			return true;
		}
		
		//Typeof error
		if ( !(that instanceof Recipe) )
		{
			return false;
		}
		
		//Explicit cast, just in case (it's safe now)
		Recipe other = (Recipe)that;
		
		//Verify that this truly is how we determine equality (am I forgetting anything? Did I add something extra?). //ID should never be equal.
		return this.author.equals(other.author) && this.name.equals(other.name) && this.categories.equals(other.categories) && this.ingredients.equals(other.ingredients) && this.id != other.id;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Returns a list of Ingredient IDs
	@Override
	public List<Integer> getIngredients()
	{
		return ingredients;
	}

	@Override
	public void show()
	{
		isHidden = false;
	}
	
}
