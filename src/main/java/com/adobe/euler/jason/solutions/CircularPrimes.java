package com.adobe.euler.jason.solutions;

import static com.adobe.euler.jason.solutions.util.Util.notNegative;

/**
 * This class encompasses the solution to <a href="https://projecteuler.net/problem=35">Euler problem 35</a>.
 * 
 * @author Jason T. Hill
 */
public class CircularPrimes
{
	/**
	 * The entry method to this application.
	 * 
	 * @param args This application takes no arguments, so this parameter will be ignored.
	 */
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		System.out.println("The number of circular primes below one million: " + findCircularPrimesBelowOneMillion());
		System.out.println("Calculation time: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	/**
	 * @return The number of numbers below one million that are circularly prime.
	 */
	public static int findCircularPrimesBelowOneMillion()
	{
		int numOfPrimes = 0;
		for(int i = 2; i < 1_000_000; i++)
		{
			boolean isPrime = true;
			int iRotated = i;
			int rotations = String.valueOf(i).length() - 1; // The number of times i will need to be rotated is its length minus 1
			
			do
			{
				// If the current rotation is not prime, stop rotating and move onto the next number; otherwise, rotate and check again
				if(!isPrime(iRotated))
				{
					isPrime = false;
					break;
				}
				iRotated = rotate(iRotated);
			}
			while(rotations-- > 0);
			
			if(isPrime)
			{
				numOfPrimes++;
			}
		}
		
		return numOfPrimes;
	}
	
	/**
	 * Checks if the given integer is a prime number.
	 * 
	 * <p/>
	 * This implementation is a slightly altered version of the one found
	 * <a href="https://stackoverflow.com/questions/1801391/what-is-the-best-algorithm-for-checking-if-a-number-is-prime">here</a>.
	 * 
	 * @param number The number to check for primality.
	 * @return True, if the given number is prime. False, otherwise.
	 */
	public static boolean isPrime(int number)
	{
		if(number == 2 || number == 3)
		{
			return true;
		}
		if(number < 2 || number % 2 == 0 || number % 3 == 0)
		{
			return false;
		}
		
		int i = 5;
		int w = 2;
		while(i * i <= number)
		{
			if(number % i == 0)
			{
				return false;
			}
			i += w;
			w = 6 - w;
		}
		
		return true;
	}
	
	/**
	 * Rotates the given number by moving its last digit to the front.
	 * 
	 * <p/>
	 * Examples:
	 * <ul>
	 * 	<li>1 -> 1</li>
	 * 	<li>34 -> 43</li>
	 * 	<li>754 -> 475</li>
	 * 	<li>9102 -> 2910</li>
	 * </ul>
	 * 
	 * @param number The number to rotate. Must not be negative.
	 * @return The rotated number.
	 */
	public static int rotate(int number)
	{
		String asString = String.valueOf(notNegative(number));
		return Integer.parseInt(asString.charAt(asString.length() - 1) + asString.substring(0, asString.length() - 1));
	}
}
