// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aastha Paranthaman (aasthap)
package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * This is the SimpleLinkedBag<T> class, which implements the interface
 * SimpleBagInterface<T>. This class represents a collection of entries, each
 * stored in a node. Its main purpose is to add, remove and pick items from the
 * linked bag along with getting the current size and checking if the linked bag
 * is empty. This class also has a private method to get the reference of an
 * entry.
 * 
 * @author Aastha Paranthaman (aasthap)
 * @version 2024.10.01
 * @param <T> 
 *       The type of objects that the LinkedBag will hold.
 */
public class SimpleLinkedBag<T>
    implements SimpleBagInterface<T>
{

    // ~ Fields ................................................................
    private Node<T> firstNode;
    private int numberOfEntries;

    // ~ Constructors ..........................................................
    /**
     * This is the SimpleLinkedBag constructor that initializes the firstNode to
     * 0 and sets numberOfEntries to 0.
     */
    public SimpleLinkedBag()
    {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    // ~Public Methods ........................................................


    /**
     * This method adds an entry to the bag at the given node if the value is
     * not null.
     * 
     * @param anEntry
     *            Generic being added to the LinkedBag.
     * @return Returns true if the entry was added.
     */
    public boolean add(T anEntry)
    {
        if (anEntry != null)
        {
            // Increasing the number of entries in the linked bag as a new one
            // is added
            Node<T> node = new Node<T>(anEntry);
            node.setNext(firstNode);
            firstNode = node;
            numberOfEntries++;
            return true;
        }
        return false;
    }


    /**
     * This method gets the current size of the linked bag.
     * 
     * @return Returns numberOfEntries stored in the bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }


    /**
     * This method checks if the linked bag is empty.
     * 
     * @return Returns true if the numberOfEntries in the bag is 0.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    /**
     * This method picks a random value from the bag if the linked bag contains
     * any items.
     * 
     * @return Returns the node of the entry in the linked bag.
     */
    public T pick()
    {
        Node<T> currentNode = firstNode;
        if (!isEmpty())
        {
            // Using the TestableRandom class to randomly pick entries from
            // inside the bag
            TestableRandom generator = new TestableRandom();
            int node = generator.nextInt(numberOfEntries);
            for (int i = 0; i < node; i++)
            {
                currentNode = currentNode.getNext();
            }
            return currentNode.getData();
        }
        return null;
    }


    /**
     * This removes an entry from the linked bag by copying the value of the
     * first node and replacing it with the removed node.
     * 
     * @param anEntry
     *            Generic being added to the LinkedBag.
     * @return Returns true if the entry was removed.
     */
    public boolean remove(T anEntry)
    {
        Node<T> entry = this.getReferenceTo(anEntry);
        if (entry != null)
        {
            // Decreasing the number of entries in the bag as one of them is
            // removed
            entry.setData(firstNode.getData());
            firstNode = firstNode.getNext();
            numberOfEntries--;
            return true;
        }
        return false;
    }


    /**
     * This private method gets the reference of the specified entry.
     * 
     * @param anEntry
     *            Generic being added to the bag.
     * @return Returns the reference of the node.
     */
    private Node<T> getReferenceTo(T anEntry)
    {
        Boolean found = false;
        Node<T> currentNode = firstNode;

        // Looping through the bag till the specific entry is found and returned
        while (!found && currentNode != null)
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;
    }
}
