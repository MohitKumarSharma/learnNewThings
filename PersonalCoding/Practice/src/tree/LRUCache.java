package tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	public static void main(String[] args) {
		CustomLinkedHashMap chm = new CustomLinkedHashMap(3);
		chm.set(2, 10);
		chm.set(1, 10);
		chm.set(3, 10);
		chm.set(4, 10);
		chm.set(5, 10);
		chm.set(2, 10);
		chm.set(1, 10);
	}
}


class CustomLinkedHashMap {
	int capacity;
	LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
	
	public CustomLinkedHashMap(int _capacity) {
		this.capacity = _capacity;
		lhm = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			
			// Eviction policy least recently used to be removed.
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > capacity;
			}
		};
	}
	
	public int get(int key) {
		return lhm.get(key);
	}
	
	public void set(int key, int val) {
		this.lhm.put(key, val);
	}
}