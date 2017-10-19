package com.adobe.euler.jason.solutions;

import static com.adobe.euler.jason.solutions.util.Util.notNegative;

import java.math.BigInteger;

/**
 * This class encompasses the solution to <a href="https://projecteuler.net/problem=104">Euler problem 104</a>.
 * 
 * @author Jason T. Hill
 */
public class PandigitalFibonacci
{
	private static final BigInteger GET_TAIL = BigInteger.valueOf(1_000_000_000);
	
	private static final int NUM_OF_POWS = 70000;
	private static final BigInteger[] POWS_OF_TEN = new BigInteger[NUM_OF_POWS];
	static
	{
		// Pre-calculate powers of ten to save time. This is a little more than we need, but it won't take much time.
		POWS_OF_TEN[0] = BigInteger.ONE;
		for(int i = 1; i < NUM_OF_POWS; i++)
		{
			POWS_OF_TEN[i] = POWS_OF_TEN[i - 1].multiply(BigInteger.TEN);
		}
	}
	
	/**
	 * The entry method to this application.
	 * 
	 * @param args This application takes no arguments, so this parameter will be ignored.
	 */
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		System.out.println("First fibonacci number pandigital on both ends: " + findBiPandigitalFibonacci());
		System.out.println("Calculation time: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	/**
	 * @return The nth fibonacci number, where n is the first fibonacci number that is pandigital on both ends.
	 *         -1 will be returned if this number happens to not exist somewhere under {@link Integer#MAX_VALUE}.
	 */
	public static int findBiPandigitalFibonacci()
	{
		// Since pandigital numbers must contain at least 9 digits, we can start at the 40th fibonacci number
		BigInteger prevFib = new BigInteger("63245986"); // The 39th fibonacci number
		BigInteger curFib = new BigInteger("102334155"); // The 40th fibonacci number
		
		for(int i = 40; i < Integer.MAX_VALUE; i++)
		{
			if(isPandigital(curFib.divide(POWS_OF_TEN[(int)(curFib.bitLength() * Math.log10(2) - 8d)]).intValue()) && // Check the first 9
			   isPandigital(curFib.mod(GET_TAIL).intValue())) // Check the last 9
			{
				return i;
			}
			
			// Calculate the next fibonacci number
			BigInteger tempFib = curFib;
			curFib = prevFib.add(curFib);
			prevFib = tempFib;
		}
		
		return -1;
	}
	
	/**
	 * Checks if the given integer is pandigital. For it to be pandigital, it must have exactly 9 digits and contain each number from
	 * 1 through 9 in any order.
	 * 
	 * @param number The number to check for pandigital-ness. Must not be negative.
	 * @return True, if the given number is pandigital. False, otherwise.
	 */
	public static boolean isPandigital(int number)
	{
		String asString = String.valueOf(notNegative(number));
		
		if(asString.length() != 9)
		{
			return false;
		}
		
		return asString.chars().filter(c -> c != '0')
							   .distinct()
							   .count() == 9;
	}
}
