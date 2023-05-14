package nz.ac.auckland.se281;

public class MediumGame extends GameMode {

  int counter;

  public int[] playStrategy(Morra game) {

    counter = game.getRoundNumber();
    if (counter < 4) {
      this.strategy = new RandomStrategy();
      return strategy.getAiInputs();
    }else {
      this.strategy = new AverageStrategy();

      return strategy.getAiInputs(game);
    }
  }




}
