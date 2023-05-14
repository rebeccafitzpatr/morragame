package nz.ac.auckland.se281;

public class Jarvis {

  private Strategy strategy;

  public Jarvis(Strategy strategy) {
    this.strategy = strategy;
}

  public int[] setDifficulty() {
    return strategy.decideBehaviour();
  }

  
}
