import java.util.HashMap; 
import java.util.List; 
import java.util.Set; 

public class BuySupplies implements Command{

    private MainChar mainchar; 
    private List<Entity> e; 
    private HashMap<String, Float> hm; 


    public BuySupplies(MainChar mc, List<Entity> ent, HashMap<String, Float> map)
    {
        e = ent; 
        mainchar = mc; 
        hm = map; 
    }

    public void ex1()
    {
        System.out.println("Your current balance: " + mainchar.getBalance());
        float budget = mainchar.getBalance(); 

        HashMap<String,Float> nhm = new HashMap<String, Float>(mainchar.buySupplies(hm, budget)); 

        HashMap<String, Float> fhm = new HashMap<String, Float>(); 

        Set<String> setofKeys = hm.keySet(); 
        for (String supplytype : setofKeys)
        {
            fhm.put(supplytype, (float)hm.get(supplytype)+(float)nhm.get(supplytype)); 
        }

        mainchar.setSupplies(fhm); 
    
        System.out.println("\nYour new balance: " + mainchar.getBalance());

        float health = mainchar.getHealth(); 

        if (nhm.get("Food") > 0)
        {
            float temp = nhm.get("Food");
            mainchar.setHealth(mainchar.addedFood(health, temp));
            System.out.println("Your current health is now " + mainchar.getHealth()); 
            for (int i = 0; i < e.size(); i ++)
            {
                if (e.get(i).getDead() == false)
                {
                    e.get(i).setHealth(e.get(i).addedFood(e.get(i).getHealth(), temp)); 
                    System.out.println(e.get(i).getName() + "'s health is now " + e.get(i).getHealth()); 
                }   
            }   
        }
    
    }

    public void execute()
    {
        ex1();    
    }
    
}
