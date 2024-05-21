public class ContinueOnTrail implements Command{

    private MainChar mainchar; 


    public ContinueOnTrail(MainChar mc)
    {
        mainchar = mc; 
    }

    public void execute()
    {
        mainchar.ContinueTrail(); 
    }
    
}
