package cs362Cookbook;

import java.util.ArrayList;
import java.util.List;
public class Recipe
{
	int id;
	boolean isFavorite;
	String author;
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	List<Category> categories = new ArrayList<Category>();
	String name;
	Rating rating = Rating.NONE;
	
}
