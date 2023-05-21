package nz.ac.auckland.se281;

public class MediumGame extends GameMode {

  private int counter;

  public int[] playStrategy(Morra game) {

    counter = game.getRoundNumber();

    //use the random strategy up to round 3
    //from round 4 onwards use average strategy
    if (counter < 4) {
      this.strategy = new RandomStrategy();
      return strategy.getAiInputs();
    } else {
      this.strategy = new AverageStrategy();

      return strategy.getAiInputs(game);
    }
  }




}
