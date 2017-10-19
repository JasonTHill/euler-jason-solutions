package com.adobe.euler.jason.solutions.util;

/**
 * A class of general utility functions.
 * 
 * @author Jason T. Hill
 */
public class Util
{
	private Util() {}
	
	/**
	 * Verifies that the given number is not negative.
	 * 
	 * @param number The number to verify.
	 * @return The given number.
	 * @throws IllegalArgumentException If the given number is negative.
	 */
	public static int notNegative(int number)
	{
		if(number < 0)
		{
			throw new IllegalArgumentException("number must not be negative!");
		}
		
		return number;
	}
}
