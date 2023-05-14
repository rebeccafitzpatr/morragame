package nz.ac.auckland.se281;

public class MediumGame extends GameMode {

  int counter;

  public MediumGame() {
    if (counter < 3) {
      this.strategy = new RandomStrategy();
    }else {
      this.strategy = new AverageStrategy();
    }
  }




}
