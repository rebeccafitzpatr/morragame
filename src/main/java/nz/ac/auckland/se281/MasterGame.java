package nz.ac.auckland.se281;

public class MasterGame extends GameMode {
  

  private int counter;

  public int[] playStrategy(Morra game) {

    counter = game.getRoundNumber();

    // first three rounds user random strategy
    if (counter < 4) {
      this.strategy = new RandomStrategy();
      return strategy.getAiInputs();

      //now iterate between average and then top strategies

      //decide which strategy to use, based on if the counter is an even or odd value
    } else if (isEven(counter)) {
      this.strategy = new AverageStrategy();

      return strategy.getAiInputs(game);
    } else {
      this.strategy = new TopStrategy();
      return strategy.getAiInputs(game);
    }

    
  }

  public boolean isEven(int value) {
    
    //check if remainder is 0, then the value is even
    if ((value % 2) == 0) {
      return true;

    } else {
      return false;
    }
  }
}
