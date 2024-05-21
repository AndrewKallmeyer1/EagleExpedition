import java.util.*; 
import java.util.HashMap; 

public class FamilyMember implements Entity{

    private String name; 
    private float health; 
    private float days; 
    private List<Entity> entityarr; 
    private int ind; 
    private boolean dead; 

    public void setName(String n)
    {
        name = n; 
    }

    public String getName()
    {
        return name; 
    }

    public void setHealth(float h)
    {
        health = h; 
    }

    public float getHealth()
    {
        return health; 
    }

    public String getType()
    {
        return "family member"; 
    }

    public void setDead(boolean d)
    {
        dead = d; 
    }

    public boolean getDead()
    {
        return dead; 
    }

    public float depleteHealth(float health)
    {
        return (float)(health - 20); 
    }

    public HashMap<String, Float> depleteSupplies(HashMap<String, Float> supplies, int distance)
    {
        Set<String> setofKeys = supplies.keySet(); 
        for (String supplytype : setofKeys)
        {
            float temp = supplies.get(supplytype);
            temp = temp/(distance); 
            supplies.put(supplytype, temp); 
        }

        return supplies; 
    }

    public float addedFood(float health, float food)
    {
        health = health + food/10; 
        return health; 
    }

    public float restSome(float health, float days)
    {
        health = health + (days*2); 
        return health; 
    }

    public void remove(List<Entity> ea, int index)
    {
        entityarr = ea; 
        ind = index; 
        entityarr.remove(ind); 
    }



}
