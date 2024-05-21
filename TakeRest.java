import java.util.List; 
public class TakeRest implements Command{

    private MainChar mainchar; 
    private float days; 
    private float health; 
    private List<Entity> ent;

    public TakeRest(MainChar mc, List<Entity> ea)
    {
        mainchar = mc;
        ent = ea; 
        health = mc.getHealth(); 
        days = mc.getDays(); 

    }

    public void execute()
    {
        mainchar.setHealth(mainchar.restSome(health, days)); 
        for (int i = 0; i < ent.size(); i ++)
        {
            if(ent.get(i).getDead() == false)
            {
                ent.get(i).setHealth(ent.get(i).restSome(ent.get(i).getHealth(), days)); 
                System.out.println(ent.get(i).getName() + " rested for " + days + " days, their health has increased by " + (days*2));
            }
        }
            
    }
}
