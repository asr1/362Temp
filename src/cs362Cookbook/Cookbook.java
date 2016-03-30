package cs362Cookbook;

import java.util.Scanner;
import java.util.List;

import Interfaces.*;


public class Cookbook implements Cookbook_I
{
	
	private Database_Support_I db;
	
	public Cookbook() {
		db = new Database_Support();
	}

	public boolean removeCategory(String name, int ID)
	{
		Recipe r = (Recipe) db.getRecipe(ID);
		Category cat = (Category) db.getCategory(name);
		if(r == null || cat == null)
		{
			return false;
		}
		 r.removeCategory(cat);
		 cat.removeRecipe(r);
		 return db.putRecipe(r) > 0 && db.putCategory(cat);
		 
	}
	
	public  boolean unrate(int ID)
	{
		Recipe r = (Recipe) db.getRecipe(ID);
		if(r == null)
		{
			return false;
		}
		r.unrate();
		return db.putRecipe(r) > 0;
	}
	
	/**
	 * Takes a name and adds that ingredient to the cookbook. 
	 * Returns a boolean whether it was successful or not.
	 * 
	 * @param name
	 * @return boolean
	 */
	@Override
	public boolean addIngredient(String name) {
		
		Ingredient_I I = new Ingredient(name);
		
		return db.putIngredient(I);
		
	}

	@Override
	public boolean discardRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Takes a ID number for a recipe and makes a duplicate of that recipe. 
	 * Returns the ID of the newly created recipe.
	 * 
	 * @param ID
	 * @return int
	 */
	@Override
	public int duplicateRecipe(int ID) {
		
		Recipe_I R1 = db.getRecipe(ID);
		
		if(R1 == null) {
			
			return -1;
			
		}
		
		Recipe_I R2 = R1.copyRecipe();
		
		return db.putRecipe(R2);
		
	}

	//returns true if succeeded, otherwise false
	@Override
	public boolean editRecipe(int ID)
	{
		//TODO
		//Get Recipe from database
//		Recipe recipe = getRecipe(ID);
		
		//print recipe data to new text file temp.txt
//		File file = new File("temp.txt");
//		PrintWriter writer = new PrintWriter(file));
//		writer.println("#Name");
//		writer.println(recipe.name);
//		writer.println("#Authors");
//		writer.println(recipe.author);
//		writer.println("#Instruction");
//		writer.println(recipe.instruction);
//		writer.println("#Ingredients");
//		for(int i = 0; i < recipe.ingredients.size(); i++)
//		{
//		writer.println(recipe.ingredients.get(i).name);
//		}
		
		//prompt changes
		System.out.println("temp.txt created, please edit the file to make changes");
		System.out.println("Save chabges to recipe? <Y/N>");
		
		//process input
		Scanner scan = new Scanner(System.in);
		String input = "";
		while (!scan.next().equals("Y")&&!scan.next().equals("N"))
		{
		}
		scan.close();
		
		//save edits to recipe
		if(input.equals("Y"))
		{
			//process inputs
//			Scanner edits = new Scanner(file);
//			input="";
			
			//wait for first non-#starting line
//			while(edits.hasNext()&&(input.charAt(0)==('#'))}
//			{
//				input = edits.nextLine();
//			}
			
			//clear recipe name then set equal to next non-#starting lines 
//			recipe.name="";
//			while(edits.hasNext()&&!(input.charAt(0)==('#'))
//			{
//				recipe.name+=edits.nextLine()+" ";
//			}

			//wait for next non-#starting line
//			while(edits.hasNext()&&(input.charAt(0)==('#'))}
//			{
//			input = edits.nextLine();
//			}
			
			
			//clear recipe author then set equal to next non-#starting lines 
//			recipe.author="";
//			while(edits.hasNext()&&!(input.charAt(0)==('#'))
//			{
//				recipe.author+=input+" ";
//				input = edits.nextLine();
//			}
			
			//wait for next non-#starting line
//			while(edits.hasNext()&&(input.charAt(0)==('#'))}
//			{
//			input = edits.nextLine();
//			}
			
			//clear recipe instructions then set equal to next non-#starting lines 
//			recipe.instruction="";
//			while(edits.hasNext()&&!(input.charAt(0)==('#'))
//			{
//				recipe.instruction+=input+" ";
//				input = edits.nextLine();
//			}
			
			//wait for next non-#starting line
//			while(edits.hasNext()&&(input.charAt(0)==('#'))}
//			{
//			input = edits.nextLine();
//			}
			
			//clear recipe ingredients then set equal to next non-#starting lines 
//			recipe.ingredients.empty();
//			while(edits.hasNext()&&!(input.charAt(0)==('#'))
//			{
//				recipe.instruction+=input+" ";
//				input = edits.nextLine();
//			}
		}
		//
		else{
			
		}
		return false;
	}

	@Override
	public boolean removeIngredient(String name)
	{
		Ingredient ing = (Ingredient) db.getIngredient(name);
		return db.deleteIngredient(ing);
	}

	@Override
	public boolean removeRecipe(int ID)
	{
		Recipe r = (Recipe) db.getRecipe(ID);
		return db.deleteRecipe(r);
	}

	@Override
	public boolean replaceIngredient(String oName, String nName) {
		
		Ingredient_I I_old = db.getIngredient(oName);
		Ingredient_I I_new = db.getIngredient(nName);
		
		if(I_old == null || I_new == null) {
			return false;
		}
		
		List<Recipe_I> list = I_old.getRecipes(db);
		
		for(Recipe_I R : list) {
			R.addIngredient(I_new);
			R.removeIngredient(I_old);
			db.putRecipe(R);
		}
		
		db.putIngredient(I_new);
		
		return db.deleteIngredient(I_old);
		
	}

	@Override
	public boolean saveRecipe()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addRecipe(String name, String author, List<Ingredient_I> ingredients, String instruction)
	{
		Recipe recipe = new Recipe(name, author, ingredients, instruction);
		return db.putRecipe(recipe);
	}
}
