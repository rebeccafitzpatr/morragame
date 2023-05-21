package nz.ac.auckland.se281;

public class HardGame extends GameMode {
  

  private int counter;

  public int[] playStrategy(Morra game) {

    counter = game.getRoundNumber();

    //use the random strategy up to round 3
    //from round 4 onwards use top strategy
    if (counter < 4) {
      this.strategy = new RandomStrategy();
      return strategy.getAiInputs();
    } else {
      this.strategy = new TopStrategy();

      return strategy.getAiInputs(game);
    }
  }

}
