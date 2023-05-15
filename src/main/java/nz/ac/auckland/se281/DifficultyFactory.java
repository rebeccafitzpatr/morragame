package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  public static GameMode setGameMode(Difficulty difficulty) {
    switch(difficulty) {
      case EASY:
        return new EasyGame();

      case MEDIUM:
        return new MediumGame();

      case HARD:
        return new HardGame();

    }
    return null;

  }
}