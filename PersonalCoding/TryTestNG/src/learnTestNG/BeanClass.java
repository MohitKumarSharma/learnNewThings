package learnTestNG;

public class BeanClass {
	String desc;
	int val;
	
	public BeanClass(String _desc, int _val) {
		this.desc = _desc;
		this.val = _val;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
}
