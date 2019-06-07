package builder;

import builder.Meal.MealBuilder;

public class Client {
	public static void testMealSetter() {
		MealWithSetter meal = new MealWithSetter();
		// No contract 
		// Not immutable object as can be changed.
		
		// meal.setBread("wheat");
		 meal.setButter(false);
		
		System.out.println(meal.toString());
	}
	
	public static void testMealConstructor() {
		// Achieve immutable as no setter .
		MealWithConstructor meal = new MealWithConstructor("wheat", "potato", "turdaal", "mango");
		
		/**
		 * But issue is 
		 * 
		 * What if person need only bread or pickle as he cant afford other things.
		 * What if Aniketh wants bread and butter only as he likes sandwitch. as new constructor is needed
		 * or every time some default value need to pass.
		 */
		
		System.out.println(meal.toString());
	}
	
	public static void testMealWithBuilder() {
		MealBuilder mealBuilder = new MealBuilder();
		
		mealBuilder.bread("wheat").daal("turdaal").butter(true);
		
		Meal meal = mealBuilder.build();
		
		System.out.println(meal.toString());
	}
	
	public static void main(String[] args) {
		testMealWithBuilder();
	}
}
