import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interfaces.Recipe_I;
import cs362Cookbook.Cookbook_Controller;
import cs362Cookbook.Ingredient;
import cs362Cookbook.Rating;

public class UI {

	private static Cookbook_Controller cb;
	private static boolean running = true;
	private static Scanner scan;
	private static List<Recipe_I> results = new ArrayList<Recipe_I>();
	
	public static void main(String[] args) 
	{
		cb = new Cookbook_Controller();
		scan = new Scanner(System.in);
		while(running)
		{
			System.out.println("type \"commands\" to view a list of commands");
			processInput(scan.nextLine());
		}
		scan.close();
	}
	
	private static void processInput(String command) {
		boolean success;
		results = null;
		//Iteration1
		if(command.equals("addRecipe"))
		{
			System.out.print("Recipe Name:");
			String name = scan.nextLine();

			System.out.print("Recipe Author:");
			String author = scan.nextLine();

			List<Integer> ingredients = new ArrayList<Integer>();
			String str = "";
			while(!str.equals("quit"))
			{
				System.out.print("Add ingredient(type \"quit\" to finish):");
				str = scan.nextLine();
				if(!str.equals("quit")&&!str.isEmpty()){
					Ingredient ingredient = new Ingredient(str);
					ingredients.add(ingredient.getID());
				}
			}
				
			System.out.print("Recipe Instructions:");
			String instructions = scan.nextLine();
			
			success = cb.addRecipe(name, author, ingredients, instructions);
			
			if(success){
				System.out.println("Recipe created successfully!");
			}
			else{
				System.err.println("Recipe creation error");
			}
		}
		if(command.equals("editRecipe"))
		{
			System.out.print("Recipe ID: ");
			success = cb.editRecipe(scan.nextInt());
			if(success){
				System.out.println("Recipe editted successfully!");
			}
			else{
				System.err.println("Recipe edit error");
			}
		}
		if(command.equals("saveRecipe"))
		{
			success = cb.saveRecipe();
			if(success){
				System.out.println("Recipe saved successfully!");
			}
			else{
				System.err.println("Recipe save error");
			}
		}
		if(command.equals("discardChanges"))
		{
			success = cb.discardRecipe();
			if(success){
				System.out.println("Edits discarded successfully!");
			}
			else{
				System.err.println("Edit discard error");
			}
		}
		if(command.equals("removeRecipe"))
		{

			System.out.print("Recipe ID: ");
			success = cb.removeRecipe(scan.nextInt());
			if(success){
				System.out.println("Recipe removed successfully!");
			}
			else{
				System.err.println("Recipe removal error");
			}
		}
		if(command.equals("duplicateRecipe"))
		{
			System.out.print("Recipe ID: ");
			success = cb.duplicateRecipe(scan.nextInt());
			if(success){
				System.out.println("Recipe duplicated successfully!");
			}
			else{
				System.err.println("Recipe duplication error");
			}
		}
		if(command.equals("addIngredient"))
		{
			System.out.print("Ingredient name: ");
			success = cb.addIngredient(scan.nextLine());
			if(success){
				System.out.println("Ingredient added successfully!");
			}
			else{
				System.err.println("Ingredient addition error");
			}
		}
		if(command.equals("removeIngredient"))
		{

			System.out.print("Ingredient name: ");
			success = cb.removeIngredient(scan.nextLine());
			if(success){
				System.out.println("Ingredient removed successfully!");
			}
			else{
				System.err.println("Ingredient removal error");
			}
		}
		if(command.equals("replaceIngredient"))
		{
			System.out.print("Ingredient name: ");
			String old = scan.nextLine();
			System.out.print("Ingredient name: ");
			success = cb.replaceIngredient(old,scan.nextLine());
			if(success){
				System.out.println("Ingredient replaced successfully!");
			}
			else{
				System.err.println("Ingredient replacement error");
			}
		}
		//Iteration2
		if(command.equals("addCategory"))
		{
			System.out.print("Category name: ");
			success = cb.addCategory(scan.nextLine());
			if(success){
				System.out.println("Category added successfully!");
			}
			else{
				System.err.println("Category addition error");
			}
		}
		if(command.equals("removeCategory"))
		{
			System.out.print("Category name: ");
			String name = scan.nextLine();
			System.out.print("Category ID: ");
			success = cb.removeCategory(name,scan.nextInt());
			if(success){
				System.out.println("Category removed successfully!");
			}
			else{
				System.err.println("Category removal error");
			}
		}
		if(command.equals("hideRecipe"))
		{
			System.out.print("Recipe ID: ");
			success = cb.hideRecipe(scan.nextInt());
			if(success){
				System.out.println("Recipe hidden successfully!");
			}
			else{
				System.err.println("Recipe hiding error");
			}
		}
		if(command.equals("showRecipe"))
		{
			System.out.print("Recipe ID: ");
			success = cb.show(scan.nextInt());
			if(success){
				System.out.println("Recipe showed successfully!");
			}
			else{
				System.err.println("Recipe showing error");
			}
		}
		if(command.equals("favoriteRecipe"))
		{
			System.out.print("Recipe ID: ");
			success = cb.favoriteRecipe(scan.nextInt());
			if(success){
				System.out.println("Recipe favorited successfully!");
			}
			else{
				System.err.println("Recipe favoriting error");
			}
		}
		if(command.equals("unfavoriteRecipe"))
		{
			System.out.print("Recipe ID: ");
			success = cb.unfavoriteRecipe(scan.nextInt());
			if(success){
				System.out.println("Recipe unfavorited successfully!");
			}
			else{
				System.err.println("Recipe unfavoriting error");
			}
		}
		if(command.equals("rate"))
		{
			System.out.print("Recipe ID: ");
			int ID = scan.nextInt();
			System.out.print("Rating(NONE,1,2,3,4,5): ");
			success = cb.rate(ID,Rating.toRating(scan.nextLine()));
			if(success){
				System.out.println("Recipe rated successfully!");
			}
			else{
				System.err.println("Recipe rating error");
			}
		}
		if(command.equals("unrate"))
		{
			System.out.print("Recipe ID: ");
			success = cb.unrate(scan.nextInt());
			if(success){
				System.out.println("Recipe unrated successfully!");
			}
			else{
				System.err.println("Recipe unrating error");
			}
		}
		if(command.equals("share"))
		{
			System.out.print("Recipe ID: ");
			cb.share(scan.nextInt());
		}
		//Iteration3
		if(command.equals("search"))
		{
			results=cb.search();
		}
		if(command.equals("filterIngredients"))
		{
			System.out.print("Ingredient name: ");
			results=cb.filterCategory(scan.nextLine());
		}
		if(command.equals("filterCategory"))
		{
			System.out.print("Category name: ");
			results=cb.filterCategory(scan.nextLine());
		}
		if(command.equals("filterAuthor"))
		{
			System.out.print("Author name: ");
			results=cb.filterSource(scan.nextLine());
		}
		if(command.equals("print"))
		{
		}
		if(command.equals("sortAlphabetic"))
		{
			results = cb.sortAlphabetic(cb.search());
		}
		if(command.equals("sortAuthor"))
		{
			results = cb.sortAuthor(cb.search());
		}
		if(command.equals("sortRating"))
		{
			results = cb.sortRating(cb.search());
		}
		if(command.equals("sortCategory"))
		{
			results = cb.sortCategory(cb.search());
		}
		
		//UI commands
		if(command.equals("commands"))
		{
			printOptions();
		}
		if(command.equals("quit"))
		{
			running = false;
		}
		
		//print any search/sort/filter results
		if(!(results==null)){
			for(Recipe_I result : results){
				cb.printRecipe(result);
			}
		}
	}

	private static void printOptions(){
		//prints list of commands
		//Iteration 1
		System.out.println("addRecipe");
		System.out.println("editRecipe");
		System.out.println("saveRecipe");
		System.out.println("discardChanges");
		System.out.println("removeRecipe");
		System.out.println("duplicateRecipe");
		System.out.println("addIngredient");
		System.out.println("removeIngredient");
		System.out.println("replaceIngredient");
		//Iteration2
		System.out.println("addCategory");
		System.out.println("removeCategory");
		System.out.println("hideRecipe");
		System.out.println("showRecipe");
		System.out.println("favoriteRecipe");
		System.out.println("unfavoriteRecipe");
		System.out.println("rate");
		System.out.println("unrate");
		System.out.println("share");
		//Iteration3
		System.out.println("search");
		System.out.println("filterIngredients");
		System.out.println("filterCategory");
		System.out.println("filterAuthor");
		System.out.println("print");
		System.out.println("sortAlphabetic");
		System.out.println("sortAuthor");
		System.out.println("sortRating");
		System.out.println("sortCategory");

		System.out.println("commands");
		System.out.println("quit");
	}

}
