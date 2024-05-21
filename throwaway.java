import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class throwaway {
    

    public static void main(String [] args)
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
    }
}
