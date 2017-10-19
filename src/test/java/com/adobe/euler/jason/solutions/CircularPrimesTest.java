package com.adobe.euler.jason.solutions;

import static com.adobe.euler.jason.solutions.CircularPrimes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircularPrimesTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Verify the correct answer to the problem.
	 */
	@Test
	public void testAnswer()
	{
		assertEquals(55, findCircularPrimesBelowOneMillion());
	}
	
	/**
	 * Check a handful of positive numbers that should be prime.
	 */
	@Test
	public void isPrime_positivePrimes()
	{
		assertTrue(isPrime(2));
		assertTrue(isPrime(3));
		assertTrue(isPrime(5));
		assertTrue(isPrime(7));
		assertTrue(isPrime(1217));
		assertTrue(isPrime(987509));
	}
	
	/**
	 * Check a handful of positive numbers that should not be prime.
	 */
	@Test
	public void isPrime_positiveNonPrimes()
	{
		assertFalse(isPrime(0));
		assertFalse(isPrime(1));
		assertFalse(isPrime(4));
		assertFalse(isPrime(6));
		assertFalse(isPrime(8));
		assertFalse(isPrime(9));
		assertFalse(isPrime(50));
		assertFalse(isPrime(110));
		assertFalse(isPrime(1566));
	}
	
	/**
	 * Check a handful of negative numbers. None should be prime, as all negative numbers are not prime.
	 */
	@Test
	public void isPrime_negatives()
	{
		assertFalse(isPrime(-1));
		assertFalse(isPrime(-2));
		assertFalse(isPrime(-3));
		assertFalse(isPrime(-4));
		assertFalse(isPrime(-5));
		assertFalse(isPrime(-6));
		assertFalse(isPrime(-7));
		assertFalse(isPrime(-8));
		assertFalse(isPrime(-9));
		assertFalse(isPrime(-50));
		assertFalse(isPrime(-110));
		assertFalse(isPrime(-1217));
	}
	
	@Test
	public void rotate_zero()
	{
		assertEquals(0, rotate(0));
	}
	
	@Test
	public void rotate_oneDigit()
	{
		assertEquals(1, rotate(1));
	}
	
	@Test
	public void rotate_twoDigits()
	{
		assertEquals(73, rotate(37));
	}
	
	@Test
	public void rotate_threeDigits()
	{
		assertEquals(587, rotate(875));
	}
	
	@Test
	public void rotate_fourDigits()
	{
		assertEquals(7490, rotate(4907));
	}
	
	@Test
	public void rotate_sameDigits()
	{
		assertEquals(7777, rotate(7777));
	}
	
	@Test
	public void rotate_negativeNumber()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number must not be negative!");
		
		rotate(-5987);
	}
}
