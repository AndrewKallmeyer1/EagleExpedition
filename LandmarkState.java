import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class LandmarkState implements GameState{

    public String getState()
    {
        return "landmark";
    }

    public String presentState(String state)
    {
        if (state.equals("Resevoir"))
        {
            try 
            {
                File storetxt = new File("resevoir.txt"); 
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

            System.out.println("\n\nHere you are at the Resevoir. Miles of glistening water as far as the eye can see, swans and ducks glide across the water as you watch the early morning runners do their fifth lap around the trail. You can see Gasson's silhouette in the distance, reminding you that there is a goal in sight. However, now you know the toll of travel taking, you have lost some health, as have your friends, and your supplies have taken their first dent. Don't worry though, these landmarks always have outposts, franchised by Baldwin himself! Feel free to explore your options.");

        }

        Scanner key = new Scanner(System.in); 
        if (state.equals("Alumni Stadium"))
        {
            try 
            {
                File storetxt = new File("alumni.txt"); 
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

            System.out.println("\n\nYou've successfully crossed the resevoir and now find yourself at the great Alumni Statdium. The ghost of Doug Floutie haunts the corridors as you try to avoid eye contact with the angry mob shouting FIRE HAFLEY!! FIRE HAFLEY!! You look around at all the maroon and gold and know that Gasson is soon in your signts. Again, you have the chance to re-up on some supplies, or explore other options, the choice is up to you.");

        }

        if(state.equals("Schiller"))
        {
            try 
            {
                File storetxt = new File("schiller.txt"); 
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
            System.out.println("\n\nYou made it up the million dollar stairs and now walk through the glass doors into the Schiller institute. You hear the zombie like moans and cries coming from the Computer Science lab as you look over your shoulder to see if there are any professors around, as they carry with them your only fear in the world: discrete math problems. You know as long as you get out of here alive, you and your crew will make it to Gasson alive. There is an encampment of other travelers who have set up a trade outpost. Explore your options.");

        }

        System.out.println("\nYou have made it to one of the landmarks. Would you like to explore your options?  Press " +"\"" + "y" + "\""+ " if yes");
        System.out.print("> ");
        String output = key.nextLine(); 
        return output; 

    }

    public GameState changeState()
    {
        return new TravelingState(); 
    }

    public GameState changetoEndState()
    {
        return new EndState(); 
    }


    


    
}
