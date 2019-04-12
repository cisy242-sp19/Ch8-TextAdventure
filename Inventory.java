import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 *The inventory class is dedicated to storing all items used by the player
 *in the game, and their present state.
 *
 * @author Andrew Riganati
 * @version 2019.08.04
 */
public class Inventory
{
    // instance variables - replace the example below with your own
    //torch is set an int instead of boolean due to having multiple states
    private boolean found;
    private int weight;
    private int torch;
    private boolean tinderbox;
    private boolean hat;
    private boolean ironspit;
    private boolean plank;
    private ArrayList<Inventory> backpack;
    /**
     * Constructor for objects of class Inventory
     * instanciates the inital state of each item. I.E it not having 
     * been picked up.
     */
    public Inventory()
    {
        // initialise instance variables
        //torch has three states, dying (0), pitch soaked (1), and lit(2)
        //torch = 0;
        //ironspit = false;
        //hat = false;
        //plank = false;
        backpack = new ArrayList<>();
    }

    
    
    private void takeitem(String item)
    {
    }
}
