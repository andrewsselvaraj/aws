package com.atm.data;

import java.util.TreeSet;

public class  Denomination { 

	public static TreeSet<Integer> denomonation()
	{
	TreeSet<Integer> ints = new TreeSet<Integer>(); 
	ints.add(20);
	ints.add(10);
	ints.add(5);
	ints.add(1);
	TreeSet<Integer> intsReverse = (TreeSet<Integer>)ints.descendingSet(); 
	return intsReverse;
	  
	}
	
} 
