package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  public static GameMode setGameMode(Difficulty difficulty) {

    //this method makes each new game mode easy to add, because they extend from the abstract class
    switch (difficulty) {
      case EASY:
        return new EasyGame();

      case MEDIUM:
        return new MediumGame();

      case HARD:
        return new HardGame();

      case MASTER:
        return new MasterGame();

    }
    return null;

  }
}