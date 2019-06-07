package builder;

/**
 * Achieve immutability 
 * and also full customiziation.
 * 
 * @author mohit.k
 *
 */
public class Meal {
	// Can be in seperated file if class gets huge.
	public static class MealBuilder {
		private String bread;
		private String veg;
		private String daal;
		private String pickle;
		private boolean isButter;
		
		public Meal build() {
			return new Meal(this);
		}
		
		public MealBuilder bread(String bread) {
			this.bread = bread;
			
			return this;
		}
		
		public MealBuilder veg(String veg) {
			this.veg = veg;
			
			return this;
		}
		
		public MealBuilder daal(String daal) {
			this.daal = daal;
			
			return this;
		}
		
		public MealBuilder pickle(String pickle) {
			this.pickle = pickle;
			
			return this;
		}
		
		public MealBuilder butter(boolean isButter) {
			this.isButter = isButter;
			
			return this;
		}
	}
	
	
	private final String bread;
	private final String veg;
	private final String daal;
	private final String pickle;
	private final boolean isButter;
	
	public Meal(MealBuilder mealBuilder) {
		this.bread = mealBuilder.bread;
		this.daal = mealBuilder.daal;
		this.veg = mealBuilder.veg;
		this.pickle = mealBuilder.pickle;
		this.isButter = mealBuilder.isButter;
	}
	
	public String getBread() {
		return bread;
	}
	public String getVeg() {
		return veg;
	}
	public String getDaal() {
		return daal;
	}
	public String getPickle() {
		return pickle;
	}
	public boolean isButter() {
		return isButter;
	}

	@Override
	public String toString() {
		return "Meal [bread=" + bread + ", veg=" + veg + ", daal=" + daal + ", pickle=" + pickle + ", isButter="
				+ isButter + "]";
	}
	
	
	
}
