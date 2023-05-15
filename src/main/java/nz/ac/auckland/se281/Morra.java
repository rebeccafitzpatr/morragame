package nz.ac.auckland.se281;



import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int roundNumber;
  private Player player;
  private Jarvis jarvis;

  private int playerAverage;


  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    roundNumber = 1;
    player = new Player(options[0]);
    jarvis = new Jarvis(difficulty);
    
  }

  public void play() {
    String roundNumberString = convertIntToString(roundNumber);
    
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();

    //computer moves
    int[] aiMoves = jarvis.playGame(this);
    
    //players moves
    int [] playerInputs = player.takePlayerInputs(this);
    //decide the result

    int result = decideResult(playerInputs, aiMoves);

    // increment the round number for each time the user starts a new round.
    roundNumber++;
      
  }


  public void showStats() {}


  public int findMostCommonFingers() {
    int[] fingersTally = player.fingersTally();

    int most = fingersTally[0];
    int i;

    for (i = 0; i < fingersTally.length; i++) {
      if (fingersTally[i] > most) {
        most = fingersTally[i];
      }
    }

    return most;

  }

  public String convertIntToString(int number) {
    return String.valueOf(number);
  }

  public int getPlayerAverage(){
    int sumTotal = player.getSumTotal();
    double divisor = roundNumber-1;

    double average = (sumTotal/divisor);
    playerAverage = (int) Math.round(average);
    System.out.println(playerAverage);
    return playerAverage;
  }

  public int getRoundNumber() {
    return roundNumber;
  }

  public int decideResult(int[] humanInput, int[] aiMoves) {
    int fingers = humanInput[0];
    int aiFingers = aiMoves[0];
    int sum = humanInput[1];
    int aiSum = aiMoves[1];

    int realSum = fingers + aiFingers;

    if ((realSum == aiSum) && (realSum == sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return 1;

    } else if (realSum == sum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");

      return 2;
    } else if (realSum == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");

      return 0;
    }else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

      return 1;
    }
  }
}

