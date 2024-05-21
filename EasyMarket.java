import java.util.Scanner; 
import java.io.File; 
import java.io.FileNotFoundException;

public class EasyMarket extends MarketTemplate{
    GameMode easy = new EasyMode(); 

    public float[] suggestFood()
    {

        try 
        {
            File storetxt = new File("chicken.txt"); 
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

        System.out.println("You've got quite the budget! Don't worry, my prices stay the same no matter the endowment of my client.\n");
        System.out.println("Because you have room to work with, I would suggest this: \n");
        System.out.println("First: Food. Here, we pride ourselves on having the best collection of chicken and two sides east of the Mississippi. You have 5 people in your friend group, and I recommend 200 pounds of chicken and two sides to all my clients. I charge 20 cents a pound.\n"); 
        Scanner keyboard = new Scanner(System.in); 

        float[] floatarr = {0,0,0};
        while(true)
        {
            System.out.println("How many pounds of food would you like to buy? (Enter a number 0 to 8000)\n"); 
            System.out.print(">"); 
            String in = keyboard.next(); 
            int inval = 0; 

            try
            {
                inval = Integer.parseInt(in); 
                if (inval <0 || inval > 8000)
                {
                    System.out.println("Input must be in range 0 to 8000\n");
                    continue; 
                }
                else
                {
                    System.out.println("Fantastic! " + inval + " pounds of chicken and two sides coming right up!\n"); 
                    float num1 = (float)inval; 
                    floatarr[0] = (float)(easy.getMoney());
                    floatarr[1] = (float)0.2; 
                    floatarr[2] = (float)num1; 
                    break; 
                }
            }

            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be in range 0 to 8000\n");
            }

        }

        return floatarr; 
        

    }


    public float[] suggestSpareParts(float newtotal)
    {

        if(newtotal == 0)
        {
            System.out.println("Seems like your're out of money. Try managing your budget better next time!");
        }

        try 
        {
            File storetxt = new File("wheel.txt"); 
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

        System.out.println("Next: Spare Parts. It's a good idea to have spare parts for your wagon, as they send to go through some wear and tear throughout travel. Lucky for you I have the sturdiest wagon parts in town. I charge 10 dollars a spare part, and I suggest 3 of each part type (Wheel, Axle, Tonge).\n"); 
        String[] strarr = {"wheels", "axles", "tongues"}; 
        Scanner keyboard = new Scanner(System.in); 
        float[] floatarr = {0,0,0};

        for(int i = 0; i <=2; i++)
        {

            while(true)
            {
                System.out.println("How many "+strarr[i]+" would you like to buy? (enter a number 1 to " + newtotal/10.0 + ").\n"); 
                System.out.print(">"); 
                String in = keyboard.next(); 
                int inval = 0;

                try
                {
                    inval = Integer.parseInt(in); 
                    if (inval <0 || inval > newtotal/10.0)
                    {
                        System.out.println("Input must be in range 0 to " + newtotal/10.0 + ".\n");
                        continue; 
                    }
                    else
                    {
                        System.out.println("Fantastic! " + inval + " "+strarr[i]+" coming right up!");
                        floatarr[0] = (float)(newtotal);
                        floatarr[1] = (float)10;
                        floatarr[2] += (float)inval;
                        newtotal = newtotal - (float)(inval*10);
                        break; 
                    }
                }

                catch (NumberFormatException nfe)
                {
                    System.out.println("How many "+strarr[i]+" would you like to buy? (enter a number 1 to " + newtotal/10.0 + ").\n"); 
                }
            }
        }

        return floatarr; 
    }
    

    public float[] suggestApparel(float newtotal)
    {

        try 
        {
            File storetxt = new File("shirt.txt"); 
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

        System.out.println("Next: Apparel. Depending on when you leave, the weather can be blisteringly hot or num-your-face-off cold. I have a great variety pack, perfect for any traveler! I suggets 2 variety packs for each friend group member, and I charge 10 dollars a pack.\n");  
        Scanner keyboard2 = new Scanner(System.in); 

        float[] floatarr = {0,0,0};
        while(true)
        {
            System.out.println("How many variety packs would you like to buy? (Enter a number 0 to " + newtotal/10.0 +")\n"); 
            System.out.print(">"); 
            String in = keyboard2.next(); 
            int inval = 0; 

            try
            {
                inval = Integer.parseInt(in); 
                if (inval <0 || inval > newtotal/10.0)
                {
                    System.out.println("Input must be in range 0 to " + newtotal/10.0 + ".\n");
                    continue; 
                }
                else
                {
                    System.out.println("Fantastic! " + inval + " variety packs coming right up!\n"); 
                    float num1 = (float)inval; 
                    floatarr[0] = (float)newtotal;
                    floatarr[1] = (float)10; 
                    floatarr[2] = (float)num1; 
                    break; 
                }
            }

            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be in range 0 to " + newtotal/10.0 + ".\n");
            }

        }

        return floatarr; 
        

    }

    public float[] suggestAmmunition(float newtotal)
    {

        try 
        {
            File storetxt = new File("ammunition.txt"); 
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

        System.out.println("Next: Ammunition. On your journey, you'll undoubtedly have plenty of encounters with the wild Computer Science professors of the Schiller Institute. There's only one thing that computer science professors are afraid of, and that's extra credit points. I sell extra credit points in boxes of 20, and each box costs 2 dollars. I recommend at least 10 boxes.\n");  
        Scanner keyboard2 = new Scanner(System.in); 

        float[] floatarr = {0,0,0};
        while(true)
        {
            System.out.println("How many boxes would you like to buy? (Enter a number 0 to " + newtotal/10.0 +")\n"); 
            System.out.print(">"); 
            String in = keyboard2.next(); 
            int inval = 0; 

            try
            {
                inval = Integer.parseInt(in); 
                if (inval <0 || inval > newtotal/10.0)
                {
                    System.out.println("Input must be in range 0 to " + newtotal/10.0 + ".\n");
                    continue; 
                }
                else
                {
                    System.out.println("Fantastic! " + inval + " boxes of extra credit ammunition coming right up!\n"); 
                    float num1 = (float)inval; 
                    floatarr[0] = (float)newtotal;
                    floatarr[1] = (float)10; 
                    floatarr[2] = (float)num1; 
                    break; 
                }
            }

            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be in range 0 to " + newtotal/10.0 + ".\n");
            }

        }

        return floatarr; 
        

    }

    public float[] suggestOxen(float newtotal)
    {

        try 
        {
            File storetxt = new File("oxen.txt"); 
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

        System.out.println("Finally: Oxen. You'll need some beastly creatures to pull your wagon along the trail, and we're trying to get rid of all the oxen we have in stock. I recommend at least 6, and I charge 20 dollars each.\n");  
        Scanner keyboard2 = new Scanner(System.in); 

        float[] floatarr = {0,0,0};
        while(true)
        {
            System.out.println("How many oxen would you like to buy? (Enter a number 0 to " + newtotal/20.0 +")\n"); 
            System.out.print(">"); 
            String in = keyboard2.next(); 
            int inval = 0; 

            try
            {
                inval = Integer.parseInt(in); 
                if (inval <0 || inval > newtotal/20.0)
                {
                    System.out.println("Input must be in range 0 to " + newtotal/20.0 + ".\n");
                    continue; 
                }
                else
                {
                    System.out.println("Fantastic! " + inval + " oxen coming right up!\n"); 
                    float num1 = (float)inval; 
                    floatarr[0] = (float)newtotal;
                    floatarr[1] = (float)20; 
                    floatarr[2] = (float)num1; 
                    break; 
                }
            }

            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be in range 0 to " + newtotal/20.0 + ".\n");
            }

        }

        return floatarr; 
        

    }

    


    
}

