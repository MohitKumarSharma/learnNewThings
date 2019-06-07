package builder;

/**
 * yes it provided immutable object.
 * 
 * Issue with telescoping constructor is if want specific requirement let say bread daal
 * i will have to pass some default veg as bread, daal constructor not exit.
 * 
 * 
 * @author mohit.k
 *
 */
public class MealWithConstructor {
	private  String bread;
	private  String veg;
	private  String daal;
	private  String pickle;
	private  boolean isButter;
	
	public MealWithConstructor(String bread) {
		this.bread = bread;
	}
	
	public MealWithConstructor(String bread, String veg) {
		this(bread);
		this.veg = veg;
		
	}
	public MealWithConstructor(String bread, String veg, String daal) {
		this(bread, veg);
		this.daal = daal;
		
	}
	
	public MealWithConstructor(String bread, String veg, String daal, String pickle) {
		this(bread, veg, daal);
		this.pickle = pickle;
	}
	
	public MealWithConstructor(String bread, String veg, String daal, String pickle, boolean isButter) {
		this(bread, veg, daal, pickle);
		this.isButter = isButter;
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
		return "MealWithConstructor [bread=" + bread + ", veg=" + veg + ", daal=" + daal + ", pickle=" + pickle
				+ ", isButter=" + isButter + "]";
	}
	
}
