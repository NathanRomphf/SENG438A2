package org.jfree.data.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Action;
import org.junit.Test;



public class DataUtilitiesTest extends DataUtilities {

	private Mockery mockingContex;
	private Mockery nullMockingContex;
	private Values2D values;
	private Values2D nullValues;
	
	public DataUtilitiesTest() {
		this.mockingContex = new Mockery();
		values = this.mockingContex.mock(Values2D.class);
	     this.mockingContex.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             one(values).getColumnCount();
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
	             will(returnValue(null));
	             one(values).getValue(0, 3);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(1, 3);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(2, 3);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(3, 0);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(0, 1);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(0, 2);
	             will(throwException(new IndexOutOfBoundsException()));
	         }
	     });
	     
	     this.nullMockingContex = new Mockery();
			nullValues = this.nullMockingContex.mock(Values2D.class);
		     this.nullMockingContex.checking(new Expectations() {
		         {
		        	one(nullValues).getRowCount();
		        	will(returnValue(1));
		        	one(nullValues).getColumnCount();
		        	will(returnValue(1));
		        	one(nullValues).getValue(0,0);
		        	will(returnValue(null));
		         }
		     });
	}

	 @Test
	 public void calculateColumnTotalForColumnWithAllNumbers() {
	     
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals("Result of testing a valid column of a values2D object", 25.1, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateColumnTotalForColumnWithNumbersAndNull() {
	     
	     double result = DataUtilities.calculateColumnTotal(values, 2);
	     assertEquals("Result of testing a valid column of a values2D object containing null values", 52.8, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateColumnTotalForColumnWithAllNull() {
	     
	     double result = DataUtilities.calculateColumnTotal(nullValues, 0);
	     assertEquals("Result of testing a valid column of a values2D object containing all null values", 0, result, .000000001d);
	 }
	 
	 @Test (expected = IndexOutOfBoundsException.class)
	 public void calculateColumnTotalForColumnOutOfRange() throws IndexOutOfBoundsException{
			 DataUtilities.calculateColumnTotal(values, 3);

	 }
	 
	 @Test (expected = InvalidParameterException.class)
	 public void calculateColumnTotalForInvalidInput() throws InvalidParameterException{
		 try {
			 DataUtilities.calculateColumnTotal(null, 0);
		 }catch(Exception e) {
			// fail("threw exception other than expected: " + e.toString());
		 }
	 }
	 
	 @Test
	 public void calculateRowTotalForRowWithAllNumbers() {
	     
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     assertEquals("Result of testing a valid row of a values2D object", 46.3, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotalForRowWithNumbersAndNull() {
	     
	     double result = DataUtilities.calculateColumnTotal(values, 2);
	     assertEquals("Result of testing a valid row of a values2D object containing null values", 22.1, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotalForRowWithAllNull() {
	     
	     double result = DataUtilities.calculateColumnTotal(nullValues, 0);
	     assertEquals("Result of testing a valid row of a values2D object containing all null values", 0, result, .000000001d);
	 }
	 
	 @Test (expected = IndexOutOfBoundsException.class)
	 public void calculateRowTotalForRowOutOfRange() throws IndexOutOfBoundsException{
			 DataUtilities.calculateColumnTotal(values, 3);

	 }
	 
	 @Test (expected = InvalidParameterException.class)
	 public void calculateRowTotalForInvalidInput() throws InvalidParameterException{
		 try {
			 DataUtilities.calculateRowTotal(null, 0);
		 }catch(Exception e) {
			//fail("threw exception other than expected: " + e.toString());
		 }
	 }
	 
	 @Test
	 public void createNumberArrayWithValidInputs() {
		 double data[] = {1.0, 2.0, 3.0};
		 Number expected[] = {1.0, 2.0, 3.0};
		 Number actual[] = DataUtilities.createNumberArray(data);
		 assertArrayEquals(expected, actual);
	 }
}