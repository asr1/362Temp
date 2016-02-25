package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs362Cookbook.Cookbook_Controller;
import cs362Cookbook.Ingredient;
import cs362Cookbook.Recipe;

public class CookbookTests
{

	@Test
	public void cookbookAddRecipeTest()
	{
		Cookbook_Controller cont = new Cookbook_Controller();
		Recipe recipe = new Recipe();
		int id = cont.addRecipe(recipe);
		assertTrue(id > 0);
	}

	@Test
	public void cookbookRemoveRecipeTest()
	{
		Cookbook_Controller cont = new Cookbook_Controller();
		Recipe recipe = new Recipe();
		int id = cont.addRecipe(recipe);
		boolean success = cont.removeRecipe(id);
		assertEquals(success, true);
	}
	
	@Test
	public void cookbookRemoveIngredientTest() 
	{
		Cookbook_Controller cont = new Cookbook_Controller();
		Recipe recipe = new Recipe();
		Ingredient ing = new Ingredient();
		recipe.addIngredient(ing);
		boolean result = cont.removeIngredient(ing.getName());
		boolean contains = recipe.getIngredients().contains(ing);
		assertTrue(result);
		assertFalse(contains);
	}
	
}
