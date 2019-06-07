package testThread;

import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadFailSafe {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();
		
		cmap.put("mohit", "rampur");
		cmap.put("parag", "pune");
		//cmap.put("parag1", "pune1");
		
		Iterator<String> itr = cmap.keySet().iterator();
		
		while (itr.hasNext()) {
			  String key = (String)itr.next(); 
		         System.out.println(key + " : " + cmap.get(key)); 

			
			cmap.put("Aniketh", "Hyderabad");
		}
		
		itr = cmap.keySet().iterator();
		
		while (itr.hasNext()) {
			  String key = (String)itr.next(); 
	         System.out.println(key + " : " + cmap.get(key)); 
		}
//		
//		 ConcurrentHashMap<String, Integer> map 
//         = new ConcurrentHashMap<String, Integer>(); 
//
//     map.put("ONE", 1); 
//     map.put("TWO", 2); 
//     map.put("THREE", 3); 
//     map.put("FOUR", 4); 
//
//     // Getting an Iterator from map 
//     Iterator it = map.keySet().iterator(); 
//
//     while (it.hasNext()) { 
//         String key = (String)it.next(); 
//         System.out.println(key + " : " + map.get(key)); 
//
//         // This will reflect in iterator. 
//         // Hence, it has not created separate copy 
//         map.put("SEVEN", 7); 
//     } 
 } 
	
}
