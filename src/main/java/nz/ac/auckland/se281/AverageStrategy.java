package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {


  private int aiFingers;
  private int aiSum;

  @Override
  public int[] getAiInputs() {
      throw new UnsupportedOperationException("Unimplemented method 'getAiInputs'");

} 

  @Override
  public int[] getAiInputs(Morra game) {
    aiFingers = Utils.getRandomNumber(1, 5);
    
    aiSum = game.getPlayerAverage();
    int[] aiInputs = {aiFingers, aiSum};
  
    return aiInputs;
    
  }

}