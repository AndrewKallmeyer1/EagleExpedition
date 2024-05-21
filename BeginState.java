
public class BeginState implements GameState{

    public String getState()
    {
        return "landmark";
    }

    public String presentState(String state)
    {
        System.out.println("Here you are at the beginning of your journey, Cleveland Circle. The smell of smoke is in the air as you wait 20 minutes to cross the 6 lane intersection. You feel a sense of excitement as you look into the distance and see the tips of Gasson Hall beyond the smog. With all your supplies purchased from Baldwin's shop and a good slice from Pino's in your stomach, you and your pals are ready to start on your journey.\n");
        return ""; 

    }

    public GameState changeState()
    {
        return new TravelingState(); 
    }
    public GameState changetoEndState()
    {
        return new EndState(); 
    }

    public String presentTravelState(String s)
    {
        return "";
    }

 
    
}