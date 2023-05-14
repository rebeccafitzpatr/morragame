package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Strategy strategy;

  

public Jarvis(Difficulty difficulty) {
  GameMode mode = DifficultyFactory.setGameMode(difficulty);

  setStrategy(mode);
}

  public int[] setDifficulty() {
    return strategy.decideBehaviour();
  }

  public void setStrategy(GameMode mode) {
    this.strategy = mode.getStrategy();
  
  }

  
}
