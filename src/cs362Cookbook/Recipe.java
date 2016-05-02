package cs362Cookbook;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Category_I;
import Interfaces.Database_Support_I;
import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;

public class Recipe implements Recipe_I
{
	int id;
	String author;
	List<Integer> ingredients;
	List<Integer> categories;
	String name;
	Rating rating = Rating.NONE;
	String instruction;
	private boolean isHidden;
	private boolean isFavorite;
	
	public Recipe(String new_name, String new_author, List<Integer> new_ingredients, String new_instruction)
	{
		this.id=-1;
		this.name = new_name;
		this.author = new_author;
		this.isHidden = false;
		this.isFavorite = false;
		
		ingredients = new ArrayList<Integer>();
		
		for(Integer I : new_ingredients) {
			this.addIngredient(I);
		}
		
		categories = new ArrayList<Integer>();
		
		this.instruction = new_instruction;
	}
	
	public Recipe(String new_name, String new_author, List<Integer> new_ingredients, String new_instruction, boolean newFav, Rating r)
	{
		this.name = new_name;
		this.author = new_author;
		this.isFavorite = newFav;
		this.rating = r;
		
		ingredients = new ArrayList<Integer>();
		
		for(Integer I : new_ingredients) {
			this.addIngredient(I);
		}
		
		this.instruction = new_instruction;
	}
	
	public Recipe(int id, String new_name, String new_author, List<Integer> new_ingredients, String new_instruction, boolean newFav, Rating r)
	{
		this(new_name, new_author, new_ingredients, new_instruction);
		this.id = id;
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
	public void rate(Rating rating)
	{
		this.rating = rating;
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
		List<Ingredient_I> result = new ArrayList<Ingredient_I>();
		
		for(Integer I : ingredients) {
			result.add(db.getIngredient(I));
		}
		
		return result;
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
	public int getID() 
	{
		return id;
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

	/**
	 * Sets the recipe to hidden.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hide() {
		return isHidden = true;
	}
	
	@Override
	public void favorite() {
		isFavorite = true;
	}

	@Override
	public void unfavorite() {
		isFavorite = false;
	}

	/**
	 * Exports the recipe to a file and returns that file name.
	 * 
	 * @return String
	 */
	@Override
	public String export(Database_Support_I db) {
		
		// new File for this Recipe
		File f = new File(name + id + ".recipe");
		
		// the writer to use
		PrintWriter out;
		
		try {
			
			// make our new file
			f.createNewFile();
			
			// set the writer
			out = new PrintWriter(f);
			
			// print the recipe
			out.println("Recipe\n");
			out.println("Name         : " + this.name);
			out.println("Author       : " + this.author);
			
			out.println();
			
			out.println("Ingredients  :");
			
			for(Integer i : ingredients) {
				Ingredient_I I = db.getIngredient(i);
				out.print(I.getName() + ", ");
			}
			
			out.println("\n");
			
			out.println("Instructions :");
			out.println(this.instruction);
			
		} catch (Exception e) {			
			return e.toString();
		}
		
		// close the writer
		out.close();
		
		// return
		return f.getName();
		
	}

	/**
	 * Returns a list of categories attached to this recipe
	 * 
	 * @param Database_Support_I
	 * @return List<Category_I>
	 */
	@Override
	public List<Category_I> getCategories(Database_Support_I db) {
		List<Category_I> result = new ArrayList<Category_I>();
		
		Category_I C = null;
		
		for(Integer I : categories) {
			C = db.getCategory(I);
			
			result.add(C);
		}
		
		return result;
	}

	@Override
	public Rating getRating()
	{
		return rating;
	}
	
}
