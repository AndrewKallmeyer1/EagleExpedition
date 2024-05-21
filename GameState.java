public interface GameState {
    String getState(); 
    GameState changeState(); 
    String presentState(String state); 
    GameState changetoEndState(); 

}
