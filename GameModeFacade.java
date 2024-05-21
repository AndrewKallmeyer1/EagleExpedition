public class GameModeFacade {
    private GameMode easy; 
    private GameMode medium; 
    private GameMode hard; 

    public GameModeFacade()
    {
        easy = new EasyMode(); 
        medium = new MediumMode(); 
        hard = new HardMode();

    }

    public int EasyMoney()
    {
        return easy.getMoney(); 
    }

    public int MediumMoney()
    {
        return medium.getMoney(); 
    }

    public int HardMoney()
    {
        return hard.getMoney(); 
    }
}
