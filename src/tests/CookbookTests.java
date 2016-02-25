package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs362Cookbook.Cookbook_Controller;
import cs362Cookbook.Recipe;

public class CookbookTests
{

	@Test
	public void addTest()
	{
		Cookbook_Controller cont = new Cookbook_Controller();
		Recipe recipe = new Recipe();
		int id = cont.addRecipe(recipe);
		assertTrue(id > 0);
	}

	@Test
	public void removeTest()
	{
		Cookbook_Controller cont = new Cookbook_Controller();
		Recipe recipe = new Recipe();
		int id = cont.addRecipe(recipe);
		boolean success = cont.removeRecipe(id);
		assertEquals(success, true);
	}
	
}
