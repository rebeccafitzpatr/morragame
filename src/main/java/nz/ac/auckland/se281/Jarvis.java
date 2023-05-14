package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Strategy strategy;
  GameMode mode;

  

  public Jarvis(Difficulty difficulty) {
    mode = DifficultyFactory.setGameMode(difficulty);
  } 

  public int[] playStrategy() {
    return strategy.getAiInputs();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  
  }

  
}
