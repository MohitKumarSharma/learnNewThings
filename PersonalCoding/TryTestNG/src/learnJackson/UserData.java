package learnJackson;

import java.util.Arrays;

public class UserData {
	private Student student;
	private String aliasName;
	private boolean verified;
	private int marks[];
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "UserData [student=" + student + ", aliasName=" + aliasName + ", verified=" + verified + ", marks="
				+ Arrays.toString(marks) + "]";
	}
	
	
	
}
