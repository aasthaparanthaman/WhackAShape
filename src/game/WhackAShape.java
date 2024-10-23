// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aastha Paranthaman (aasthap)
package game;

import bag.BagInterface;
import bag.SimpleBagInterface;
import cs2.*;
import student.TestableRandom;
import java.awt.Color;

// -------------------------------------------------------------------------
/**
 * This is the WhackAShape class. It gets all the items inside the window and
 * bag and creates a quit button to exit out of the GUI. It also displays the
 * different shapes inside the bag with different colors and positions.
 * 
 * @author Aastha Paranthaman (aasthap)
 * @version 2024.10.01
 */
public class WhackAShape
{

    // ~ Fields ................................................................

    /**
     * This STRINGS field is a constant that is available to any other classes.
     */
    private static final String[] STRINGS =
        { "red circle", "blue circle", "red square", "blue square" };
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    private Button quitButton;

    // ~ Constructors ..........................................................

    /**
     * This is the default constructor of WhackAShape. It initializes the bag,
     * window and quit button and randomly adds shapes to the bag.
     */
    public WhackAShape()
    {
        // Initializing bag and window
        bag = new SimpleArrayBag<>();
        window = new Window();

        // Creating the "Quit" Button
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.EAST);

        randomGenerator = new TestableRandom();
        int bagSize = randomGenerator.nextInt(9) + 6;

        // Randomly adding shapes to the bag
        for (int i = 0; i < bagSize; i++)
        {
            int random = randomGenerator.nextInt(STRINGS.length);
            bag.add(buildShape(STRINGS[random]));
        }
        window.addShape(bag.pick());
    }


    /**
     * This is another WhackAShape constructor. It initializes the bag, window
     * and quit button and converts the inputs into shapes. It also throws and
     * exception statements if the required arguments are not passed.
     * 
     * @param inputs
     *            The String array of inputs that are converted into shapes.
     */
    public WhackAShape(String[] inputs)
    {
        // Initializing bag and window
        bag = new SimpleArrayBag<>();
        window = new Window();

        // Creating the "Quit" Button
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.EAST);

        for (int i = 0; i < inputs.length; i++)
        {
            // Converting the String inputs into shapes and adding them to the
            // bag
            try
            {
                Shape shape = buildShape(inputs[i]);
                bag.add(shape);
            }

            // Printing an exception message if invalid inputs are given
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }
        }
        window.addShape(bag.pick());
    }

    // ~Public Methods ........................................................


    /**
     * This is a getter method for the window.
     * 
     * @return Returns window the entire window.
     */
    public Window getWindow()
    {
        return window;
    }


    /**
     * This is a getter method for the bag.
     * 
     * @return Returns bag the entire bag.
     */
    public SimpleBagInterface<Shape> getBag()
    {
        return bag;
    }


    /**
     * This clickedQuit method exits out of the GUI window.
     * 
     * @param button
     *            The button that quits the GUI.
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * This clickedChoose method chooses a new shape out of the Bag.
     * 
     * @param shape
     *            The shape that is chosen from the bag.
     */
    public void clickedShape(Shape shape)
    {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();

        // Displaying the "You Win" text in the center of the window after the
        // bag is empty
        if (nextShape == null)
        {
            TextShape textShape = new TextShape(
                window.getGraphPanelWidth() / 2,
                window.getGraphPanelHeight() / 2,
                "You Win!");
            window.addShape(textShape);
        }
        else
        {
            window.addShape(nextShape);
        }
    }


    /**
     * This build shape method uses a string input to create the specific
     * features of the shape. These features include the color, size, position
     * and shape of the shape.
     * 
     * @param input
     *            String input that creates the shape.
     * @return Returns currentShape the specific shape created.
     */
    private Shape buildShape(String input)
    {
        // Using the TestableRandom class to pick a random number from 100-200
        int size = randomGenerator.nextInt(101) + 100;
        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size);

        Shape currentShape = new Shape(x, y);

        // Creating different colored and sized shapes depending on the input
        // String
        if (input.contains("red") && (input.contains("circle")))
        {
            currentShape = new CircleShape(x, y, size, Color.RED);
            currentShape.onClick(this, "clickedShape");
        }
        else if (input.contains("red") && (input.contains("square")))
        {
            currentShape = new SquareShape(x, y, size, Color.RED);
            currentShape.onClick(this, "clickedShape");
        }
        else if (input.contains("blue") && (input.contains("circle")))
        {
            currentShape = new CircleShape(x, y, size, Color.BLUE);
            currentShape.onClick(this, "clickedShape");
        }
        else if (input.contains("blue") && input.contains("square"))
        {
            currentShape = new SquareShape(x, y, size, Color.BLUE);
            currentShape.onClick(this, "clickedShape");
        }

        // Throwing an exception statement if different arguments are given
        else
        {
            throw new IllegalArgumentException();
        }
        return currentShape;
    }
}
