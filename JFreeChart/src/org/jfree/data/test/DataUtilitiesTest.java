package org.jfree.data.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import javax.naming.spi.DirStateFactory.Result;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Action;
import org.junit.Test;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;



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
	             one(values).getValue(0, -1);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(1, -1);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(2, -1);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(3, 0);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(3, 1);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(3, 2);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(-1, 0);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(-1, 1);
	             will(throwException(new IndexOutOfBoundsException()));
	             one(values).getValue(-1, 2);
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
	
	//--------------------Tests for calculateColumnTotal------------------------------------
	
	
	/*
     * This test is designed to test the method when all
     * the column inputs are numeric values
     */
	 @Test
	 public void calculateColumnTotalForColumnWithAllNumbers() {
	     
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals("Result of testing a valid column of a values2D object", 25.1, result, .000000001d);
	 }
	 
	 /*
	  * This test is designed to test the method when the
	  * column inputs are a mix of numeric and null values
	  */
	 @Test
	 public void calculateColumnTotalForColumnWithNumbersAndNull() {
	     
	     double result = DataUtilities.calculateColumnTotal(values, 2);
	     assertEquals("Result of testing a valid column of a values2D object containing null values", 52.8, result, .000000001d);
	 }
	
	 /*
	  * This test is designed to test the method when all
	  * the column inputs are null values
	  */
	 @Test
	 public void calculateColumnTotalForColumnWithAllNull() {
	     
	     double result = DataUtilities.calculateColumnTotal(nullValues, 0);
	     assertEquals("Result of testing a valid column of a values2D object containing all null values", 0, result, .000000001d);
	 }
	 /*
	  * This test is designed to test the method when
	  * the index of the column is outside of the bounds
	  * of the Values2D object
	  */
	 @Test (expected = IndexOutOfBoundsException.class)
	 public void calculateColumnTotalForColumnAboveRange() throws IndexOutOfBoundsException{
		 double result =DataUtilities.calculateColumnTotal(values, 3);
		 assertEquals("Result of testing an invalid column", 0, result, .000000001d);

	 }
	 
	 /*
	  * This test is designed to test the method when
	  * the index of the column is outside of the bounds
	  * of the Values2D object
	  */
	 @Test (expected = IndexOutOfBoundsException.class)
	 public void calculateColumnTotalForColumnBelowRange() throws IndexOutOfBoundsException{
		 double result =DataUtilities.calculateColumnTotal(values, -1);
		 assertEquals("Result of testing an invalid column", 0, result, .000000001d);

	 }
	 
	 /*
	  * This test is designed to test the method when
	  * the input parameters to the method are invalid
	  */
	 @Test (expected = InvalidParameterException.class)
	 public void calculateColumnTotalForInvalidInput() throws InvalidParameterException{
		 try {
			 DataUtilities.calculateColumnTotal(null, 0);
		 }catch(Exception e) {
			// fail("threw exception other than expected: " + e.toString());
		 }
	 }
	 
	//--------------------Tests for calculateRowTotal------------------------------------
	 
	 /*
	  * This test is designed to test the method when all
	  * the row inputs are numeric values
	  */
	 @Test
	 public void calculateRowTotalForRowWithAllNumbers() {
	     
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     assertEquals("Result of testing a valid row of a values2D object", 46.3, result, .000000001d);
	 }
	 
	 /*
	  * This test is designed to test the method when the
	  * row inputs are a mix of numeric and null values
	  */
	 @Test
	 public void calculateRowTotalForRowWithNumbersAndNull() {
	     
	     double result = DataUtilities.calculateRowTotal(values, 2);
	     assertEquals("Result of testing a valid row of a values2D object containing null values", 22.1, result, .000000001d);
	 }
	 /*
	  * This test is designed to test the method when all
	  * the row inputs are null values
	  */
	 @Test
	 public void calculateRowTotalForRowWithAllNull() {
	     
	     double result = DataUtilities.calculateRowTotal(nullValues, 0);
	     assertEquals("Result of testing a valid row of a values2D object containing all null values", 0, result, .000000001d);
	 }
	 /*
	  * This test is designed to test the method when
	  * the index of the row is outside of the bounds
	  * of the Values2D object
	  */
	 @Test (expected = IndexOutOfBoundsException.class)
	 public void calculateRowTotalForRowAboveRange() throws IndexOutOfBoundsException{
			 DataUtilities.calculateRowTotal(values, 3);

	 }
	 
	 /*
	  * This test is designed to test the method when
	  * the index of the row is outside of the bounds
	  * of the Values2D object
	  */
	 @Test (expected = IndexOutOfBoundsException.class)
	 public void calculateRowTotalForRowBelowRange() throws IndexOutOfBoundsException{
			 DataUtilities.calculateRowTotal(values, -1);

	 }
	 
	 /*
	  * This test is designed to test the method when
	  * the input parameters to the method are invalid
	  */
	 @Test (expected = InvalidParameterException.class)
	 public void calculateRowTotalForInvalidInput() throws InvalidParameterException{
		 try {
			 DataUtilities.calculateRowTotal(null, 0);
		 }catch(Exception e) {
			//fail("threw exception other than expected: " + e.toString());
		 }
	 }
	 
	 //--------------------Tests for createNumberArray------------------------------------
	 /*
	  * This test is designed to test the method
	  * when a proper array of doubles is passed in
	  * as an input parameter
	  */
	 @Test
	 public void createNumberArrayWithDoublesOnly() {
		 double data[] = {1.0, 2.0, 3.0};
		 Number expected[] = {1.0, 2.0, 3.0};
		 Number actual[] = DataUtilities.createNumberArray(data);
		 assertArrayEquals("Array with doubles only does not successfully conver to Number objects", expected, actual);
	 }
	 
	 @Test
	 public void createNumberArrayWithEmptyArray() {
		 double data[]= {};
		 Number expected[] = {};
		 Number actual[] = DataUtilities.createNumberArray(data);
		 assertArrayEquals("Converting from an empy double array to empty number array",expected, actual);
	 }
	 
	 @Test
	 public void createNumberArrayWithLargeArray() { //FAILS actual[99] = null
		 double data[] = new double[100];
		 Number expected[] = new Number[100];
		 
		 for(int i=0; i<100; i++) {
			 data[i] = i;
			 expected[i] = Double.valueOf(i);
		 }
		 
		 Number actual[] = DataUtilities.createNumberArray(data);
		 assertArrayEquals("Creating a Number array from a large array",expected, actual);
	 }
	 
	 @Test (expected = InvalidParameterException.class)
	 public void createNumberArrayForInvalidInput() {
		 try {
			 double data[] = null;
			 DataUtilities.createNumberArray(data);
		 }catch(Exception e) {
			 
		 }
	 }
	//--------------------Tests for createNumberArray2D------------------------------------
	 @Test
	 public void createNumberArray2DWithDoublesOnly() { //FAILES - misses the last element in a row
		 double[][] data = {
				    {1.0, 2.0, 3.0},
				    {5.0, 6.0, 7.0},
				    {9.0, 10.0, 11.0}
				};
		 Number expected[][] = {
				    {1.0, 2.0, 3.0},
				    {5.0, 6.0, 7.0},
				    {9.0, 10.0, 11.0}
				};
		 Number actual[][] = DataUtilities.createNumberArray2D(data);
		 assertArrayEquals("2D Array with valid input", expected, actual);
	 }
	 
	 @Test
	 public void createNumberArray2DWithEmptyArray() {
		double[][] data = {{},{}};
		Number[][] expected = {{},{}};
		Number actual[][] = DataUtilities.createNumberArray2D(data);
		assertArrayEquals("Converting from an empy 2D double array to empty 2D number array",expected, actual);
	 }
	 
	 @Test
	 public void createNumberArray2DWithLargeArray() { //FAILS actual[0][9] = null
		 double data[][] = new double[10][10];
		 Number expected[][] = new Number[10][10];
		 
		 for(int i=0; i<10; i++) {
			 for(int j=0; j<10; j++) {
				 data[i][j] = i+j;
				 expected[i][j] = (double)i+j;
				 
			 }
		 }
		 System.out.println(expected[0][1]);
		 Number actual[][] = DataUtilities.createNumberArray2D(data);
		 assertArrayEquals("Creating a Number array from a large array",expected, actual);
	 }
	 
	@Test(expected = InvalidParameterException.class)
	public void createNumberArray2DForInvalidInput() { //fails - wrong exception thrown
			double data[][] = null;
			DataUtilities.createNumberArray2D(data);
	}
	
	//--------------------Tests for getCumulativePercentages------------------------------------
	//null input(exception), empty keyValues, single value, multiple values
	
	@Test
	public void getCumulativePercentagesForSingleValue() { //FAILS - returns infinity
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue(Integer.valueOf(0), 50);

		
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(1, actual.getItemCount());
		assertEquals(1, (double) actual.getValue(0),0.1);

	}
	
	@Test
	public void getCumulativePercentagesForMultipleValues() { //FAILS - completely wrong values returned
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue(Integer.valueOf(0), 5);
		data.addValue(Integer.valueOf(1), 9);
		data.addValue(Integer.valueOf(2), 2);
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(3, actual.getItemCount());
		assertEquals(0.3125, (double) actual.getValue(0),0.0001);
		assertEquals(0.875, (double) actual.getValue(0),0.0001);
		assertEquals(1.0, (double) actual.getValue(0),0.0001);
	}
	
	@Test
	public void getCumulativePercentagesWithEmptyInput() {
		KeyedValues data = new DefaultKeyedValues();
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		assertEquals(0, actual.getItemCount());
	}
	
    @Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesWithNullInput() { //FAILS - returns wrong exception
        KeyedValues data = null;
        DataUtilities.getCumulativePercentages(data);
	}
	
	
}