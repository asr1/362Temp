package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cs362Cookbook.Cookbook_Controller;
import cs362Cookbook.Ingredient;
import cs362Cookbook.Recipe;

public class CookbookTests
{

	@Test
	public void cookbookAddRecipeTest()
	{
//		Cookbook_Controller cont = new Cookbook_Controller();
//		Recipe recipe = new Recipe("name", "author", null, "instruction");
		int id = 0; //= cont.addRecipe(recipe.getName(), recipe.getAuthor(), recipe.getIngredients(), recipe.getInstruction());
		assertTrue(id > 0);
	}

	@Test
	public void cookbookRemoveRecipeTest()
	{
		Cookbook_Controller cont = new Cookbook_Controller();
//		Recipe recipe = new Recipe("name", "author", null, "instruction");
		int id = 0;// = cont.addRecipe(recipe.getName(), recipe.getAuthor(), recipe.getIngredients(), recipe.getInstruction());
		boolean success = cont.removeRecipe(id);
		assertEquals(success, true);
	}
	
	@Test
	public void cookbookRemoveIngredientTest() 
	{
		Cookbook_Controller cont = new Cookbook_Controller();
		Recipe recipe = new Recipe("name", "author", null, "instruction"); //TODO, this will null pointer
		Ingredient ing = new Ingredient("Garlic");
		recipe.addIngredient(ing);
		boolean result = cont.removeIngredient(ing.getName());
		boolean contains = recipe.getIngredients().contains(ing);
		assertTrue(result);
		assertFalse(contains);
	}
	
}
