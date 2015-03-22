/*
This program takes as its input a string and replaces all the spaces with 
'%20'
*/


import java.util.*;

public class Replace{
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
	System.out.println("Would you like to try Wayne's algorithm" 
	   +	"or Cracking the Code's?:(Enter a 'W' or 'C') ");
	char selection = scan.nextLine().trim().toUpperCase().charAt(0);
	System.out.println("Please enter a string: ");
	if ((int)selection == (int)('W')){
	System.out.println(replaces(scan.nextLine()));
	}
	else if ((int)selection == (int)('C')){
		String x = scan.nextLine();
		System.out.println(replaceFun(x.toCharArray(), x.length()));
	}

	}
	// Wayne's Algorithm
	private static String replaces(String str){
		if(str.length() < 1) return str;
		if (!str.contains(" ")) return str;
		char[] strArr = str.toCharArray();
		int count = 0;
		int[] nums = new int[strArr.length];
		for (int x = 0; x<strArr.length; x++){
			if ((int)strArr[x] == (int) ' '){
				nums[count] = x;
				count++;
			}
		}
		int y = 0;
		int z = 0;
		char[] newArr = new char[2*count + strArr.length];
		for(int x = 0; x< newArr.length; x++){
			if (z == nums[y]) {
				newArr[x++] = '%';
				newArr[x++] = '2';
				newArr[x] = '0';
				z++;
				y++;
				continue;
			}
			newArr[x] = strArr[z];
			z++;
		}
		return new String(newArr);
	}
	//Cracking the code's algorithm
	//Had to add some extra code and move some stuff for their algorithm to work
	/*Thier code assumes that the char array coming in has enough room
	  to accomodate the new length.
	  */
	public static char[] replaceFun(char[] str, int length){
	int spaceCount = 0, newLength;
	for(int i = 0; i < length; i++) {
	if ((int)str[i] == (int)' ') { spaceCount++;

	}
}
	newLength = length + spaceCount * 2; 
	char[] newStr = new char[newLength + 1];
	newStr[newLength] = '\0';
	for (int i = length - 1; i >= 0; i--) {
	if ((int)str[i] == (int)' ') { newStr[newLength - 1] = '0'; 
	newStr[newLength - 2] = '2'; newStr[newLength - 3] = '%'; newLength = newLength - 3;
	} else {
	newStr[newLength - 1] = str[i];
	newLength = newLength - 1; }
	}
	return newStr;
	}
}