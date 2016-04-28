package cs362Cookbook;

public enum Rating
{
	NONE, ONE, TWO, THREE, FOUR, FIVE;


public static Rating toRating(String rating){
	if(rating.toUpperCase().equals("NONE")){
		return NONE;
	}
	if(rating.equals("1")){
		return ONE;
	}
	if(rating.equals("2")){
		return TWO;
	}
	if(rating.equals("3")){
		return THREE;
	}
	if(rating.equals("4")){
		return FOUR;
	}
	if(rating.equals("5")){
		return FIVE;
	}
	return null;
}
}