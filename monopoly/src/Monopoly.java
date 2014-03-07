import java.util.ArrayList;



public class Monopoly 
{
	
	private ArrayList<Square> squares ;
	private ArrayList<Player> players ;
	
    public Monopoly()
    {	
    	//creates arrays for players and square
    	squares = new ArrayList<Square>();  
    	players = new ArrayList<Player>();
    }
    //main method
	public static void main(String[] args){
		Monopoly app = new Monopoly();
		app.run();
		
	}
    //prints out menu
    private int mainMenu()
    { 
    	
    	StdOut.println("Staff Management Menu");
		StdOut.println("-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐");       
		StdOut.println("Welcome to Monopoly");
		StdOut.println("-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐");
		StdOut.println("	1. Add a player");
		StdOut.println("	2. List all players");
		StdOut.println("	3. Edit a player");
		StdOut.println("	4. Delete a player");
		StdOut.println("-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-");
		StdOut.println("The Game");
		StdOut.println("-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-­‐-");
		StdOut.println("	5.Start the game !");
		int option = StdIn.readInt();
		return option;
}
	//adds player
    private void addPlayer()
    {
    	StdOut.print("Players Name:");
   	 	String playerName = StdIn.readString(); 
   	 	int playerPosition = 0;
   	 	int money = 0;
        Player player =  new Player (playerName,playerPosition,money);
        players.add(player);     
    }
    
    //lists players
    public void listPlayers()
    {
        for (int i = 0; i < players.size(); i++)
        {
     	   StdOut.println(i + ":" + players.get(i));
        }
    }
    
    public void editPlayer()
    {
    	//allows user to edit player name
   	     listPlayers();
         StdOut.print("Player to edit ==>");
         int index = StdIn.readInt();
    
         StdOut.print("Enter new Player name: ");
         String newName = StdIn.readString();
         Player player = players.get(index);
         player.setName(newName);
         
     }
    
    public void deletePlayer()
    {
    	//deletes player(buggy)
   	    listPlayers();
        StdOut.print("Player to delete ==>");
        int index =  StdIn.readInt();
       // String check ="";
        /*StdOut.print("Are you sure ?Y/N");
        check =StdIn.readString();
        if(check =="Y"||check =="y" )
        {*/
       	 players.remove(index);
      //  }
      
    }
    public void load()
    { 
    	//loads the array of type square to make board
   	 squares = (ArrayList<Square>) StdStream.readFromFile("squares.xml");    
    
    }
    
    public void newGame()
    //starts a new game
    {
    	if (players.size()< 2)
    	{
    		//checks to make sure there are enough players
    		StdOut.print("You must have at least 2 players to play!!");
    	}
    	else
    	{
    		
    	}
    }
    
    public void run()
    {
        int option = mainMenu();
        while (option != 0)
        {
          
          switch (option)

          {
            case 1:
              addPlayer();
              break;
            case 2:
              listPlayers();
              break;
            case 3:
              editPlayer();
              break;
            case 4:
              deletePlayer();
              break;            
            case 5:
              newGame();
              break;  
             }
         
          option = mainMenu();
        }
        StdOut.println("Exiting... bye");
     }	
}


