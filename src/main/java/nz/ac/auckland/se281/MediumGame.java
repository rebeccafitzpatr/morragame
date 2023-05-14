package nz.ac.auckland.se281;

public class MediumGame extends GameMode {

  int counter;

  public int[] playStrategy() {
    if (counter < 3) {
      this.strategy = new RandomStrategy();
      return strategy.getAiInputs();
    }else {
      this.strategy = new AverageStrategy();

      return strategy.getAiInputs(game);
    }
  }




}
