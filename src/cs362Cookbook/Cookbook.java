package cs362Cookbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import Interfaces.Cookbook_I;
import Interfaces.Database_Support_I;
import Interfaces.Ingredient_I;
import Interfaces.Recipe_I;


public class Cookbook implements Cookbook_I
{
	
	private Database_Support_I db;
	
	public Cookbook() {
		db = null;
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
		File file = new File("temp.txt");
		return file.delete();
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
		//Get Recipe from database
		Recipe recipe = (Recipe) db.getRecipe(ID);
		
		//print recipe data to new text file temp.txt
		File file = new File("temp.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//Print Name
		writer.println("#Name");
		writer.println(recipe.name);
		
		//Print Authors
		writer.println("#Authors");
		writer.println(recipe.author);
		
		//Print Instructions
		writer.println("#Instruction");
		writer.println(recipe.instruction);
		
		//Print ingredients
		writer.println("#Ingredients");
		for(int i = 0; i < recipe.ingredients.size(); i++)
		{
			writer.println(((Ingredient)recipe.ingredients.get(i)).getName());
		}
		
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
			saveRecipe(recipe);
		}
		
		//
		else{
			
		}
		return false;
	}

	private void editsWait(Scanner edits, String input){
		//wait for next non-#starting line
		while(edits.hasNext()&&(input.charAt(0)==('#')))
		{
			input = edits.nextLine();
		}
	}
	
	@Override
	public boolean removeIngredient(String name)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRecipe(int ID)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceIngredient(String oName, String nName)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveRecipe(Recipe recipe)
	{
		String input = "";
		File file = new File("temp.txt");
		
		//process inputs
		Scanner edits = null;
		try {
			edits = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//wait for first non-#starting line
		if(edits.hasNextLine()){
			input=edits.nextLine();
		}
		editsWait(edits, input);
		
		//clear recipe name then set equal to next non-#starting lines 
		recipe.name="";
		while(edits.hasNext()&&!(input.charAt(0)==('#')))
		{
			recipe.name+=edits.nextLine()+" ";
		}
		editsWait(edits, input);			
		
		//clear recipe author then set equal to next non-#starting lines 
		recipe.author="";
		while(edits.hasNext()&&!(input.charAt(0)==('#')))
		{
			recipe.author+=input+" ";
			input = edits.nextLine();
		}
		editsWait(edits, input);
		
		//clear recipe instructions then set equal to next non-#starting lines 
		recipe.instruction="";
		while(edits.hasNext()&&!(input.charAt(0)==('#')))
		{
			recipe.instruction+=input+" ";
			input = edits.nextLine();
		}
		editsWait(edits, input);
		
		//clear recipe ingredients then set equal to next non-#starting lines 
		recipe.ingredients.clear();
		while(edits.hasNext()&&!(input.charAt(0)==('#')))
		{
			recipe.instruction+=input+" ";
			input = edits.nextLine();
		}
		return db.putRecipe(recipe)>0;
	}

	@Override
	public int addRecipe(String name, String Author, List<Ingredient_I> ingredients, String instruction)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
