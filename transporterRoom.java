import java.util.Random;
/**
 * handles the logic of the teleporter room. Big thanks to a fellow student 
 * (whose name escapes me at the moment) for the showing me how to go about this.
 *
 * @author Andrew Riganati
 * @version 4.22.2019
 */
public class transporterRoom extends Room
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class transporterRoom
     * @param description - takes in the description for the room from its parent class
     */
    public transporterRoom(String description)
    {
        // initialise instance variables
        super(description);
    }
    
    
    /**
     * @param direction - takes a direction (north,east,south,west)
     * @return findRandomRoom - returns a direction. 
     */
    public Room getExit(String direction){
        return findRandomRoom();
    }
    
    /**
     * picks a random cardinal direction to send the player in
     * @return lw - Returns a random cardinal direction.
     */
    
    private Room findRandomRoom()
    {
        Random rand = new Random();
        //lw standing for lost woods :)
        Room lw;
        
        Room[] lwArray = new Room[4];
        lwArray[1] = super.getExit("north");
        lwArray[2] = super.getExit("east");
        lwArray[3] = super.getExit("south");
        lwArray[4] = super.getExit("west");
        
        lw = lwArray[rand.nextInt(lwArray.length)];
        return lw;
    }
}
