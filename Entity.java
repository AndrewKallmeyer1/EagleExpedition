import java.util.HashMap; 
import java.util.List; 
public interface Entity{


    public void setName(String n);

    public String getName(); 

    public float depleteHealth(float health); 

    public HashMap<String, Float> depleteSupplies(HashMap<String, Float> supplies, int distance); 

    public String getType(); 

    public void setHealth(float h); 

    public float getHealth(); 

    public float addedFood(float health, float food); 

    public float restSome(float health, float days); 

    public void remove(List<Entity> ea, int index); 

    public void setDead(boolean d);

    public boolean getDead(); 


    }
    

