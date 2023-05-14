package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {


  private int aiFingers;
  private int aiSum;


  public AverageStrategy() {
  }


  @Override
  public int[] getAiInputs() {
    
    aiFingers = Utils.getRandomNumber(1, 5);
    

    int[] aiInputs = {aiFingers};
  
    return aiInputs;
  
}

}