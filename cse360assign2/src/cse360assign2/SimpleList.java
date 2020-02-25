
/**
 * Benjamin Edwards
 * Class ID: 119
 * Assignment2
 * 
 * Implements changes to add() and remove() methods from Assignment 1
 * Adds methods append(), first(), and size() to SimpleList class
 * @author bened
 */

package cse360assign2;


public class SimpleList{
	
Integer[] list;
int count;

/**
 * Initializes the list array to 10 and count to 0.
 */
public SimpleList() {
	list = new Integer[10];
	count = 0;
}

/**
 * Adds element to the beginning of the array.  If the array is full, 
 * replaces last element by shifting every element over.
 * @param n integer input to be added to the array.
 */
public void add(int input) {
	if(list[9] == null)
		count++;
	else {
		count++;
		int size = (int) (list.length * 1.5);
		Integer[] templist = new Integer[size];
		for(int i = 0; i < list.length; i++) {
			templist[i] = list[i];
		}
		list = new Integer[size];
		list = templist;
	}	
	
	for(int i = list.length - 1; i > 0; i--)
		list[i] = list[i-1];
	list[0] = input;
}

/**
 * Removes an element from array, if it exists. Moves other elements down.
 * @param n integer input of the element to be removed from the array.
 */
public void remove(int input) {
	boolean found = false;
	int location = 0;
	for(int i = 0; i < count; i++)   
		if(list[i] == input) {
			list[i] = null;
			found = true;
			location = i;
			i = 10;
		}			
		
	if (found == true) { 
		for(int i = location; i < 9; i++) 
			list[i] = list[i+1];
		count--;
	}
	int emptyCount = 0;
	for(int i = 0; i < list.length; i++)
		if(list[i] == null)
			emptyCount++;
	//Checks for empty spaces > 25%, if true creates a new 
	//array that has 25% empty spaces so that condition
	// >25% is not satisfied
	if((double)(emptyCount / list.length) > 0.25) {
		int target = (int)(0.25/list.length); //The target is calculated by what the length of the list would need to be 
		//to have exactly 25% empty spaces
		int size = (int) (list.length - (target - emptyCount)); //the size is calculated by subtracting the difference between
		//target and current emptyCount from the current list length
		
		int i = 0;
		Integer[] templist = new Integer[size];
		while(list[i] != null) {
			templist[i] = list[i];
			i++;
		}
		list = new Integer[size];
		list = templist;
	}
	
}

/**
 * Returns the number of elements in the list.
 * @return the count of the elements in the array
 */
public int count() {
	int temp = 0;
	for(int i = 0; i < 10; i++)
		if(list[i] != null)
			temp++;
	return temp;
}

/**
 * @return the list as a string, elements separated by space.
 */
public String toString() {
	if(count == 0)
		return "";
	String temp = "";
	for(int i = 0; i < 10; i++) {
		if(list[i] != null) {
			if(i < 9) 
				temp += list[i] + " ";
		}
	}
	if(temp != "");
		temp = temp.substring(0, temp.length() - 1);	
	return temp;
}

/**
 * Returns the index of the parameter in the list, if not in list returns -1.
 * @param n integer input of the element to search for.
 * @return the index of the element, if found.
 */
public int search(int input) {
	int temp = -1;
	for(int i = 0; i < 10; i++) 
		if(list[i] == input) {
			temp = i;
			i = 10;
		}	
	return temp;
}

public void append(int input) {
	if(list[list.length-1] != null) {
		//Method to increase length of list by 50%
		int size = (int) (list.length * 1.5);
		Integer[] templist = new Integer[size];
		for(int i = 0; i < list.length; i++) {
			templist[i] = list[i];
		}
		list = new Integer[size];
		list = templist;
	}
	int position = 0;
	int i = 0;
	//searches for first empty position
	while(list[i] != null) {
		position++;		
	}
	//input goes to first empty space(at end of the list of numbers)
	list[position] = input;
	count++;
}
/**
 * Returns the first element of the list
 * @return
 */
public int first() {
	return list[0];
}
/**
 * Returns the number of locations in the list
 * @return
 */
public int size() {
	return list.length;
}

}