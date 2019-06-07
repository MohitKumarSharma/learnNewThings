package testThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HexToDecimal {
	static char decToHexNotation[] = new char[16];
	static HashMap<Character, Integer> hexToDec;
	static int base = 16;
 	
	public static void main(String[] args) {
		init();
		String hexN = decimalToHex(1000);
		
		System.out.println(hexN);
		
		int bNumb = hexToDecimal(hexN);
		System.out.println(bNumb);
		
		
	}
	
	public static void init() {
		hexToDec = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			decToHexNotation[i] = (char)(i + 48);
		}
		
		decToHexNotation[10] = 'A';
		decToHexNotation[11] = 'B';
		decToHexNotation[12] = 'C';
		decToHexNotation[13] = 'D';
		decToHexNotation[14] = 'E';
		decToHexNotation[15] = 'F';
		
		for (int i = 0; i < 16; i++) {
			hexToDec.put(decToHexNotation[i], i);
		}
	}
	
	public static int hexToDecimal(String _number) {
		char[] cNumber = _number.toCharArray();
		
		int number = 0;
		
		for (int i = 0; i < cNumber.length ; i++) {
			number = base*number + hexToDec.get(cNumber[i]);
		}
		
		return number;
	}
	
	public static String decimalToHex(int _number) {
		ArrayList<Character> list = new ArrayList<>();
		
		
		
		
		int tempNumber = _number;
		
		
		while (tempNumber > 0) {
			list.add(decToHexNotation[tempNumber%base]);
			tempNumber = tempNumber/16;
		}
		
		Collections.reverse(list);
		
		StringBuilder sb = new StringBuilder();
		
		list.stream().forEach(c -> sb.append(c));
		
		
		return sb.toString();
	}
}
