//Testing


/**
 * Benjamin Edwards
 * Class ID: 119
 * Assignment1
 * 
 * Implements methods to add/delete elements
 * from a 10 element integer array.  It also supports the functionality
 * of receiving a string representation of the array.  Finally, it 
 * contains a method to return the count of the number of elements
 * currently in the array.
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
	for(int i = 9; i > 0; i--)
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
		
	if (found == true) 
		for(int i = location; i < 9; i++) 
			list[i] = list[i+1];
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

}