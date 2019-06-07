package testJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenObjUtil {
	
	public static <T> List<T> getList(Class<T> _class) {
		List<T> listObj = new ArrayList<>();
		
		if (_class.equals(Person.class)) {
			listObj.addAll((Collection<? extends T>) getPersonList());
		} else {
		}
		
		return listObj;
	}
	
	public static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<>();
		
		Person p = new Person("Mohit", 27);
		personList.add(p);
		
		return personList;
	}
}
