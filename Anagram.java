/* 
This java program checks to see if two strings are anagrams.
*/ 

import java.util.*;
import java.sql.Timestamp;

public class Anagram{

public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the first string: ");
	String first = scan.nextLine();
	System.out.println("Enter the second string: ");
	String second = scan.nextLine();
	System.out.println("Which algorithm would you like to use? (Enter \"W\" for Wayne's algorithm or \"C\" for Cracking the code's.)");
	String choice = scan.nextLine().trim().toUpperCase();
	if (choice.equals("C")){
		
		for (int x = 0; x < 1000000; x++){
			boolean z = isAnagramNoMap(first, second);
		}
	System.out.println(isAnagramNoMap(first, second));
	
}
	if (choice.equals("W")){
		
		for (int x = 0; x < 1000000; x++){
			boolean z = isAnagram(first, second);
		}
	System.out.println(isAnagram(first, second));
}
}

//My algorithm
public static boolean isAnagram(String str1, String str2){

	if(str1.length() != str2.length()) return false;
	str1 = str1.toLowerCase();
	str2 = str2.toLowerCase();
	HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
	for (int x = 0; x< str1.length(); x++){
	myMap.put(str1.charAt(x), new Integer(x));
	}
	for (int y = 0; y < str2.length(); y++){
	if (myMap.containsKey(str2.charAt(y))){
	myMap.remove(str2.charAt(y));
	}
	else return false;
	}
	return true;
}
//Cracking the code's algorithm
public static boolean isAnagramNoMap(String str1, String str2){
	if(str1.length() != str2.length()) return false;
	str1 = str1.toLowerCase();
	str2 = str2.toLowerCase();
	int[] letters = new int[256];
	int numU = 0;
	int numC = 0;
	char[] sArray = str1.toCharArray();
	for (char c : sArray) {
		if(letters[c] == 0) ++numU;
		++letters[c];
	}
	for (int i = 0; i < str2.length(); i++){
		int c = (int) str2.charAt(i);
		if (letters[c] == 0) return false;
	
	--letters[c];
	if (letters[c] == 0) {
		++numC;
		if (numC == numU) {
			return i == str2.length() - 1;
		}
	}
}
	return false;

}
}


