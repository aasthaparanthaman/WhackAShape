// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aastha Paranthaman (aasthap)
package game;

import student.TestCase;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * This is the SimpleArrayBagTest class, which extends the TestCase class. 
 * It includes test cases for all methods in the SimpleArrayBag<T> class.
 * 
 * @author Aastha Paranthaman (aasthap)
 * @version 2024.10.01
 */
public class SimpleArrayBagTest
    extends TestCase
{
    // ~ Fields ................................................................

    private SimpleArrayBag<String> bag;

    // ~Public Methods ........................................................

    /**
     * Sets up each of the test methods.
     */
    public void setUp()
    {
        bag = new SimpleArrayBag<String>();
    }


    /**
     * Tests the add method to check that an entry can be added.
     */
    public void testAdd()
    {
        bag.add("One");
        assertEquals(1, bag.getCurrentSize());
    }


    /**
     * Tests the add method to check that a null entry cannot be added.
     */
    public void testAddNull()
    {
        assertEquals(false, bag.add(null));
    }


    /**
     * Tests the add method to check that no more than 18 items can be added.
     */
    public void testAddLimit()
    {
        bag.add("Two");
        bag.add("Three");
        bag.add("Four");
        bag.add("Five");
        bag.add("Six");
        bag.add("Seven");
        bag.add("Eight");
        bag.add("Nine");
        bag.add("Ten");
        bag.add("Eleven");
        bag.add("Twelve");
        bag.add("Thirteen");
        bag.add("Fourteen");
        bag.add("Fifteen");
        bag.add("Sixteen");
        bag.add("Seventeen");
        bag.add("Eighteen");
        bag.add("Nineteen");
        bag.add("Twenty");
        assertEquals(18, bag.getCurrentSize());
    }


    /**
     * Tests the getCurrentSize method to check the size of the bag.
     */
    public void testGetCurrentSize()
    {
        bag.add("One");
        assertEquals(1, bag.getCurrentSize());
    }


    /**
     * Tests the isEmpty method to check that the bag has no entries.
     */
    public void testIsEmpty()
    {
        assertEquals(true, bag.isEmpty());
    }


    /**
     * Tests the isEmpty method to check that the bag has an entry.
     */
    public void testIsEmptyNot()
    {
        bag.add("One");
        assertEquals(false, bag.isEmpty());
    }


    /**
     * Tests the pick method to check if a null value is returned from an empty
     * bag.
     */
    public void testPickNull()
    {
        assertEquals(null, bag.pick());
    }


    /**
     * Tests the pick method to check if the entry in a "random" position in the
     * bag is returned.
     */
    public void testPick()
    {
        bag.add("One");
        bag.add("Two");
        bag.add("Three");
        bag.add("Four");
        bag.add("Five");
        bag.add("Six");
        bag.add("Seven");
        bag.add("Eight");
        bag.add("Nine");
        bag.add("Ten");
        TestableRandom.setNextInts(0, 2, 7);
        assertEquals("One", bag.pick());
        assertEquals("Three", bag.pick());
        assertEquals("Eight", bag.pick());
    }


    /**
     * Tests the remove method to check if an entry that is present is removed.
     */
    public void testRemove()
    {
        bag.add("One");
        assertEquals(true, bag.remove("One"));
    }


    /**
     * Tests the remove method to check if an entry that is not present cannot
     * be removed.
     */
    public void testRemoveNothing()
    {
        assertEquals(false, bag.remove("Two"));
    }


    /**
     * Tests the getIndexOf method to check if the position of an entry in a bag
     * is returned.
     */
    public void testGetIndexOf()
    {
        bag.add("One");
        assertEquals(false, bag.remove("Two"));
    }
}
