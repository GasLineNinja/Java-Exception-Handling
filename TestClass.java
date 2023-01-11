import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class TestClass extends TestCase{

		StringArray ssa1,ssa2,ssa3,ssa4,ssa5,ssa6;
		
		
	public void setUp() {
		ssa1 = new StringArray(new String[] {"test","this","should","form","a","sentence"});
		ssa2 = new StringArray(new String[] {"aaaa","bbbb","cccc","dddd","eeee"});
		ssa3 = new StringArray(new String[] {"small"});
		ssa4 = new StringArray(new String[] {});
		ssa5 = new StringArray(new String[] {null, null});
		ssa6 = new StringArray(new String[] {"missing", null, "one"});
	}
	
	//testing constructor
	public void test01() {

		boolean caught = false;
		try {
			new StringArray(new String[] {null,"bbbb",null,"dddd","eeee","fffff"});
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertFalse(caught);
		
		caught = false;
		try {
			new StringArray(null);
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertTrue(caught);
		
		caught = false;
		try {
			new StringArray(new String[]{});
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertFalse(caught);
		
		caught = false;
		try {
			new StringArray(new String[]{"aaaa","bbbb","cccc"});
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertFalse(caught);
		
	}
	
	//testing replaceString
	public void test02(){
		
		boolean caught = false;
		try {
			ssa1.replaceString(-40, "barndoor");
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertTrue(caught);
		
	
		assertEquals("should", ssa1.replaceString(2, "barndoor"));
		assertEquals("barndoor",ssa1.retrieveStringAt(2));
	
		caught = false;
		try {
			ssa4.replaceString(0, "anything");
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertTrue(caught);
		
		caught = false;
		try {
			ssa3.replaceString(1, "close");
		} catch(IllegalArgumentException e) {
			caught = true;
			assertEquals("index 1 is out of bounds",e.getMessage());
		}
		assertTrue(caught);
		
		caught = false;
		try {
			ssa1.replaceString(2, null);
		} catch(IllegalArgumentException e) {
			caught = true;
			assertEquals("Strings inside SuperStringArray must never be null",e.getMessage());
		}
		assertFalse(caught);
		assertNull(ssa1.retrieveStringAt(2));
		
		caught = false;
		try {
			ssa1.replaceString(50, null);
		} catch(IllegalArgumentException e) {
			caught = true;
		}
		assertTrue(caught);
		
	}
	
	//testing averageCharsInt
	public void test03() {
		assertEquals(4,ssa1.averageCharsInt());
		assertEquals(4,ssa2.averageCharsInt());
		assertEquals(5,ssa3.averageCharsInt());
		assertEquals(0,ssa4.averageCharsInt());
		assertEquals(0,ssa5.averageCharsInt());
		assertEquals(5,ssa6.averageCharsInt());
		
		boolean caught = false;
		try {
			ssa5.averageCharsInt();
		} catch(ArithmeticException e) {
			caught = true;
		} catch(NullPointerException e) {
			caught = true;
		}
		assertFalse(caught);
	}
	
	//testing removeCharAtFromString
	public void test04() {
	
		
		boolean caughtAIOB = false;
		try {
			ssa1.removeCharAtFromStr(-40, 0);
		} catch(ArrayIndexOutOfBoundsException e) {
			caughtAIOB = true;
		}
		assertTrue(caughtAIOB);
		
		caughtAIOB = false;
		try {
			ssa4.removeCharAtFromStr(0, 0);
		} catch(ArrayIndexOutOfBoundsException e) {
			caughtAIOB = true;
		}
		assertTrue(caughtAIOB);

		boolean caughtSIOB = false;
		boolean caughtIOB = false;
		try {
			ssa1.removeCharAtFromStr(-40, -1);
		} catch(StringIndexOutOfBoundsException e) {
			caughtSIOB = true;
		} catch(IndexOutOfBoundsException e) {
			caughtIOB = true;
		}
		assertFalse(caughtSIOB);
		assertTrue(caughtIOB);

		caughtSIOB = false;
		try {
			ssa1.removeCharAtFromStr(1, -1);
		}catch(StringIndexOutOfBoundsException e) {
			caughtSIOB = true;
		}
		assertTrue(caughtSIOB);

		caughtSIOB = false;
		try {
			ssa1.removeCharAtFromStr(1, 4);
		}catch(StringIndexOutOfBoundsException e) {
			caughtSIOB = true;
		}
		assertTrue(caughtSIOB);
		
		boolean caughtNSEE = false;
		caughtSIOB = false;
		caughtAIOB = false;
		caughtIOB = false;
		try {
			ssa5.removeCharAtFromStr(0, 0);
		} catch(StringIndexOutOfBoundsException e) {
			caughtSIOB = true;
		} catch(ArrayIndexOutOfBoundsException e) {
			caughtAIOB = true;
		} catch(IndexOutOfBoundsException e) {
			caughtIOB = true;
		} catch(NoSuchElementException e) {
			caughtNSEE = true;
		}
		assertFalse(caughtSIOB);
		assertFalse(caughtAIOB);
		assertFalse(caughtIOB);
		assertTrue(caughtNSEE);
		
		
		ssa1.removeCharAtFromStr(0, 1);
		assertEquals("tst",ssa1.retrieveStringAt(0));
		
		ssa2.removeCharAtFromStr(1, 0);
		assertEquals("bbb",ssa2.retrieveStringAt(1));
		
		ssa6.removeCharAtFromStr(2, 2);
		assertEquals("on",ssa6.retrieveStringAt(2));
	}
	
	//testing retrieveStringAt 
	public void test05_FIX(){
		//TODO write tests for retrieveStringAt
		// make sure you run tests on special cases like:
		//  the StringArray with size 0
		//  the StringArray with only null strings
		// write some tests that get correct output
		// write some tests that (correctly) generate exceptions
		// write tests that make sure the correct exception type is thrown
		boolean caughtAIOB = false;
		try {
			ssa1.retrieveStringAt(-40);
		} catch(ArrayIndexOutOfBoundsException e) {
			caughtAIOB = true;
		}
		assertTrue(caughtAIOB);
		
		boolean caughtNSE = false;
		try {
			ssa4.retrieveStringAt(2);
		} catch(NoSuchElementException e) {
			caughtNSE = true;
		}
		assertTrue(caughtNSE);
		
	}
	
	
}
