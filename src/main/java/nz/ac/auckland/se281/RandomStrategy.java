package nz.ac.auckland.se281;

import java.util.Random;

public class RandomStrategy implements Strategy {


  private int aiFingers;
  private int aiSum;

  @Override
  public int[] decideBehaviour() {
    
    aiFingers = Utils.getRandomNumber(1, 5);
    
    System.out.println(aiFingers);
    aiSum = Utils.getRandomNumber((aiFingers +1), (aiFingers+5));

    int[] aiMoves = new int[] {aiFingers,aiSum};

    return aiMoves;
  }
  
}