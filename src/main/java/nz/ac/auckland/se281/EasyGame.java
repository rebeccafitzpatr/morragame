package nz.ac.auckland.se281;

public class EasyGame {
  Strategy strategy;
  int aiFingers;
  int aiSum;

  public EasyGame(){
    this.strategy = new RandomStrategy();
  }

  public int[] setDifficulty() {
    return strategy.decideBehaviour();
  }
}
