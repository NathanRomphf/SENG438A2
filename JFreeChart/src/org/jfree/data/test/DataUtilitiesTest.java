package org.jfree.data.test;

import org.junit.*;
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;



public class DataUtilitiesTest extends DataUtilities {

	private Mockery mockingContex;
	private Values2D values;
	
	public DataUtilitiesTest() {
		this.mockingContex = new Mockery();
		values = this.mockingContex.mock(Values2D.class);
	     this.mockingContex.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             one(values).getValue(0, 0);
	             will(returnValue(23));
	             one(values).getValue(1, 0);
	             will(returnValue(-7));
	             one(values).getValue(2, 0);
	             will(returnValue(9.1));
	             one(values).getValue(0, 1);
	             will(returnValue(-2));
	             one(values).getValue(1, 1);
	             will(returnValue(9.3));
	             one(values).getValue(2, 1);
	             will(returnValue(13));
	             one(values).getValue(0, 2);
	             will(returnValue(8.8));
	             one(values).getValue(1, 2);
	             will(returnValue(44));
	             one(values).getValue(2, 2);
	             will(returnValue(-109));
	         }
	     });
	}

	 @Test
	 public void calculateColumnTotalForThreeValues() {
	     // setup
	     
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 25.1, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void calculateColumnTotalForColumnOutOfRange() {
		 double result = DataUtilities.calculateColumnTotal(values, 2);
		 assertEquals(result, 25.1, .000000001d);
	 }

}