package nz.ac.auckland.se281;

public abstract class GameMode {

  protected Strategy strategy;
  protected int aiFingers;
  protected int aiSum;
  protected Morra game;

  public int[] playStrategy(Morra game) {
    return strategy.getAiInputs();
  }

}
