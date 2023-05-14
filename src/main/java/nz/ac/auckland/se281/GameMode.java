package nz.ac.auckland.se281;

public abstract class GameMode {

  protected Strategy strategy;
  protected int aiFingers;
  protected int aiSum;

  public GameMode() {};

  public int[] setDifficulty() {
    return strategy.decideBehaviour();
  }

  public Strategy getStrategy() {
    return this.strategy;
  }
}
