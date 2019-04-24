
/**
 * Enumeration class Items - would/will be where the enumerations values for items
 * is stored. In the event that items are handled by a case switch.
 *
 *(parralell of commandword)
 *
 * Andrew Riganati
 * 4.13.2019
 */
public enum Items
{
   
    TORCH("torch"), TINDERBOX("tinderbox"),HAT("hat"),IRONSPIT("ironspit"),
    PLANK("plank"), THINGGUMMYWHAT("thinggummywhat");
    
    
    private String itemString;
    
    Items(String itemString){
        this.itemString = itemString;
    }
    
    public String toString()
    {
        return itemString;
    }
    
}
