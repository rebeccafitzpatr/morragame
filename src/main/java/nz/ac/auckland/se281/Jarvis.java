package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Strategy strategy;
  private GameMode mode;

  

  public Jarvis(Difficulty difficulty) {
    mode = DifficultyFactory.setGameMode(difficulty);
  } 

  public int[] playGame(Morra game) {
    if (mode instanceof EasyGame) {
      return mode.playStrategy(game);
    } else if (mode instanceof MediumGame) {
      return mode.playStrategy(game);
    } 

    return null;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  
  }

  
}
