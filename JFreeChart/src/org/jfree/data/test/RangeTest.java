package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.Test;

public class RangeTest{

	private Range exampleRange;
	
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	
    }
    
    //TESTS FOR GETLENGTH()
    
    /*
     * This test tests the length of a range between positive 
     * upper and lower bounds for getLength() method
     */
    @Test
    public void testGetLengthPositiveBounds() {
    	Range testRange = new Range(2, 4);
        assertEquals("The length of 2 and 4 should be 2",
        2, testRange.getLength(), .000000001d);
    }
    
    /*
     * This test tests the length of a range between 
     * positive upper bound and negative lower bound 
     * for getLength() method
     */
    @Test
    public void testGetLengthPositiveAndNegativeBounds() {
    	Range testRange = new Range(-1, 1);
        assertEquals("The length of -1 and 1 should be 2",
        2, testRange.getLength(), .000000001d);
    }
    
    /*
     * This test tests the length of a range between 
     * negative upper and lower bounds
     * for getLength() method
     */
    @Test
    public void testGetLengthNegativeBounds() {
    	Range testRange = new Range(-10, -5);
        assertEquals("The length of -10 and -5 should be 5",
        5, testRange.getLength(), .000000001d);
    }
    
    /*
     * This test tests the length of a range between 
     * an equal bounded range (i.e. both the upper 
     * and lower bounds are the same) for getLength() method
     */
    @Test
    public void testGetLengthEqualBounds() {
    	Range testRange = new Range(0, 0);
        assertEquals("The length of 0 and 0 should be 0",
        0, testRange.getLength(), .000000001d);
    }
    
    /*
     * This test tests the length of a range between 
     * a 0 lower bound and a positive upper bound
     * for getLength() method
     */
    @Test
    public void testGetLengthZeroLowerBoundPositiveUpperBound() {
    	Range testRange = new Range(0, 10);
        assertEquals("The length of 0 and 10 should be 10",
        10, testRange.getLength(), .000000001d);
    }
    
    /*
     * This test tests the length of a range between 
     * negative lower bound and a 0 upper bound
     * for getLength() method
     */
    @Test
    public void testGetLengthNegativeLowerBoundZeroUpperBound() {
    	Range testRange = new Range(-1, 0);
        assertEquals("The length of -1 and 0 should be 1",
        1, testRange.getLength(), .000000001d);
    }
    
    
    //TESTS FOR GET CENTRAL VALUE
    
    
    /*
     * This test tests the central value of a range between 
     * positive upper and lower bounds 
     * for getCentralValue() method
     */
    @Test
    public void testGetCentralValuePositiveBounds() {
    	Range testRange = new Range(2, 4);
        assertEquals("The central value of 2 and 4 should be 3",
        3, testRange.getCentralValue(), .000000001d);
    }
    
    /*
     * This test tests the central value of a range between 
     * negative upper and lower bounds
     * for getCentralValue() method
     */
    @Test
    public void testGetCentralValueNegativeBounds() {
    	Range testRange = new Range(-10, -5);
        assertEquals("The central value of -10 and -5 should be -7.5",
        -7.5, testRange.getCentralValue(), .000000001d);
    }
    
    /*
     * This test tests the central value of a range between 
     * positive upper bound and negative lower bound
     * for getCentralValue() method
     */
    @Test
    public void testGetCentralValuePositiveAndNegativeBounds() {
    	Range testRange = new Range(-1, 1);
        assertEquals("The central value of -1 and 1 should be 0",
        0, testRange.getCentralValue(), .000000001d);
    }
    
    /*
     * This test tests the central value of a range between 
     * an equal bounded range (i.e. both the upper and 
     * lower bounds are the same) for getCentralValue() method
     */
    @Test
    public void testGetCentralValueEqualBounds() {
    	Range testRange = new Range(0, 0);
        assertEquals("The central value of 0 and 0 should be 0",
        0, testRange.getCentralValue(), .000000001d);
    }
    
    /*
     * This test tests the central value of a range between 
     * 0 lower bound and a positive upper bound
     * for getCentralValue() method
     */
    @Test
    public void testGetCentralValueZeroLowerBoundPositiveUpperBound() {
    	Range testRange = new Range(0, 3);
        assertEquals("The central value of 0 and 3 should be 1.5",
        1.5, testRange.getCentralValue(), .000000001d);
    }
    
    /*
     * This test tests the central value of a range between 
     * negative lower bound and a 0 upper bound
     * for getCentralValue() method
     */
    @Test
    public void testGetCentralValueNegativeLowerBoundZeroUpperBound() {
    	Range testRange = new Range(-1, 0);
        assertEquals("The central value of -1 and 0 should be -0.5",
        -0.5, testRange.getCentralValue(), .000000001d);
    }
    
    
    //CONSTRAIN() TESTS - using exampleRange
    
    /*
     * This test tests the output of the 
     * constrain(double) method for an input
     * value in the range
     */
    @Test
    public void testConstrainValueInRange() {
        assertEquals("The constrained value should be 0.5",
        0.5, exampleRange.constrain(0.5), .000000001d);
    }
    
    
    /*
     * This test tests the output of the 
     * constrain(double) method for an input
     * value equal to the lower bound
     */
    @Test
    public void testConstrainValueAtLowerBound() {
        assertEquals("The constrained value should be -1",
        -1, exampleRange.constrain(-1), .000000001d);
    }
    
    
    /*
     * This test tests the output of the 
     * constrain(double) method for an input
     * value equal to the upper bound
     */
    @Test
    public void testConstrainValueAtUpperBound() {
        assertEquals("The constrained value should be 1",
        1, exampleRange.constrain(1), .000000001d);
    }
    
    
    /*
     * This test tests the output of the 
     * constrain(double) method for an input
     * value less than the lower bound
     */
    @Test //FAILS
    public void testConstrainValueLessThanLowerBound() {
        assertEquals("The constrained value should be -1",
        -1, exampleRange.constrain(-100), .000000001d);
    }
    
    
    /*
     * This test tests the output of the 
     * constrain(double) method for an input
     * value greater than the upper bound
     */
    @Test
    public void testConstrainValueGreaterThanUpperBound() {
        assertEquals("The constrained value should be 1",
        1, exampleRange.constrain(100), .000000001d);
    }
    
    
    //Test CONTAINS() METHOD
    
    /*
     * This test tests the output of the 
     * contains(double) method for an input
     * value in the range
     */
    @Test
    public void testContainsValueInRange() {
        assertTrue("The range -1 to 1 contains 0 so the value should be true",
        exampleRange.contains(0));
    }
    
    /*
     * This test tests the output of the 
     * contains(double) method for an input
     * value less than the lower bound
     */
    @Test
    public void testContainsValueLessThanLowerBound() {
        assertFalse("The range -1 to 1 does not contain -100 so the value should be false",
        exampleRange.contains(-100));
    }
    
    /*
     * This test tests the output of the 
     * contains(double) method for an input
     * value equal to the lower bound
     */
    @Test
    public void testContainsValueAtLowerBound() {
        assertTrue("The range -1 to 1 contains -1 so the value should be true",
        exampleRange.contains(-1));
    }
    
    /*
     * This test tests the output of the 
     * contains(double) method for an input
     * value equal to the upper bound
     */
    @Test
    public void testContainsValueAtUpperBound() {
        assertTrue("The range -1 to 1 contains 1 so the value should be true",
        exampleRange.contains(1));
    }
    
    /*
     * This test tests the output of the 
     * contains(double) method for an input
     * value greater than the upper bound
     */
    @Test
    public void testContainsValueGreaterThanUpperBound() {
        assertFalse("The range -1 to 1 does not contain 100 so the value should be false",
        exampleRange.contains(100));
    }
    
    
    //INTERSECTS METHOD TESTS
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range less than the lower bound 
     */
    @Test //FAILS
    public void testIntersectsRangeLessThanLowerBound() {
        assertFalse("The range -10 to -8 does not intersect with the range -1 to 1 so the value should be false",
        exampleRange.intersects(-10, -8));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range that intersects over the lower bound
     */
    @Test
    public void testIntersectsRangeIntersectsOverLowerBound() {
        assertTrue("The range -3 to 0 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(-3, 0));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range fully within the range
     */
    @Test
    public void testIntersectsRangeIntersectsRange() {
        assertTrue("The range -0.5 to 0.5 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(-0.5, 0.5));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range that intersects over the upper bound
     */
    @Test //FAILS
    public void testIntersectsRangeIntersectsOverUpperBound() {
        assertTrue("The range 0 to 100 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(0, 100));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range equivalent to the original range
     */
    @Test
    public void testIntersectsRangeIntersectsOverEntireRange() {
        assertTrue("The range -1 to 1 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(-1, 1));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range greater than the upper bound 
     */
    @Test //FAILS
    public void testIntersectsRangeGreaterThanUpperBound() {
        assertFalse("The range 3 to 2000 does not intersect with the range -1 to 1 so the value should be false",
        exampleRange.intersects(3, 2000));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range that only intersects at the lower bound 
     */
    @Test
    public void testIntersectsRangeIntersectsAtLowerBound() {
        assertTrue("The range -10 to -1 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(-10, -1));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range that only intersects at the upper bound
     */
    @Test //FAILS
    public void testIntersectsRangeIntersectsAtUpperBound() {
        assertTrue("The range 1 to 20 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(1, 20));
    }
    
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range that intersects with 0 length (i.e. equivalent 
     * upper and lower bounds)
     */
    @Test
    public void testIntersectsRangeIntersectsWithZeroLength() {
        assertTrue("The range 0 to 0 intersects with the range -1 to 1 so the value should be true",
        exampleRange.intersects(0, 0));
    }
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * range that does not intersect with 0 length 
     * (i.e. equivalent upper and lower bounds)
     */
    @Test
    public void testIntersectsRangeNotInRangeWithZeroLength() {
        assertFalse("The range 101 to 101 does not intersect with the range -1 to 1 so the value should be false",
        exampleRange.intersects(101, 101));
    }
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * that is invalidly entered range that is not 
     * in range (if the numbers were entered correctly)
     */
    @Test 
    public void testIntersectsInvalidInputNotInRange() {
        assertFalse("The range -10 to -12 is invalid and does not intersect with the range -1 to 1 so the value should be false", exampleRange.intersects(-10, -12));
    }
    
    /*
     * This test tests the output of the 
     * intersects(lower, upper) method for an input 
     * that is invalidly entered range that is 
     * in range (if the numbers were entered correctly) 
     */
    @Test 
    public void testIntersectsInvalidInputInRange() {
        assertFalse("The range 0.5 to -0.5 is invalid so the value should be false", exampleRange.intersects(0.5, -0.5));
    }
     

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}