/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room mossystoneroom, pitchroom, tinderboxroom, sewer, grubgrubroom, stairway, stairwayb2;
      
        // create the rooms
        mossystoneroom = new Room("You awake on a cold stone floor." +
        "A greeny fuzzy moss is overtaking several walls");
        pitchroom = new Room("You enter a poorly lit room, it is undecorated" +
        "save for a barrel of pitch in the corner.");
        
        tinderboxroom = new Room("You walk into a small square room, " +
        "completely empty save for the remnants of" +
        "a long snuffed campfire,a small tinder box lays discarded off to the side.");
        
        sewer = new Room("The room you step into reverberates with the sound of running water");
        
        grubgrubroom = new Room("You step out of the sewer, and into a room with charred walls smelling of" +
        "smoked meats. You look around and immediately see a small green creature wearing a chefs hat, tinted grey" +
        "from smoke. It notices you, and shouts 'hello! my name grub grub, you want buy some meats?");
        
        stairway = new Room("a stairway, goes up to grubgrubs's grubhub, and down to the next level of the maze.");
        
        stairwayb2 = new Room("a stairway, goes up to the first floor, north is another room");
        // initialise room exits
        mossystoneroom.setExit("east", pitchroom);
        mossystoneroom.setExit("west", tinderboxroom);

        pitchroom.setExit("west", mossystoneroom);

        tinderboxroom.setExit("east", mossystoneroom);
        tinderboxroom.setExit("south", sewer);
        
        sewer.setExit("north", tinderboxroom);
        sewer.setExit("east", grubgrubroom);
        
        grubgrubroom.setExit("west", sewer);
       
        stairway.setExit("west",  grubgrubroom);
        stairway.setExit("east", stairwayb2);
        
        stairwayb2.setExit("east" , stairway);
       

        currentRoom = mossystoneroom;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Labyrinth!");
        System.out.println("A maze made by an evil wizard, dare you try to escape?");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
