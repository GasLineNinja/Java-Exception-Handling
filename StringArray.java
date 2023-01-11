import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * A class that stores a number of Strings in an array.
 * It provides a number of methods to interact with the Strings.
 * Null references are allowed in the String array
 */

public class StringArray {
	
	private String arr[];
	

	/**
	 * Constructor for the SuperStringArray class
	 * @param arr the string array to store in this object
	 * @throws IllegalArgumentException if arr is null
	 */
	public StringArray(String arr[]) {
		//TODO
		// if array is null, throw an IllegalArgumentException
		// otherwise create a copy of the array and store it in arr
		// you can use Arrays.copyOf(original, newLength) to make the copy
		this.arr = arr;
		if (arr == null) {throw new IllegalArgumentException("Array is null");}
		Arrays.copyOf(arr, arr.length);
	}
	
	
	/**
	 * Replace the string at a given index with the string passed
	 * @param stringIndex the index to overwrite
	 * @param stringToAdd the string to add
	 * @throws IllegalArgumentException if the index is out of bounds
	 * @return the string that was replaced
	 */
	public String replaceString(int stringIndex, String stringToAdd) {
		//TODO
		// replace the string at the given index with the given string
		// if the index is out of bounds, throw an IllegalArgumentException
		// one way to do this is by catching the IndexOutOfBoundsException
		// your exception must have the message "index <i> is out of bounds"
		// return the previous string if no exception was thrown
		
		try {
		
			if (stringIndex > 0 && stringIndex < arr.length) {
				String tempString = arr[stringIndex];
				arr[stringIndex] = stringToAdd;
				return tempString;	
			}
		}
		catch(IndexOutOfBoundsException ex) {
			throw new IllegalArgumentException("index <i> is out of bounds");		
		}
		return stringToAdd;
		
		}
	
	/**
	 * Return the average length of non-null strings in the array
	 * Null strings are not counted as strings
	 * Uses integer division to get an integer result
	 * @return the average length of strings
	 */
	public int averageCharsInt() {
		//TODO
		// this method should not throw any exceptions
		// it should return 0 if there are no non-null strings
		// you might catch a NullPointerException or ArithmeticException (from division by 0)
		// you also might design your code not to cause these errors
		int i;
		int j = 0;
		int arrLength = 0;
		try {
		for (i = 0; i < arr.length; ++i) {
			if (arr.length == 0) {return 0;}
			if (arr[i] == null) {continue;}
			if (arr[i] != null) {++j;}
			arrLength += arr[i].length();
		}
		
		return arrLength / j;
		}
		catch(NullPointerException | ArithmeticException ex) {
			if (arr.length == 0) {return 0;}
		}
		return 0;
	}
	
	
	/**
	 * Remove a single character at a given index from a the string at the given index
	 * @param stringIndex the index of the string in the array
	 * @param charIndex the index of the character to remove
	 * @throws ArrayIndexOutOfBoundsException if stringIndex is out of bounds
	 * @throws StringIndexOutOfBoundsException if charIndex is out of bounds
	 * @throws NoSuchElementException if there is no string at stringIndex
	 */
	public void removeCharAtFromStr(int stringIndex, int charIndex) {
		//TODO
		// find the string at stringIndex
		// remove the character at the given index from that string
		//    (try using substring to get the two halves of the string before and after the removed character)
		// make sure all exceptions are thrown as described in the javadoc
		
		try {
		for (int i = 0; i < arr.length; i++) {
		
			
			
		}
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			throw new ArrayIndexOutOfBoundsException("stringIndex is out of bounds");
		}
		catch(StringIndexOutOfBoundsException ex) {
			throw new StringIndexOutOfBoundsException("charIndex is out of bounds");
		}
		catch(NoSuchElementException ex) {
			throw new NoSuchElementException("No string at stringIndex");
		}
		
	}
	
	@Override
	public String toString(){
		return arr.length + " String(s), average " + averageCharsInt() + " char(s) per String";
	}
	
	
	//TODO
	// Write javadoc for this method
	// (Remember, you only need to mention exceptions that will be received by the caller of this method)
	
	/**
	 * Retrieve a string at the given index of the array
	 * @throws IllegalArgumentException an exception if stringIndex is smaller or larger than the array
	 * @param stringIndex
	 * @return stringIndex
	 */
	public String retrieveStringAt(int stringIndex){
		try{
			return arr[stringIndex];
		} catch(ArrayIndexOutOfBoundsException e){
			throw new IllegalArgumentException("the string index given was not inside the array");
		}
	}
	
	
}

