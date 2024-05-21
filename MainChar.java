import java.util.HashMap;
import java.util.Set; 
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.List; 

public class MainChar implements Entity{

    private String name; 
    private float health; 
    private HashMap<String, Float> supps; 
    private String state;  
    private List <Entity> entityarr; 
    private float days; 
    private float balance; 
    private int ind; 
    private boolean dead; 

    public void setBalance(float b)
    {
        balance = b; 
    }

    public float getBalance()
    {
        return balance; 
    }

    public void setName(String n)
    {
        name = n; 
    }

    public String getName()
    {
        return name; 
    }

    public void setSupplies(HashMap<String, Float> s)
    {
        supps = s; 
    }

    public HashMap<String, Float> getSupplies()
    {
        return supps; 
    }

    public void setState(String s)
    {
        state = s; 
    }

    public String getterState()
    {
        return state; 
    }

    public void setHealth(float h)
    {
        health = h; 
    }

    public float getHealth()
    {
        return health; 
    }

    public void setDays(float d)
    {
        days = d; 
    }

    public float getDays()
    {
        return days; 
    }

    public void getAdvice()
    {
        System.out.println("\nIf you want to win the game, you have to make sure you watch your supplies and health levels. With every choice you make to travel a new distance, your supplies and health decrease at a rate proportionate to the distance you're traveling. When you find yourself at a landmark, make sure you opt to explore your options. At the landmarks, you're able to buy supplies and food to increase your health. You can also opt to rest a certain amount of days, which will increase your health by 2 points for each day of rest, however it will eat into your resources. If any of your family members' healths reach 0, they will die of starvation. If your health or supplies reach 0, you die and the game ends. The health and supplies deplete at a rate that will kill you before you reach Gasson, so utilizing one of these options is necessary. A good idea is to check your supplies and health at every location, and then making a choice on how to make sure you and your friends can stay alive.\n");
    }

    public String getType()
    {
        return "main character"; 
    }

    public float depleteHealth(float health)
    {
        return (float)(health - 15);

    }

    public void setDead(boolean d)
    {
        dead = d; 
    }

    public boolean getDead()
    {
        return dead; 
    }

    public void remove(List<Entity> ea, int index)
    {
        entityarr = ea; 
        ind = index; 
        entityarr.remove(ind); 
    }


    public HashMap<String, Float> depleteSupplies(HashMap<String, Float> supplies, int distance)
    {
        Set<String> setofKeys = supplies.keySet(); 
        for (String supplytype : setofKeys)
        { 
            float temp = supplies.get(supplytype);
            if(supplies.get(supplytype)<=(float)3)
            {
                temp = temp - (float)1; 
            }
            else 
            {
                temp = (float)(temp*0.7); 
            }
            supplies.put(supplytype, temp); 
        }
        return supplies; 
    }

    public void checkSupplies(HashMap<String, Float> supplies)
    {
        Set<String> setofKeys = supplies.keySet(); 
        for (String supplytype : setofKeys)
        {
            System.out.print(supplytype + ": "); 
            System.out.printf("%.2f \n", supplies.get(supplytype)); 
        }
        System.out.println("Balance: " + balance); 
    }

    public void ContinueTrail()
    {
        System.out.println("Alright, let's get a move on then!\n");
    }

    public void LookAtMap(String st)
    {
        if (st.equals("Cleveland Circle"))
        {
            try 
            {
                File storetxt = new File("clevelandcmap.txt"); 
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
        else if(st.equals("Resevoir"))
        {
            try 
            {
                File storetxt = new File("resevoirmap.txt"); 
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
        else if(st.equals("Alumni Stadium"))
        {
            try 
            {
                File storetxt = new File("contemap.txt"); 
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
        else if(st.equals("Schiller"))
        {
            try 
            {
                File storetxt = new File("schillermap.txt"); 
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

    public float addedFood(float health, float food)
    {
        health = health + food/10; 
        System.out.println("You bought " + food + " pounds of food, your health has increased by " + food/10 + "\n");
        return health; 
    }

    public float restSome(float health, float days)
    {
        health = health + (days*2); 
        System.out.println("You rested for " + days + " days, your health has increased by " + (days*2));
        return health; 

    }

    public HashMap<String, Float> buySupplies(HashMap<String, Float> supplies, float budget)
    {  
        Set<String> setofKeys = supplies.keySet(); 
        HashMap<String, Float> addedsupplies = new HashMap<String, Float>(); 
        float input; 
        int i = 0; 
        float [] prices = {10, 10,5,20,(float)0.2};
        Scanner keyboard = new Scanner(System.in);
        for (String supplytype : setofKeys)
        {
            System.out.println("Current balance: " + budget); 
            System.out.print("How many units of " + supplytype + " would you like to buy? ");
            if (supplytype.equals("Food"))
            {
                System.out.println("(20 cents per pound)");
            }
            if (supplytype.equals("Spare Parts"))
            {
                System.out.println("(10 dollars per part)");
            }
            if (supplytype.equals("Apparel"))
            {
                System.out.println("(10 dollars per variety pack)");
            }
            if (supplytype.equals("Oxen"))
            {
                System.out.println("(20 dollars each)");
            }
            if (supplytype.equals("Ammunition")) 
            {
                System.out.println("(5 dollars per box)");
            }
            System.out.print("> ");

            if(keyboard.hasNextInt())
            {
                input = (float)keyboard.nextInt();
                float totalcost = prices[i] *input; 
                if (totalcost <=budget)
                {
                    budget -= totalcost;  
                    addedsupplies.put(supplytype, input); 
                }
                else
                {
                    System.out.println("Not enough money");
                    addedsupplies.put(supplytype, (float) 0);  
                    
                }
                i++;    
            }
            else
            {
                System.out.println("You need to input a number"); 
                keyboard.next(); 
                addedsupplies.put(supplytype, (float) 0);  
            }
            
        }
        balance = budget; 
        return addedsupplies; 
        

    }





}
