public class ViewMap implements Command{

    private MainChar mainchar; 
    private String state; 

    public ViewMap(MainChar mc)
    {
        mainchar = mc; 
        state = mc.getterState();  
    }

    public void execute()
    {
        mainchar.LookAtMap(state); 
    }
    
}
