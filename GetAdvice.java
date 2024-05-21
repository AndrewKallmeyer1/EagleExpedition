public class GetAdvice implements Command{

    private MainChar mainchar; 

    public GetAdvice(MainChar mc)
    {
        mainchar = mc; 
    }

    public void execute()
    {
        mainchar.getAdvice(); 
    }
    
}
