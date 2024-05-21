import java.util.HashMap; 

public class CheckSupplies implements Command{

    private MainChar mainchar; 
    private HashMap<String, Float> hm; 


    public CheckSupplies(MainChar mc)
    {
        hm = mc.getSupplies(); 
        mainchar = mc; 
    }

    public void execute()
    {
        mainchar.checkSupplies(hm); 
    }
    
}
