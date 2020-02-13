package Main;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// Task 1
		System.out.println("Total count of 'abc' and 'aba' in \"abcabaccc\": " + AbcAbaCount("abcabaccc"));
		
		// Task 2
		System.out.println("Total count of '11' without overlap in \"111test11111\": " + ElevenCount("111test11111"));
		
		// Task 3
		int[] testArray = new int[] {25, 5, 10, 10, 10};
		System.out.println("The sum of each split array are equal: " + splitArray(testArray, testArray.length));
	}
	
//	1-
//	Count recursively the total number 
//	of "abc" and "aba" substrings 
//	that appear in the given string.
	
	static int AbcAbaCount(String str) {
		if (str.length() < 3)
			return 0;
		if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba")) 
			return 1 + AbcAbaCount(str.substring(3));
		
		return AbcAbaCount(str.substring(1));
	}
	
	
	
//	2-
//	Given a string, compute recursively (no loops) 
//	the number of "11" substrings in the string. 
//	The "11" substrings should not overlap.

	static int ElevenCount(String str) {
		if (str.length() < 2)
			return 0;
		if (str.substring(0, 2).equals("11"))
				return 1 + ElevenCount(str.substring(2));
		return ElevenCount(str.substring(1));
	}
	
//	3-
//	Given an array of ints, is it possible to 
//	divide the ints into two groups, so that the 
//	sums of the two groups are the same. 
//	Every int must be in one group or the other. 
//	Write a recursive helper method that takes whatever
//	 arguments you like, and make the initial call to your 
//	recursive helper from splitArray(). (No loops needed.)

//	splitArray([2, 2]) ? true
//	splitArray([2, 3]) ? false
//	splitArray([5, 2, 3]) ? true
	
	static boolean splitArray(int[] arr, int arrLength) {
		
		//middle index of the array
		int middleIndex = arrLength / 2;
		
		//split array
		int[] leftSide = Arrays.copyOfRange(arr, 0, middleIndex);
		int[] rightSide = Arrays.copyOfRange(arr, middleIndex, arr.length);
		
		if (sumOfArray(leftSide, leftSide.length) == sumOfArray(rightSide, rightSide.length)) 
			return true;
		
		return false;
	}
	
	static int sumOfArray(int[] arr, int arrLength) {
 
		// if length is 0, there is no value so 0
		if (arrLength <= 0)
			return 0;
		// else return the last index of the array + last index of same array but length - 1
		return arr[arrLength - 1] + sumOfArray(arr, arrLength-1);
	}
}
