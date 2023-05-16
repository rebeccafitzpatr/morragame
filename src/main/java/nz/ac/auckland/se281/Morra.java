package nz.ac.auckland.se281;



import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int roundNumber = 0;
  private Player player;
  private Jarvis jarvis;
  private int result;
  private int pointsToWin;

  private int playerAverage;


  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.roundNumber = 1;
    this.pointsToWin = pointsToWin;
    player = new Player(options[0]);
    jarvis = new Jarvis(difficulty);
    
  }

  public void play() {

    //first check that a new game has been started
    if (getRoundNumber() > 0) {
    String roundNumberString = convertIntToString(getRoundNumber());
    
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();
    
    //players moves
    int [] playerInputs = player.takePlayerInputs(this);

    //computer moves
    int[] aiMoves = jarvis.playGame(this);
  
      
    //update the total fingers played by user

    player.incrementTotalFingers();

    //decide the result

    this.result = decideResult(playerInputs, aiMoves);

    checkWinner();

    // increment the round number for each time the user starts a new round.
    incrementRoundNumber();

    } else {
      // if the round number is 0, then a new game has not started and the play command cannot be used
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
      
  }


  public void showStats() {

  }

  public void checkWinner() {
    if (jarvis.getNumOfWins() == pointsToWin) {
      

      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(roundNumber));
      this.roundNumber = 0;
      return;

    } else if (player.getNumOfWins() == pointsToWin) {

      MessageCli.END_GAME.printMessage(player.getPlayerName(), String.valueOf(roundNumber));
      this.roundNumber = 0;

      return;
    }
  }


  public int findMostCommonFingers() {
    int[] fingersTally = player.fingersTally();

    int most = fingersTally[0];
    int i;
    int index = 1;

    for (i = 0; i < fingersTally.length; i++) {
      if (fingersTally[i] > most) {
        most = fingersTally[i];
        index = i+1;
      }
    }

    return index;

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

  
  public void incrementRoundNumber() {
    this.roundNumber++;
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
      player.incrementNumOfWins();

      return 2;
    } else if (realSum == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvis.incrementNumOfWins();

      return 0;
    }else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

      return 1;
    }
  }
}

