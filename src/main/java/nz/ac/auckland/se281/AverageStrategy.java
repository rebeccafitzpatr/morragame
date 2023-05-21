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

    //calculate the ai output for sum, for this average strategy sum = fingers + players average
    aiSum = aiFingers + game.getPlayerAverage();
    int[] aiInputs = {aiFingers, aiSum};

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(aiFingers), String.valueOf(aiSum));
    return aiInputs;
    
  }

}