import java.util.Scanner; 
class TravelingState implements GameState{

    public String getState()
    {
        return "traveling";
    }

    public String presentState(String state)
    {
        Scanner scan = new Scanner(System.in);
        if(state.equals("Halfway to Resevoir"))
        {
            System.out.println("\nYou are now at the halfway point to the Resevoir. Would you like to explore your options? Press " +"\"" + "y" + "\""+ " if yes"); 
        }
        else if(state.equals("Halfway to Alumni Stadium"))
        {
            System.out.println("\nYou are now at the halfway point to Alumni Stadium. Would you like to explore your options?  Press " +"\"" + "y" + "\""+ " if yes"); 
        }
        else if(state.equals("Halfway to Schiller"))
        {
            System.out.println("\nYou are now at the halfway point to the Schiller Institute. Would you like to explore your options?  Press " +"\"" + "y" + "\""+ " if yes"); 
        }
        else if(state.equals("Halfway to Gasson"))
        {
            System.out.println("\nYou are now at the halfway point to Gasson Hall. Would you like to explore your options?  Press " +"\"" + "y" + "\""+ " if yes"); 
        }
        System.out.print("> "); 
        String output = scan.nextLine(); 
        return output;

    }

    public GameState changeState()
    {
        return new LandmarkState(); 
    }

    public GameState changetoEndState()
    {
        return new EndState(); 
    }

    



}
