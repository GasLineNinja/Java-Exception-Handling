import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Driver {
	
	static StringArray array = new StringArray(new String[] {"test","this","should","form","a","sentence",null,"aaa", "bbb"});
	static Scanner scr;
	
	public static void main(String args[]){
		scr = new Scanner(System.in);
		promptForRemove();
	}
	
	
	
	
	
	public static void promptForRemove(){
		int x;
		while(true){
			System.out.println("Enter the index for the string to edit:");
			try{
				x = scr.nextInt();
				System.out.println("Enter the index for the char to remove: ");
				int toRemove= scr.nextInt();
				array.removeCharAtFromStr(x,toRemove);
			}catch(InputMismatchException e ){
				System.out.println("Error: must be an int.");
				scr.next();
				continue;
			}
			//TODO catch all exceptions that removeCharAtFromStr can throw
			//Print out a message describing what was wrong with the input
			//Make sure you mention which input was problematic
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Index out of bounds.");
				continue;
			}
			catch (StringIndexOutOfBoundsException e) {
				System.out.println("Index out of bounds.");
				continue;
			}
			
			System.out.println(array.retrieveStringAt(x));
			break;
			}
	}
}
