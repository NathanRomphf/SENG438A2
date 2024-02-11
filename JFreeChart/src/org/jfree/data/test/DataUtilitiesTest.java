package org.jfree.data.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Action;
import org.junit.Test;
import org.jfree.data.KeyedValues;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.DefaultKeyedValues;



public class DataUtilitiesTest extends DataUtilities {

	private Mockery mockingContex;
	private Mockery nullMockingContex;
	private Mockery singleValueKeyedValue;
	private Mockery intIntValueKeyedValue;
	private Mockery doubleIntValueKeyedValue;
	private Mockery intDoubleValueKeyedValue;
	private Mockery charIntValueKeyedValue;
	private Values2D values;
	private Values2D nullValues;
	private KeyedValues singleValue;
	private KeyedValues intIntValue;
	private KeyedValues doubleIntValue;
	private KeyedValues intDoubleValue;
	private KeyedValues charIntValue;
	
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
		     
		 this.singleValueKeyedValue = new Mockery();
		 singleValue = this.singleValueKeyedValue.mock(KeyedValues.class);
		 this.singleValueKeyedValue.checking(new Expectations() {
			 {
				 List<Integer> i = new ArrayList<Integer>();
				 i.add(0);
				 allowing(singleValue).getItemCount();
				 will(returnValue(1));
				 allowing(singleValue).getValue(0);
				 will(returnValue(50));
				 allowing(singleValue).getKey(0);
				 will(returnValue(0));
				 allowing(singleValue).getKeys();
				 will(returnValue(i));
			 }
		 });
		 
		 this.intIntValueKeyedValue = new Mockery();
		 intIntValue = this.intIntValueKeyedValue.mock(KeyedValues.class);
		 this.intIntValueKeyedValue.checking(new Expectations() {
			 {
				 List<Integer> i = new ArrayList<Integer>();
				 i.add(0);
				 i.add(1);
				 i.add(2);
				 allowing(intIntValue).getItemCount();
				 will(returnValue(3));
				 allowing(intIntValue).getValue(0);
				 will(returnValue(5));
				 allowing(intIntValue).getValue(1);
				 will(returnValue(9));
				 allowing(intIntValue).getValue(2);
				 will(returnValue(2));
				 allowing(intIntValue).getKey(0);
				 will(returnValue(0));
				 allowing(intIntValue).getKey(1);
				 will(returnValue(1));
				 allowing(intIntValue).getKey(2);
				 will(returnValue(2));
				 allowing(intIntValue).getKeys();
				 will(returnValue(i));
			 }
		 });
		 
		 this.doubleIntValueKeyedValue = new Mockery();
		 doubleIntValue = this.doubleIntValueKeyedValue.mock(KeyedValues.class);
		 this.doubleIntValueKeyedValue.checking(new Expectations() {
			 {
				 List<Double> i = new ArrayList<Double>();
				 i.add(0.1);
				 i.add(1.1);
				 i.add(2.1);
				 allowing(doubleIntValue).getItemCount();
				 will(returnValue(3));
				 allowing(doubleIntValue).getValue(0.1);
				 will(returnValue(5));
				 allowing(doubleIntValue).getValue(1.1);
				 will(returnValue(9));
				 allowing(doubleIntValue).getValue(2.1);
				 will(returnValue(2));
				 allowing(doubleIntValue).getKey(0);
				 will(returnValue(0.1));
				 allowing(doubleIntValue).getKey(1);
				 will(returnValue(1.1));
				 allowing(doubleIntValue).getKey(2);
				 will(returnValue(2.1));
				 allowing(doubleIntValue).getKeys();
				 will(returnValue(i));
				 allowing(doubleIntValue).getValue(1);
				 will(throwException(new UnknownKeyException("There is no key = 1")));
			 }
		 });
		 
		 this.intDoubleValueKeyedValue = new Mockery();
		 intDoubleValue = this.intDoubleValueKeyedValue.mock(KeyedValues.class);
		 this.intDoubleValueKeyedValue.checking(new Expectations() {
			 {
				 List<Integer> i = new ArrayList<Integer>();
				 i.add(0);
				 i.add(1);
				 i.add(2);
				 allowing(intDoubleValue).getItemCount();
				 will(returnValue(3));
				 allowing(intDoubleValue).getValue(0);
				 will(returnValue(5.5));
				 allowing(intDoubleValue).getValue(1);
				 will(returnValue(9.5));
				 allowing(intDoubleValue).getValue(2);
				 will(returnValue(2.5));
				 allowing(intDoubleValue).getKey(0);
				 will(returnValue(0));
				 allowing(intDoubleValue).getKey(1);
				 will(returnValue(1));
				 allowing(intDoubleValue).getKey(2);
				 will(returnValue(2));
				 allowing(intDoubleValue).getKeys();
				 will(returnValue(i));
			 }
		 });
		 
		 this.charIntValueKeyedValue = new Mockery();
		 charIntValue = this.charIntValueKeyedValue.mock(KeyedValues.class);
		 this.charIntValueKeyedValue.checking(new Expectations() {
			 {
				 List<Character> i = new ArrayList<Character>();
				 i.add('a');
				 i.add('b');
				 i.add('c');
				 allowing(charIntValue).getItemCount();
				 will(returnValue(3));
				 allowing(charIntValue).getValue("a");
				 will(returnValue(5));
				 allowing(charIntValue).getValue("b");
				 will(returnValue(9));
				 allowing(charIntValue).getValue("c");
				 will(returnValue(2));
				 allowing(charIntValue).getKey(0);
				 will(returnValue('a'));
				 allowing(charIntValue).getKey(1);
				 will(returnValue('b'));
				 allowing(charIntValue).getKey(2);
				 will(returnValue('c'));
				 allowing(charIntValue).getKeys();
				 will(returnValue(i));
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
	 /*
	  * This test is designed to test the method
	  * createNumber array when an empty array is passed in
	  */
	 @Test
	 public void createNumberArrayWithEmptyArray() {
		 double data[]= {};
		 Number expected[] = {};
		 Number actual[] = DataUtilities.createNumberArray(data);
		 assertArrayEquals("Converting from an empy double array to empty number array",expected, actual);
	 }
	 /*
	  * This test is designed to test the method
	  * createNumber array when a large array of
	  * doubles is passed in
	  */
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
	 /*
	  * This test is designed to test the method
	  * createNumber array when the invalid parameter of
	  * a null array is passed in
	  */
	 @Test (expected = InvalidParameterException.class)
	 public void createNumberArrayForInvalidInput() {
		 try {
			 double data[] = null;
			 DataUtilities.createNumberArray(data);
		 }catch(Exception e) {
			 
		 }
	 }
	//--------------------Tests for createNumberArray2D------------------------------------
	 
	 /*
	  * This test is designed to test the method
	  * createNumberArray2D with a valid matrix of doubles
	  */
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
	 /*
	  * This test is designed to test the method
	  * createNumberArray2D with an empty 2D array
	  */
	 @Test
	 public void createNumberArray2DWithEmptyArray() {
		double[][] data = {{},{}};
		Number[][] expected = {{},{}};
		Number actual[][] = DataUtilities.createNumberArray2D(data);
		assertArrayEquals("Converting from an empy 2D double array to empty 2D number array",expected, actual);
	 }
	 /*
	  * This test is designed to test the method
	  * createNumberArray2D with a large 2D array
	  * passed in
	  */
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
	 /*
	  * This test is designed to test the method
	  * createNumberArray2D when a null value is passed in.
	  * should throw an exception
	  */
	@Test(expected = InvalidParameterException.class)
	public void createNumberArray2DForInvalidInput() {
			double data[][] = null;
			DataUtilities.createNumberArray2D(data);
	}
	
	//--------------------Tests for getCumulativePercentages------------------------------------
	//null input(exception), empty keyValues, single value, multiple values
	
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the keyedValue passed in only contains one key, value pair
	 */
	@Test
	public void getCumulativePercentagesForSingleValue() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(singleValue);
		assertEquals("The value for the percentage should be 1", 1, (double) actual.getValue(0),0.1);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * and how many key, value pairs are returned
	 */
	@Test
	public void getCumulativePercentagesItemCount() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(intIntValue);
		
		assertEquals("There should be one key, value pair for each one in the keyedValue object passed in"
				,3, actual.getItemCount());
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when both the key and value in the key, value pairs are integers
	 * and the percentage that the first index contributes to the total.
	 */
	@Test
	public void getCumulativePercentagesForIntIntFirstIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(intIntValue);
		assertEquals("The cumulative percentage of the first value is wrong"
				,0.3125, (double) actual.getValue(0),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when both the key and value in the key, value pairs are integers
	 * and the percentage that the first + second index contributes to the total
	 */
	@Test
	public void getCumulativePercentagesForIntIntSecondIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(intIntValue);
		assertEquals("The cumulative percentage of the first + second value is wrong"
				,0.875, (double) actual.getValue(1),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when both the key and value in the key, value pairs are integers
	 * and the cumulative value of the last index, which should always be 1
	 */
	@Test
	public void getCumulativePercentagesForIntIntLastIndex() { //FAILS - completely wrong values returned
		KeyedValues actual = DataUtilities.getCumulativePercentages(intIntValue);
		assertEquals("The cumulative percentage of all the key, value pairs should be 1"
				,1.0, (double) actual.getValue(2),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a double and the value is an integer and the cumulative
	 * percentage that the first value contributes to the overall
	 */
	@Test
	public void getCumulativePercentagesForDoubleIntFirstIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(doubleIntValue);
		assertEquals("The cumulative percentage of the first value is wrong"
				,0.3125, (double) actual.getValue(0.1),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a double and the value is an integer and the cumulative
	 * percentage that the first value + second value contributes to the overall
	 */
	@Test
	public void getCumulativePercentagesForDoubleIntSecondIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(doubleIntValue);
		assertEquals("The cumulative percentage of the first + second value is wrong"
				,0.875, (double) actual.getValue(1.1),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a double and the value is an integer and the 
	 * cumulative value of the last index, which should always be 1
	 */
	@Test
	public void getCumulativePercentagesForDoubleIntLastIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(doubleIntValue);
		assertEquals("The cumulative percentage of all 3 values is wrong. Should always sum to 1"
				,1.0, (double) actual.getValue(2.1),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a integer and the value is a double and the cumulative
	 * percentage that the first value contributes to the overall
	 */
	@Test
	public void getCumulativePercentagesForIntDoubleFirstIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(intDoubleValue);
		assertEquals("The cumulative percentage of the first value is wrong"
				,0.31429, (double) actual.getValue(0),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a integer and the value is a double and the cumulative
	 * percentage that the first + second value contributes to the overall
	 */
	@Test
	public void getCumulativePercentagesForIntDoubleSecondIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(intDoubleValue);
		assertEquals("The cumulative percentage of the first + second value is wrong",
				0.85714, (double) actual.getValue(1),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is an integer and the value is a double and the 
	 * cumulative value of the last index, which should always be 1
	 */
	@Test
	public void getCumulativePercentagesForIntDoubleLastIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(intDoubleValue);
		assertEquals("The cumulative percentage of all 3 values is wrong. Should always sum to 1",
				1.0, (double) actual.getValue(2),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 */
	public void getCumulativePercentagesForCharInt() { //FAILS - completely wrong values returned
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("a", 5);
		data.addValue("b", 9);
		data.addValue("c", 2);//17.5
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(3, actual.getItemCount());
		assertEquals(0.3125, (double) actual.getValue(0),0.0001);
		assertEquals(0.875, (double) actual.getValue(0),0.0001);
		assertEquals(1.0, (double) actual.getValue(0),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a char and the value is an integer and the cumulative
	 * percentage that the first value contributes to the overall
	 */
	@Test
	public void getCumulativePercentagesForCharIntFirstIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(charIntValue);
		assertEquals("The cumulative percentage of the first value is wrong",
				0.3125, (double) actual.getValue('a'),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a char and the value is an integer and the cumulative
	 * percentage that the first + second value contributes to the overall
	 */
	@Test
	public void getCumulativePercentagesForCharIntSecondIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(charIntValue);
		assertEquals("The cumulative percentage of the first + second value is wrong"
				,0.875, (double) actual.getValue('b'),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 * when the key is a char and the value is an integer and the 
	 * cumulative value of the last index, which should always be 1
	 */
	@Test
	public void getCumulativePercentagesForCharIntLastIndex() { //FAILS - completely wrong values returned
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(charIntValue);
		assertEquals("The cumulative percentage of all 3 values is wrong. Should always sum to 1",
				1.0, (double) actual.getValue('c'),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 */
	@Test
	public void getCumulativePercentagesForNegativeKey() { //FAILS - completely wrong values returned
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue(Integer.valueOf(-2), 5);
		data.addValue(Integer.valueOf(-1), 9);
		data.addValue(Integer.valueOf(2), 2);
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(3, actual.getItemCount());
		assertEquals(0.3125, (double) actual.getValue(0),0.0001);
		assertEquals(0.875, (double) actual.getValue(0),0.0001);
		assertEquals(1.0, (double) actual.getValue(0),0.0001);
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 */
	@Test
	public void getCumulativePercentagesForLargeValues() { //FAILS - completely wrong values returned
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue(Integer.valueOf(0), 5);
		data.addValue(Integer.valueOf(100), 9);
		data.addValue(Integer.valueOf(2000), 2);
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(3, actual.getItemCount());
		assertEquals(0.3125, (double) actual.getValue(0),0.0001);
		assertEquals(0.875, (double) actual.getValue(0),0.0001);
		assertEquals(1.0, (double) actual.getValue(0),0.0001);
	}
	
	/*
	 * This test is designed to test the method getCumulativePercentages
	 */
	@Test
	public void getCumulativePercentagesWithEmptyInput() {
		KeyedValues data = new DefaultKeyedValues();
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		assertEquals(0, actual.getItemCount());
	}
	/*
	 * This test is designed to test the method getCumulativePercentages
	 */
    @Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesWithNullInput() { //FAILS - returns wrong exception
        KeyedValues data = null;
        DataUtilities.getCumulativePercentages(data);
	}
	
	
}