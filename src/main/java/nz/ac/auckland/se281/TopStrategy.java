package nz.ac.auckland.se281;

public class TopStrategy implements Strategy{

  private int aiFingers;
  private int aiSum;

  @Override
  public int[] getAiInputs() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAiInputs'");
  }

  @Override
  public int[] getAiInputs(Morra game) {
    aiFingers = Utils.getRandomNumber(1, 5);

    int top = game.findMostCommonFingers();
    
    aiSum = aiFingers + top;
    int[] aiInputs = {aiFingers, aiSum};

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(aiFingers), String.valueOf(aiSum));
    return aiInputs;
  }
  
}
