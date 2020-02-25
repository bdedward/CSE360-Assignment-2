/**
 * Benjamin Edwards
 * Class ID: 119
 * Assignment1
 * 
 * This file contains the junit test cases for all 5 methods in SimpleList.java
 * These two files were compiled under the assign1 package in Eclipse and have compiled 
 * successfully at time of submission.
 */

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleListTest {

	@Test
	void Test_add() {		
		Integer [] TEST = {9, 8, 7};		
		SimpleList test_add = new SimpleList();
		
		//Building array 9, 8, 7 to test
		test_add.add(7);
		test_add.add(8);
		test_add.add(9);
		
		//Test Cases for Pass Conditions
		assertEquals(TEST[0], test_add.list[0]);
		assertEquals(TEST[1], test_add.list[1]);			
	}
	
	@Test
	public void Test_remove() {		
		SimpleList test_remove = new SimpleList();		
		
		//Building array 1, 2, 3, 4, 5, 5, 7, 9  which will be tested
		test_remove.add(9); 
		test_remove.add(7); 
		test_remove.add(5); 
		test_remove.add(5);
		test_remove.add(4); 
		test_remove.add(3); 
		test_remove.add(2); 
		test_remove.add(1);
	
			
		Integer [] expected1 = {1, 2, 3, 4, 5, 5, 7, 9, null, null};
		Integer [] expected2 = {1, 2, 3, 4, 5, 7, 9, null, null, null};		
		
		//Call remove(8) on list contained in test_remove object
		test_remove.remove(8);
		
		//Tests list array against expected results
		assertArrayEquals(test_remove.list, expected1);
		
		
		//Call remove(5) on list contained in test_remove object
		test_remove.remove(5);	
		
		//Tests list array against expected results 
		//Expect remove() to remove only first appearance of the element 5.
		assertArrayEquals(test_remove.list, expected2);		
	}
	
	@Test
	void Test_count() {
		int expectedCount = 4;
		
		SimpleList test_count = new SimpleList();
		
		//The case where we call count when there are no items in the list:
		int actualCount1 =  test_count.count();
		//Testing expected(0) against actual
		assertEquals(0, actualCount1);
		
		
		//Building array before calling count()
		test_count.add(1); test_count.add(1); test_count.add(1); test_count.add(1);
		
		//The result of counting the list items in test_count object
		int actualCount2 = test_count.count();
		//Testing expected against actual
		assertEquals(expectedCount, actualCount2);
		
		
	}
	
	@Test
	void Test_toString() {
		String expected_toString = "1 2 3 4";
		
		SimpleList test_toString = new SimpleList();
		
		//Testing expected string when there are no elements in the list
		assertEquals("", test_toString.toString());
		
		//Building array before calling count()
		test_toString.add(4); test_toString.add(3); test_toString.add(2); test_toString.add(1);
		
		//Testing expected string against actual string received.
		assertEquals(expected_toString, test_toString.toString());
		
	}
	

	@Test
	void Test_search() {
		int expected_index = 2;
		
		SimpleList test_search = new SimpleList();
		
		//Building array to test search()
		test_search.add(5); test_search.add(2); test_search.add(1);
		
		int actual_index = test_search.search(5);
		
		assertEquals(expected_index, actual_index);		
		
	}
}
