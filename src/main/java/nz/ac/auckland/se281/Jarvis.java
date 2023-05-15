package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Strategy strategy;
  private GameMode mode;

  

  public Jarvis(Difficulty difficulty) {
    mode = DifficultyFactory.setGameMode(difficulty);
  } 

  public int[] playGame(Morra game) {
      return mode.playStrategy(game);

  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  
  }

  
}
