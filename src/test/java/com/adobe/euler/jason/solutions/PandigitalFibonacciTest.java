package com.adobe.euler.jason.solutions;

import static com.adobe.euler.jason.solutions.PandigitalFibonacci.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PandigitalFibonacciTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Verify the correct answer to the problem.
	 */
	@Test
	public void testAnswer()
	{
		assertEquals(329468, findBiPandigitalFibonacci());
	}
	
	/**
	 * Check some numbers that should be pandigital.
	 */
	@Test
	public void isPandigital_orderedPandigital()
	{
		assertTrue(isPandigital(123456789));
		assertTrue(isPandigital(234567891));
		assertTrue(isPandigital(345678912));
		assertTrue(isPandigital(456789123));
		assertTrue(isPandigital(567891234));
		assertTrue(isPandigital(678912345));
		assertTrue(isPandigital(789123456));
		assertTrue(isPandigital(891234567));
		assertTrue(isPandigital(912345678));
	}
	
	/**
	 * Since it would be tough to check all 362,880 pandigital combinations, let's randomly create a bunch that must be pandigital and test them.
	 */
	@Test
	public void isPandigital_randomPandigital()
	{
		Random rand = new Random();
		List<Character> chars = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
		
		for(int i = 0; i < 1_000_000; i++)
		{
			List<Character> tempChars = new ArrayList<>(chars);
			String toTest = "";
			while(!tempChars.isEmpty())
			{
				toTest += tempChars.remove(rand.nextInt(tempChars.size()));
			}
			assertTrue(isPandigital(Integer.parseInt(toTest)));
		}
	}
	
	/**
	 * Check some numbers that should not be pandigital.
	 */
	@Test
	public void isPandigital_notPandigital()
	{
		assertFalse(isPandigital(133887564));
		assertFalse(isPandigital(382957764));
		assertFalse(isPandigital(999999999));
		assertFalse(isPandigital(339882712));
	}
	
	@Test
	public void isPandigital_not9Digits()
	{
		assertFalse(isPandigital(1));
		assertFalse(isPandigital(12));
		assertFalse(isPandigital(123));
		assertFalse(isPandigital(1234));
		assertFalse(isPandigital(12345));
		assertFalse(isPandigital(123456));
		assertFalse(isPandigital(1234567));
		assertFalse(isPandigital(12345678));
		assertFalse(isPandigital(1234567890));
	}
	
	@Test
	public void isPandigital_negativeNumber()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number must not be negative!");
		
		assertFalse(isPandigital(-123456789));
	}
}
