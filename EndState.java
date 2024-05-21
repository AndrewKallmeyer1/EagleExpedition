import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class EndState implements GameState{
    

    public String getState()
    {
        return "end";
    }

    public String presentState(String state)
    {
            try 
            {
                File storetxt = new File("gasson.txt"); 
                Scanner scan = new Scanner(storetxt); 
                while(scan.hasNextLine())
                {
                    System.out.println(scan.nextLine()); 
                }
                scan.close(); 
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Error"); 
            }

        System.out.println("\n\nYou finally made it to Gasson Hall, the crown jewel of the greater Boston metropolitan area. Its infamous bell rings out in celebration, and a tear comes to your eye, you've finally made it.\n");
        System.out.println("\t\t\t\t  _______ _                 _                           __                   _             _             ");
        System.out.println("\t\t\t\t |__   __| |               | |                         / _|                 | |           (_)            ");
        System.out.println("\t\t\t\t    | |  | |__   __ _ _ __ | | __  _   _  ___  _   _  | |_ ___  _ __   _ __ | | __ _ _   _ _ _ __   __ _ ");
        System.out.println("\t\t\t\t    | |  | '_ \\ / _` | '_ \\| |/ / | | | |/ _ \\| | | | |  _/ _ \\| '__| | '_ \\| |/ _` | | | | | '_ \\ / _` |");
        System.out.println("\t\t\t\t    | |  | | | | (_| | | | |   <  | |_| | (_) | |_| | | || (_) | |    | |_) | | (_| | |_| | | | | | (_| |");
        System.out.println("\t\t\t\t    |_|  |_| |_|\\__,_|_| |_|_|\\_\\  \\__, |\\___/ \\__,_| |_| \\___/|_|    | .__/|_|\\__,_|\\__, |_|_| |_|\\__, |");
        System.out.println("\t\t\t\t                                    __/ |                             | |             __/ |         __/ |");
        System.out.println("\t\t\t\t                                   |___/                              |_|            |___/         |___/ ");

        System.out.println("\n\n");

        System.out.println("\t\t\t\t\t  ______            _        ______                     _ _ _   _             "); 
        System.out.println("\t\t\t\t\t |  ____|          | |      |  ____|                   | (_) | (_)            ");
        System.out.println("\t\t\t\t\t | |__   __ _  __ _| | ___  | |__  __  ___ __   ___  __| |_| |_ _  ___  _ __  ");
        System.out.println("\t\t\t\t\t |  __| / _` |/ _` | |/ _ \\ |  __| \\ \\/ / '_ \\ / _ \\/ _` | | __| |/ _ \\| '_ \\ ");
        System.out.println("\t\t\t\t\t | |___| (_| | (_| | |  __/ | |____ >  <| |_) |  __/ (_| | | |_| | (_) | | | |");
        System.out.println("\t\t\t\t\t |______\\__,_|\\__, |_|\\___| |______/_/\\_\\ .__/ \\___|\\__,_|_|\\__|_|\\___/|_| |_|");
        System.out.println("\t\t\t\t\t               __/ |                    | |                                   ");
        System.out.println("\t\t\t\t\t              |___/                     |_|                                   \n"); 

        return ""; 


    }

    public GameState changeState()
    {
        return new TravelingState(); 
    }

    public GameState changetoEndState()
    {
        return new EndState(); 
    }

    public String presentTravelState(String s)
    {
        return "";
    }


    


}
