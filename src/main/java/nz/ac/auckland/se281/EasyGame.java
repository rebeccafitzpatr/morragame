package nz.ac.auckland.se281;

public class EasyGame {
  Strategy strategy;

  public EasyGame(){
    this.strategy = new RandomStrategy();
  }
}
