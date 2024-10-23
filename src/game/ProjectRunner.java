// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aastha Paranthaman (aasthap)
package game;

// -------------------------------------------------------------------------
/**
 * This is the ProjectRunner class. It has a main method that runs the different
 * constructors based on the length of the argument passed in it.
 * 
 * @author Aastha Paranthaman (aasthap)
 * @version 2024.10.01
 */
public class ProjectRunner
{
    // ~Public Methods ........................................................
    /**
     * This main method calls different WhackAShape constructors depending on
     * the length of args.
     * 
     * @param args
     *            Passing string arguments to the command line interface.
     */
    public static void main(String[] args)
    {
        // If the length of args is greater than 0, a different WhackAShape
        // constructors is called
        if (args.length > 0)
        {
            WhackAShape whackAShape = new WhackAShape(args);
        }
        else
        {
            WhackAShape whackAShape = new WhackAShape();
        }
    }
}
