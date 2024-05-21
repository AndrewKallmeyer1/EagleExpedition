import java.util.Scanner;
import java.util.*; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
public class Driver{


    public static void depHealth(MainChar mc, List<Entity> entityarr)
    {
        mc.setHealth(mc.depleteHealth(mc.getHealth()));
        
        for (int y = 0; y < entityarr.size(); y++)
        {
            entityarr.get(y).setHealth(entityarr.get(y).depleteHealth(entityarr.get(y).getHealth()));    
        }
    }

    public static void endGame(MainChar mc, List<Entity> entityarr)
    {

        HashMap<String, Float> supps = mc.getSupplies();  
        for (int x = 0; x < entityarr.size(); x++)
        {
            if (entityarr.get(x).getHealth() <= (float)0)
            {
                System.out.println(entityarr.get(x).getName() + " died, health reached 0.");
                entityarr.get(x).setName("dead");
                entityarr.get(x).setHealth(1000);
                entityarr.get(x).setDead(true);
            }
        }

        if (mc.getHealth() <= 0.0)
        {
            System.out.println("You died of starvation. Next time make sure to buy more supplies when you're on your journey!");
            System.out.println("\n\nGAME OVER"); 
            System.exit(0); 
        }

        for (String key : supps.keySet())
        {
            if(supps.get(key) <= (float)0)
            {
                System.out.println("\nYou can out of " + key + ". Next time make sure to buy more supplies when you're on your journey!");
                System.out.println("\n\nGAME OVER");
                System.exit(0);  
            }
        }
    }

    public static HashMap<String, Float> MarketRunThrough(MarketTemplate mt, int num, MainChar mc)
    {
        mt.present(num);  
        HashMap<String, Float> supplies = new HashMap(); 

        float[] fa1 = mt.suggestFood(); 
        supplies.put("Food", fa1[2]); 
        float newtotal = mt.buy(fa1);

        fa1 = mt.suggestSpareParts(newtotal); 
        newtotal = mt.buy(fa1);
        supplies.put("Spare Parts", fa1[2]); 

        fa1 = mt.suggestApparel(newtotal); 
        newtotal = mt.buy(fa1);
        supplies.put("Apparel", fa1[2]); 

        fa1 = mt.suggestAmmunition(newtotal); 
        newtotal = mt.buy(fa1);
        supplies.put("Ammunition", fa1[2]); 

        fa1 = mt.suggestOxen(newtotal); 
        newtotal = mt.buy(fa1);
        supplies.put("Oxen", fa1[2]); 

        float endbalance = mt.buy(fa1); 
        mc.setBalance(endbalance); 

        System.out.println("Your ending balance is: $"+endbalance+"\n");
        System.out.println("Thanks for stopping by the shop!\n");

        return supplies; 
         
    }

    public static void TravelIteration(Scanner keyboard, Invoker i, MainChar mc, List<Entity> e)
    {
        System.out.println("\n1. Continue on Trail");
        System.out.println("2. Check Supplies");
        System.out.println("3. Rest");
        System.out.println("4. Check Health");
        int j = 0; 

        while(true)
        {
            System.out.println("\nWhat would you like to do? Choose number 1 through 4\n");
            System.out.print("> ");
            String in = keyboard.next(); 
            int inval = 0;
            try
            {
                inval = Integer.parseInt(in); 
                if(inval < 1 || inval > 4)
                {
                    System.out.println("What would you like to do? Choose number 1 through 4\n");    
                    continue;  
                }
                if (inval == 1)
                {
                    ContinueOnTrail cot = new ContinueOnTrail(mc); 
                    i.addActivity(cot);
                    i.performActivities();
                    i.removeActivity(cot); 
                    break; 
                }
                if (inval == 2)
                {
                    CheckSupplies cs = new CheckSupplies(mc); 
                    i.addActivity(cs); 
                    i.performActivities();
                    i.removeActivity(cs); 
                    continue; 
                }
                if (inval == 3)
                {
                    if(j > 0)
                    {
                        System.out.println("\nCannot rest more than once at one location. Try again next location.");  
                    }
                    else
                    {
                        while(true)
                        {
                            System.out.println("\nHow many days would you like to rest? Choose a number 1 to 7. You cannot rest more than a week.");
                            System.out.print("> ");
                            String in1 = keyboard.next(); 
                            try
                            {
                                int inval1 = Integer.parseInt(in1); 
                                if (inval1 > 0 && inval1 <=7)
                                {
                                    mc.setDays((float)inval1);
                                    TakeRest tr = new TakeRest(mc, e); 
                                    i.addActivity(tr); 
                                    i.performActivities();
                                    i.removeActivity(tr); 
                                    j = j + 1; 
                                    break; 
                                }
                                else
                                {
                                    System.out.println("Must be an int 1 to 7. You cannot rest more than a week.");
                                    continue; 
                                }
                            }
                            catch(NumberFormatException nfe)
                            {
                                System.out.println("Must be an int 1 to 7. You cannot rest more than a week."); 
                            }
                        }
                    }
                    continue;    
                }
                if (inval ==4)
                {
                    CheckHealth ch = new CheckHealth(mc, e);
                    i.addActivity(ch); 
                    i.performActivities();
                    i.removeActivity(ch);
                    continue; 
                }

            }
            catch (NumberFormatException nfe)
            {
                System.out.println("\nWhat would you like to do? Choose number 1 through 4\n");
            }
        }

    }

    public static void LandmarkIteration(Scanner keyboard, Invoker i, MainChar mc, List<Entity> e, HashMap<String, Float> map)
    {
        System.out.println("\n1. Continue on Trail");
        System.out.println("2. Check Supplies");
        System.out.println("3. Rest");
        System.out.println("4. Check the Map");
        System.out.println("5. Buy Supplies");
        System.out.println("6. Check Health");
        System.out.println("7. Get Advice");
        int j = 0;
        int k = 0; 

        while(true)
        {
            System.out.println("\nWhat would you like to do? Choose number 1 through 7\n");
            System.out.print("> ");
            String in = keyboard.next(); 
            int inval = 0;
            try
            {
                inval = Integer.parseInt(in); 
                if(inval < 1 || inval > 7)
                {
                    System.out.println("Input must be int from 1 to 7");
                    continue;  
                }
                if (inval == 1)
                {
                    ContinueOnTrail cot = new ContinueOnTrail(mc); 
                    i.addActivity(cot);
                    i.performActivities();
                    i.removeActivity(cot);
                    break; 
                }
                if (inval == 2)
                {
                    CheckSupplies cs = new CheckSupplies(mc); 
                    i.addActivity(cs); 
                    i.performActivities();
                    i.removeActivity(cs); 
                    continue; 
                }
                if (inval == 3)
                {
                    if(j > 0)
                    {
                        System.out.println("\nCannot rest more than once at one location. Try again next location.");  
                    }
                    else
                    {
                        while(true)
                        {
                            System.out.println("\nHow many days would you like to rest? Choose a number 1 to 7. You cannot rest more than a week.");
                            System.out.print("> ");
                            String in1 = keyboard.next(); 
                            try
                            {
                                int inval1 = Integer.parseInt(in1); 
                                if (inval1 > 0 && inval1 <=7)
                                {
                                    mc.setDays((float)inval1);
                                    TakeRest tr = new TakeRest(mc, e); 
                                    i.addActivity(tr); 
                                    i.performActivities();
                                    i.removeActivity(tr); 
                                    j = j + 1; 
                                    break; 
                                }
                                else
                                {
                                    System.out.println("Must be an int 1 to 7. You cannot rest more than a week.");
                                    continue; 
                                }
                            }
                            catch(NumberFormatException nfe)
                            {
                                System.out.println("Must be an int 1 to 7. You cannot rest more than a week."); 
                            }
                        }
                    }
                    continue;    
                }
                if(inval == 4)
                {
                    ViewMap vm = new ViewMap(mc);
                    i.addActivity(vm);
                    i.performActivities();
                    i.removeActivity(vm); 
                    continue; 
                }
                if (inval == 5)
                {
                    if (k > 0)
                    {
                        System.out.println("\nYou cannot buy supplies more than once in one location. Try again at next location."); 
                    }
                    else 
                    {
                        BuySupplies bs = new BuySupplies(mc, e, map);
                        i.addActivity(bs);
                        i.performActivities();
                        i.removeActivity(bs); 
                        k++; 
                        continue;
                    }
                    
                }
                if (inval ==6)
                {
                    CheckHealth ch = new CheckHealth(mc, e);
                    i.addActivity(ch); 
                    i.performActivities();
                    i.removeActivity(ch);
                    continue; 
                }
                if (inval == 7)
                {
                    GetAdvice ga = new GetAdvice(mc); 
                    i.addActivity(ga); 
                    i.performActivities();
                    i.removeActivity(ga);
                    continue; 
                }

            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be int from 1 to 7");
            }

        }
    }
    public static void main (String [] args)
    {


        System.out.println(" ______            _        ______                     _ _ _   _             "); 
        System.out.println("|  ____|          | |      |  ____|                   | (_) | (_)            ");
        System.out.println("| |__   __ _  __ _| | ___  | |__  __  ___ __   ___  __| |_| |_ _  ___  _ __  ");
        System.out.println("|  __| / _` |/ _` | |/ _ \\ |  __| \\ \\/ / '_ \\ / _ \\/ _` | | __| |/ _ \\| '_ \\ ");
        System.out.println("| |___| (_| | (_| | |  __/ | |____ >  <| |_) |  __/ (_| | | |_| | (_) | | | |");
        System.out.println("|______\\__,_|\\__, |_|\\___| |______/_/\\_\\ .__/ \\___|\\__,_|_|\\__|_|\\___/|_| |_|");
        System.out.println("              __/ |                    | |                                   ");
        System.out.println("             |___/                     |_|                                   \n");    

        System.out.println("Welcome to Eagle Expedition, a Boston College themed, Oregon Trail style game!\n");
        System.out.println("Press s and ENTER to start.\n"); 
        System.out.print("> "); 

        Scanner keyboard = new Scanner(System.in); 
        String input = keyboard.nextLine(); 

        while(!input.toUpperCase().equals("S"))
        {
            System.out.println("Input must be " + "\"" + "s" + "\"" + " or " + "\"" + "S" + "\"" + ".\n"); 
            System.out.print("> "); 
            input = keyboard.nextLine(); 
        }

        System.out.println("You will have 5 people in your group. Enter names for each one, the first one being your name (group leader)");
        String [] names = {"","","","",""};


        EntityMaker maincharmaker = new MainCharMaker(); 
        EntityMaker familymembermaker = new FamilyMemberMaker(); 

        Entity fm1 = familymembermaker.makeEntity();
        Entity fm2 = familymembermaker.makeEntity(); 
        Entity fm3 = familymembermaker.makeEntity(); 
        Entity fm4 = familymembermaker.makeEntity(); 
        MainChar mc = new MainChar();
        mc.setHealth(100); 
        fm1.setHealth(100); 
        fm2.setHealth(100); 
        fm3.setHealth(100); 
        fm4.setHealth(100); 


        List<Entity> entityarr = new ArrayList<Entity>(4); 
        entityarr.add(fm1);
        entityarr.add(fm2);
        entityarr.add(fm3);
        entityarr.add(fm4);


        for (int i = 1; i<=5; i ++)
        {
            while(true)
            {
                if (i == 1)
                {
                    System.out.print("Your name: ");
                }
                else
                {
                    System.out.print("Family Member Name " + (i-1) + ": ");
                }
                try
                {
                    String in = keyboard.next(); 
                    if(in.isEmpty() || !in.matches("^[a-zA-z]*$"))
                    {
                        System.out.println("Input must be a String");
                        continue;  
                    }
                    else 
                    {
                        if (i == 1)
                        {
                            names[0] = in; 
                            mc.setName(names[0].toString());
                            break; 
                        }
                        else
                        {
                            names[i-1] = in;   
                            entityarr.get(i-2).setName(names[i-1]);
                            break; 
                        }
                    }
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("Input must be a String");
                }
            }
        }
        

        GameMode mode;

        System.out.println("\nFirst, you will pick a game mode:");
        System.out.println("(1) Easy");  
        System.out.println("(2) Medium");
        System.out.println("(3) Hard"); 
        System.out.println("(4) More Information");  

 

        while(true)
        {
            System.out.println("\nEnter a game mode:\n");
            System.out.print("> ");
            String in = keyboard.next(); 
            int inval = 0; 
            try
            {
                inval = Integer.parseInt(in); 
                if(inval < 1 || inval > 4)
                {
                    System.out.println("Input must be " + "\"" + "1" + "\"" + ", " + "\"" + "2" + "\"" + ", " + "\"" + "3" + "\"" +", or " + "\"" + "4" + "\"" + ".");
                    continue;  
                }
                if (inval ==1)
                {
                    mode = new EasyMode();
                    MarketTemplate mt = new EasyMarket(); 
                    mc.setSupplies(MarketRunThrough(mt, inval, mc));
                    break; 
                }
                if (inval ==2)
                {
                    mode = new MediumMode();
                    MarketTemplate mt = new MediumMarket(); 
                    mc.setSupplies(MarketRunThrough(mt, inval, mc));
                    break;  
                }
                if (inval ==3)
                {
                    mode = new HardMode();
                    MarketTemplate mt = new HardMarket(); 
                    mc.setSupplies(MarketRunThrough(mt, inval, mc));
                    break;  
                }       
                if(inval ==4)
                {
                    System.out.println("These game modes differ only in the amount of money alloted to the player at the beginning of the game for supplies");
                    System.out.println("Easy Mode allots 1600 dollars");
                    System.out.println("Medium Mode allots 1200 dollars");
                    System.out.println("Hard Mode allots 800 dollars");
                    continue; 
                }
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be " + "\"" + "1" + "\"" + ", " + "\"" + "2" + "\"" + ", " + "\"" + "3" + "\"" +", or " + "\"" + "4" + "\"" + ".");
            }
        }


        System.out.println("Now, it's time to embark on your journey. You are starting at Cleveland Circle, and you are trying to make your way to Gasson Hall.\n");

        String[] totalstates = {"Cleveland Circle", "Halfway to Resevoir", "Resevoir", "Halfway to Alumni Stadium", "Alumni Stadium", "Halfway to Schiller", "Schiller", "Halfway to Gasson", "Gasson"};

        Invoker voker = new Invoker(); 

        GameState currentstate = new BeginState();
        Journey journey; 

        for (String state : totalstates)
        {
            journey = new Journey(currentstate); 
            mc.setState(state); 

            if (currentstate instanceof EndState)
            {
                journey.presentGameState("Gasson"); 
                break; 
            }
            else if (currentstate instanceof TravelingState)
            {
                String input1 = currentstate.presentState(state); 
                if(input1.toUpperCase().equals("Y"))
                {
                    TravelIteration(keyboard, voker, mc, entityarr); 
                }
            }
            else if (currentstate instanceof LandmarkState)
            {
                String input1 = currentstate.presentState(state); 
                if (input1.toUpperCase().equals("Y"))
                {
                    LandmarkIteration(keyboard, voker, mc, entityarr, mc.getSupplies()); 
                }
            }
            depHealth(mc, entityarr); 
            mc.setSupplies(mc.depleteSupplies(mc.getSupplies(), 50)); 
            endGame(mc, entityarr);
            if (state.equals("Halfway to Gasson"))
            {
                currentstate = currentstate.changetoEndState(); 
            } 
            else
            {
                currentstate = currentstate.changeState(); 
            }
        }



    

    }
}