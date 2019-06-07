package builder;

public class MealWithSetter {
	private  String bread;
	private  String veg;
	private  String daal;
	private  String pickle;
	private  boolean isButter;
	
	
	public String getBread() {
		return bread;
	}
	public void setBread(String bread) {
		this.bread = bread;
	}
	public String getVeg1() {
		return veg;
	}
	public void setVeg(String veg) {
		this.veg = veg;
	}
	public String getDaal() {
		return daal;
	}
	public void setDaal(String daal) {
		this.daal = daal;
	}
	public String getPickle() {
		return pickle;
	}
	public void setPickle(String pickle) {
		this.pickle = pickle;
	}
	public boolean isButter() {
		return isButter;
	}
	public void setButter(boolean isButter) {
		this.isButter = isButter;
	}
	
	@Override
	public String toString() {
		return "Meal [bread=" + bread + ", veg=" + veg + ", daal=" + daal + ", pickle=" + pickle + ", isButter="
				+ isButter + "]";
	}
	
	
}
