package com.qa.tlv.methods;

import org.junit.Assert;

import com.qa.tlv.environment.BaseTest;

public class AssertionMethods implements BaseTest{
	
	public void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	public void assertTrue(String errorMessage, boolean condition) {
		Assert.assertTrue(errorMessage, condition);
	}

	public void assertFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	public void assertNull(Object object) {
		Assert.assertNull(object);
	}

	public void assertNotNull(Object object) {
		Assert.assertNotNull(object);
	}

	public void assertEquals(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	public void assertEquals(float expected, float actual) {
		Assert.assertEquals(expected, actual, 0);
	}

	public void assertEquals(double expected, double actual) {
		Assert.assertEquals(expected, actual, 0);
	}

	public void assertEquals(long expected, long actual) {
		Assert.assertEquals(expected, actual);
	}
}
