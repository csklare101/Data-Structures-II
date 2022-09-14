package hw1;

import java.util.TreeMap;

public class HW1 {
	/**
	 * Inverts an array of Strings by returning a TreeMap that maps Strings to the smallest index in the array that contains the String.
	 * 
	 * @param a an array of Strings
	 * @return a Map that given a String returns the smallest index of the array that contains the String
	 * (or null if String is not in the array a).
	 */
	public static TreeMap<String, Integer> invert(String[] a) {
		TreeMap<String, Integer> things = new TreeMap<String,Integer>();	
		for(int i = 0; i < a.length; i++) {
			if(!things.containsKey(a[i])){
			things.put(a[i],i);
			}
		}
		return things;
	}
	
	/**
	 * Computes the total number of occurrences of every String in an array.
	 * 
	 * @param a an array of Strings
	 * @return a Map that given a String returns the number of occurrences of that String in the array
	 * (or null if String is not in the array a).
	 */
	public static  TreeMap<String, Integer> count(String[] a) {
		TreeMap<String, Integer> things = new TreeMap<String,Integer>();
		for(int i = 0; i < a.length; i++) {
			if(things.containsKey(a[i])) {
				things.put(a[i], things.get(a[i]).intValue() + 1);
			}
			else {
				things.put(a[i], 1);
			}
		}
		return things;
	}
}
