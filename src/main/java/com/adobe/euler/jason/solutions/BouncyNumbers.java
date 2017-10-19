package com.adobe.euler.jason.solutions;

import static com.adobe.euler.jason.solutions.util.Util.notNegative;

/**
 * This class encompasses the solution to <a href="https://projecteuler.net/problem=112">Euler problem 112</a>.
 * 
 * @author Jason T. Hill
 */
public class BouncyNumbers
{
	/**
	 * The entry method to this application.
	 * 
	 * @param args This application takes no arguments, so this parameter will be ignored.
	 */
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		System.out.println("The least number for which the proportion of bouncy numbers is exactly 99%: " + find99PercentBouncyNumber());
		System.out.println("Calculation time: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	/**
	 * @return The first number for which the proportion of bouncy numbers up until that point is exactly 99%.
	 *         -1 will be returned if this number happens to not exist somewhere under {@link Integer#MAX_VALUE}.
	 */
	public static int find99PercentBouncyNumber()
	{
		double numBouncy = 0;
		for(int i = 0; i < Integer.MAX_VALUE; i++)
		{
			if(isBouncy(i))
			{
				numBouncy++;
			}
			
			// Check if the number of bouncy numbers up to this point is 99% of the total numbers seen so far
			if(numBouncy / i == 0.99)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Checks if the given number is not bouncy. A number is not bouncy if its digits, working in one direction, either continually increase or decrease
	 * until the end of the number (being equal also valid in both cases).
	 * 
	 * <p/>
	 * Examples:
	 * <ul>
	 * 	<li>4 -> not bouncy</li>
	 * 	<li>53 -> not bouncy</li>
	 * 	<li>121 -> bouncy</li>
	 * 	<li>1479 -> not bouncy</li>
	 * 	<li>987741 -> not bouncy</li>
	 * </ul>
	 * 
	 * @param number The number to check for bounciness. Must not be negative.
	 * @return True, if the given number is bouncy. False, otherwise.
	 */
	public static boolean isBouncy(int number)
	{
		if(notNegative(number) <= 100)
		{
			return false;
		}
		
		boolean increasing = true;
		boolean decreasing = true;
		
		// Trim off each digit, one at a time, comparing it to the previous digit to determine if it is continually increasing or decreasing
		int prev = number % 10;
		number = number / 10;
		while(number != 0)
		{
			int cur = number % 10;
			if(increasing && cur > prev)
			{
				increasing = false;
			}
			else if(decreasing && cur < prev)
			{
				decreasing = false;
			}
			
			// If the number is no longer increasing or decreasing, then it is bouncy
			if(!increasing && !decreasing)
			{
				return true;
			}
			
			prev = cur;
			number = number / 10;
		}
		
		return false;
	}
}
