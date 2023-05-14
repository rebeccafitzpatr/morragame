package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {


  private int aiFingers;
  private int aiSum;

  @Override
  public int[] getAiInputs() {
    
    aiFingers = Utils.getRandomNumber(1, 5);
    
    aiSum = Utils.getRandomNumber((aiFingers +1), (aiFingers+5));

    int[] aiMoves = new int[] {aiFingers,aiSum};

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(aiFingers), String.valueOf(aiSum));

    return aiMoves;
  }

  @Override
  public int[] getAiInputs(Morra game) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAiInputs'");
  }
  
}