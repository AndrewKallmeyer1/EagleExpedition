import java.util.*; 
public class Invoker {

    private List<Command> commands = new ArrayList(); 
    
    public void addActivity(Command c)
    {
        commands.add(c);
    }

    public void removeActivity(Command c)
    {
        commands.remove(c);
    }

    public void performActivities()
    {
        for (Command c : commands)
        {
            c.execute(); 
        }
    }

    
    
}
