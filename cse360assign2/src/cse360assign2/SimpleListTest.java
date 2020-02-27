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
		
		//Testing for non-existent value in list
		int expected_index2 = -1;
		int actual_index2 = test_search.search(6);
		
		assertEquals(expected_index2, actual_index2);
		
	}
	
	@Test
	void Test_append() {
		SimpleList test_append = new SimpleList();
		
		//Building array to test append()
		test_append.add(5); test_append.add(3); test_append.add(9);
		
		Integer[] expected = {9, 3, 5, 2, null, null, null, null, null, null};
		
		test_append.append(2);
		//Testing appended location to confirm list was updated properly
		assertEquals(expected[3], test_append.list[3]);
		
		SimpleList T2 = new SimpleList();
		
		//Building second array to test append() on a full list
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		T2.add(9);
		
		Integer [] expected2 = {9,9,9,9,9,9,9,9,9,9,4,null,null,null,null};
		
		//Call append(4) on T2
		T2.append(4);
		//Testing appended location of a list that was full before append
		assertEquals(expected2[10], T2.list[10]);		
	}
	
	@Test
	void Test_first() {
		SimpleList test_first = new SimpleList();
		
		Integer expected1 = -1;
		Integer actual1 = test_first.first();
		
		assertEquals(actual1, expected1);
		
		
		test_first.add(4);
		test_first.add(3);
		
		Integer expected2 = 3;
		Integer actual2 = test_first.first();
		
		assertEquals(actual2, expected2);
	}
	
	@Test
	void Test_last() {
		SimpleList test_last = new SimpleList();
		
		int expected1 = -1;
		int actual1 = test_last.last();
		
		assertEquals(expected1, actual1);
		
		SimpleList test_last2 = new SimpleList();
		test_last2.add(1);
		
		int expected2 = 1;
		int actual2 = test_last2.last();
		
		assertEquals(expected2, actual2);
	}
	
	@Test
	void Test_size() {
		SimpleList test_size = new SimpleList();
		
		int expected = 10;
		int actual = test_size.size();
		
		assertEquals(expected, actual);
		
		SimpleList test_size2 = new SimpleList();
		
		//Building array of 10 elements, then calling add(2) to increase its' size
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(8);
		test_size2.add(2);
		
		int actual2 = test_size2.size();
		int expected2 = 15;
		
		assertEquals(actual2, expected2);		
	}
}
