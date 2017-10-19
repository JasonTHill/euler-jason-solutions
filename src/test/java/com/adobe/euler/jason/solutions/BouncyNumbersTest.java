package com.adobe.euler.jason.solutions;

import static com.adobe.euler.jason.solutions.BouncyNumbers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BouncyNumbersTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Verify the correct answer to the problem.
	 */
	@Test
	public void testAnswer()
	{
		assertEquals(1587000, find99PercentBouncyNumber());
	}
	
	/**
	 * No numbers less than or equal to 100 can be bouncy.
	 */
	@Test
	public void isBouncy_lessThan100()
	{
		for(int i = 0; i <= 100; i++)
		{
			assertFalse(isBouncy(i));
		}
	}
	
	/**
	 * Check increasing numbers that should not be bouncy.
	 */
	@Test
	public void isBouncy_increasing()
	{
		assertFalse(isBouncy(123456789));
		assertFalse(isBouncy(13579));
		assertFalse(isBouncy(2468));
		assertFalse(isBouncy(111111111));
		assertFalse(isBouncy(1122334455));
		assertFalse(isBouncy(888888889));
	}
	
	/**
	 * Check decreasing numbers that should not be bouncy.
	 */
	@Test
	public void isBouncy_decreasing()
	{
		assertFalse(isBouncy(987654321));
		assertFalse(isBouncy(97531));
		assertFalse(isBouncy(86420));
		assertFalse(isBouncy(111111111));
		assertFalse(isBouncy(554433221));
		assertFalse(isBouncy(988888888));
	}
	
	/**
	 * Check some numbers that should be bouncy.
	 */
	@Test
	public void isBouncy_bouncies()
	{
		assertTrue(isBouncy(918273645));
		assertTrue(isBouncy(999979999));
		assertTrue(isBouncy(34567890));
		assertTrue(isBouncy(58276));
		assertTrue(isBouncy(55667744));
		assertTrue(isBouncy(309));
	}
	
	@Test
	public void isBouncy_negativeNumber()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number must not be negative!");
		
		assertTrue(isBouncy(-918273645));
	}
}
