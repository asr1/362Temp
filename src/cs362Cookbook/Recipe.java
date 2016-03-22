package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;
public class Recipe implements Recipe_I
{
	int id;
	boolean isFavorite;
	String author;
	List<Ingredient_I> ingredients = new ArrayList<Ingredient_I>();
	List<Category> categories = new ArrayList<Category>();
	String name;
	Rating rating = Rating.NONE;
	String instruction;
	
	public Recipe(String new_name, String new_author, List<Ingredient_I> new_ingredients, String new_instruction)
	{
		this.name = new_name;
		this.author = new_author;
		this.ingredients = new_ingredients;
		this.instruction = new_instruction;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getInstruction()
	{
		return instruction;
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
			
			R = new Recipe(this.name, this.author, new ArrayList<Ingredient_I>(), this.instruction);
			
		}
		
		// lets not trust .clone()
		R.isFavorite = this.isFavorite;
		R.author = this.author;
		R.name = this.name;
		
		// lists
		R.ingredients = new ArrayList<Ingredient_I>();
		
		for(Ingredient_I I : this.ingredients) {
			
			R.ingredients.add(I);
			
		}
		
		return R;
		
	}
	
	@Override
	public boolean addIngredient(Ingredient_I I)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeIngredient(Ingredient_I I)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Ingredient_I> getIngredients()
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
	
}
