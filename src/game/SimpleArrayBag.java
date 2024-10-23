// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aastha Paranthaman (aasthap)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * This is the SimpleArrayBag<T> class, which implements the interface
 * SimpleBagInterface<T>. This class represents a fixed size of a generic
 * collection of items. Its main purpose is to add, remove and pick items from
 * the bag along with getting the current size and checking if the bag is empty.
 * This class also has a private method to get the position of an entry.
 * 
 * @author Aastha Paranthaman (aasthap)
 * @version 2024.10.01
 * @param <T> 
 *       The type of objects that the ArrayBag will hold.
 */
public class SimpleArrayBag<T>
    implements SimpleBagInterface<T>
{
    // ~ Fields ................................................................

    private T[] bag;
    /**
     * This is the constant field MAX, which is set to 18 and is available to
     * any other classes.
     */
    private final static int MAX = 18;
    private int numberOfEntries;

    // ~ Constructors ..........................................................

    /**
     * This is the SimpleArrayBag constructor that initializes an array of T
     * object to size MAX and sets numberOfEntries to 0.
     */
    public SimpleArrayBag()
    {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        this.numberOfEntries = 0;
    }

    // ~Public Methods ........................................................


    /**
     * This method adds an entry to the bag at the given index if there is
     * enough space and the value is not null.
     * 
     * @param anEntry
     *            Generic being added to the ArrayBag.
     * @return Returns true if the entry was added.
     */
    public boolean add(T anEntry)
    {
        if (anEntry != null && numberOfEntries < 18)
        {
            // Increasing the number of entries in the bag as a new one is added
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }


    /**
     * This method gets the current size of the bag.
     * 
     * @return Returns numberOfEntries stored in the bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }


    /**
     * This method checks if the bag is empty.
     * 
     * @return Returns true if the numberOfEntries in the bag is 0.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    /**
     * This method picks a random value from the bag if the bag contains any
     * items.
     * 
     * @return Returns the index of the entry in the bag.
     */
    public T pick()
    {
        if (!isEmpty())
        {
            // Using the TestableRandom class to randomly pick entries from
            // inside the bag
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
        return null;
    }


    /**
     * This method removes an entry from the bag and places the last entry in
     * the bag at the position at which the entry was removed.
     * 
     * @param anEntry
     *            Generic being added to the bag.
     * @return Returns true if the entry was removed.
     */
    public boolean remove(T anEntry)
    {
        int index = this.getIndexOf(anEntry);
        if (index != -1)
        {
            // Decreasing the number of entries in the bag as one of them is
            // removed
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }


    /**
     * This private method gets the position of an entry in the bag.
     * 
     * @param anEntry
     *            Generic being added to the bag.
     * @return Returns the position of the entry.
     */
    private int getIndexOf(T anEntry)
    {
        // Looping through the entries in the bag to find to position of a
        // specific entry
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (bag[i].equals(anEntry))
            {
                return i;
            }
        }
        return -1;
    }
}
