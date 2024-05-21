/*This class sets a template for the game such as defining standard state progressions,
 passing off information to State classes and Entity makers. 
*/
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 

public abstract class MarketTemplate {

    public void present(int num)
    {
        try 
        {
            File storetxt = new File("Store.txt"); 
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

        System.out.println("Welcome to the BC Bookstore, my name is Baldwin. Here you will buy everything you need in order to survive your journey.\n");
        System.out.println("Now, there are 5 things here that are NECESSARY to your survival: Food to fuel yourself, Spare parts for your wagon, BC apparel to stay warm and stylish, Ammunition to defend against Computer Science professors,  and Newton Kids to pull your wagon.\n");
        System.out.println("It seems you have " + money(num) + " dollars. I will give you purchasing reccomendations based on your budget.\n");
    }

    public float buy(float[] nums)
    {
        float total = nums[0]; 
        float price = nums[1]; 
        float units = nums[2]; 

        float newtotal = total - (price*units); 

        return newtotal; 
    }

    public int money(int num)
    {
        if (num == 1)
        {
            return 1600; 
        }
        if(num == 2)
        {
            return 1200; 
        }
        else
        {
            return 800; 
        }
    }

    public float[] suggestFood()
    {
        float[] basicarr = {(float) 0.0,(float) 0.0,(float) 0.0};
        return basicarr; 
    }

    public float[] suggestSpareParts(float newtotal)
    {
        float[] basicarr = {(float) 0.0,(float) 0.0,(float) 0.0};
        return basicarr;
    }

    public float[] suggestApparel(float newtotal)
    {
        float[] basicarr = {(float) 0.0,(float) 0.0,(float) 0.0};
        return basicarr; 
    }

    public float[] suggestAmmunition(float newtotal)
    {
        float[] basicarr = {(float) 0.0,(float) 0.0,(float) 0.0};
        return basicarr; 
    }

    public float[] suggestOxen(float newtotal)
    {
        float[] basicarr = {(float) 0.0,(float) 0.0,(float) 0.0};
        return basicarr; 
    }


    
}


