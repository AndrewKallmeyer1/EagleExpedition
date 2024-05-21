import java.util.List; 

public class CheckHealth implements Command{

    private MainChar mainchar; 
    private List<Entity> fammembers; 
    private float health; 


    public CheckHealth(MainChar mc, List<Entity> fms)
    {
        mainchar = mc; 
        health = mc.getHealth(); 
        fammembers = fms; 
    }

    public void execute()
    {
        System.out.println("Your health is " + mainchar.getHealth());
        for (int i = 0; i < fammembers.size(); i++)
        {
            if (fammembers.get(i).getDead() == false)
            {
                System.out.print(fammembers.get(i).getName() + "'s health is ");
                System.out.printf("%.2f \n", fammembers.get(i).getHealth());
            }
        }

    }
    
}