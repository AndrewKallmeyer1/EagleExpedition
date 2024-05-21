class Journey {

    private GameState state; 

    public Journey(GameState state)
    {
        this.state = state; 
    }

    public void presentGameState(String s)
    {
        state.presentState(s); 
    }

    public GameState changeGameState()
    {
        return state.changeState(); 
    }

    public String getState()
    {
        return state.getState(); 
    }

    
}
