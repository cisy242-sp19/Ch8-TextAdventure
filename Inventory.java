import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 *The inventory class is dedicated to storing all items used by the player, as well as handling their use
 *in the game, and their present state.
 * 
 * (parralell of command)
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
    private Items Items;
    private String itemAction;
    private String useCase;
    /**
     * Constructor for objects of class Inventory
     * instanciates the inital state of each item. I.E existing and not having 
     * been picked up.
     */
    public Inventory()
    {
        this.Items = Items;
        this.itemAction  = itemAction;
       
    }
    
     public Items getItems()
    {
        return Items;
    }
    
    public String getItemAction()
    {
        return itemAction;
    }
    
    public boolean isTHINGGUMMYWHAT(){
        return (Items == Items.THINGGUMMYWHAT);
    }
    
    public boolean hasitemAction(){
        return (itemAction != null);
    }
}
