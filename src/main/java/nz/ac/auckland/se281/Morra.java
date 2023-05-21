package nz.ac.auckland.se281;



import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int roundNumber = -1;
  private Player player;
  private Jarvis jarvis;
  private int pointsToWin;

  private int playerAverage;


  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.roundNumber = 0;
    this.pointsToWin = pointsToWin;
    player = new Player(options[0]);
    jarvis = new Jarvis(difficulty);
    
  }

  public void play() {

    //first check that a new game has been started
    if (getRoundNumber() >= 0 ) {
       // increment the round number for each time the user starts a new round.
      incrementRoundNumber();
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

      decideResult(playerInputs, aiMoves);

      
      checkWinner();
    

    } else {
      // if the round number is 0, then a new game has not started and the play command cannot be used
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
      
  }


  public void showStats() {

    //first check that a game is in play

    if (roundNumber > 0) {
      //calculate the required extra wins to finish the game
      String playerWinsNeeded = String.valueOf(pointsToWin - player.getNumOfWins());
      String jarvisWinsNeeded = String.valueOf(pointsToWin - jarvis.getNumOfWins());
      String playerName = player.getPlayerName();
      String playerNumOfWins = String.valueOf(player.getNumOfWins());
      String jarvisNumOfWins = String.valueOf(jarvis.getNumOfWins());

      MessageCli.PRINT_PLAYER_WINS.printMessage(playerName, playerNumOfWins, playerWinsNeeded);
      MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis",jarvisNumOfWins, jarvisWinsNeeded);

    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void checkWinner() {
    //check if either jarvis or player have reached the required number of wins

    //if so end the game

    if (jarvis.getNumOfWins() == pointsToWin) {
      
      
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(roundNumber));
      this.roundNumber = -1;
      return;

    } else if (player.getNumOfWins() == pointsToWin) {

      MessageCli.END_GAME.printMessage(player.getPlayerName(), String.valueOf(roundNumber));
      this.roundNumber = -1;

      return;
    }
  }


  public int findMostCommonFingers() {
    int[] fingersTally = player.fingersTally();

    int most = fingersTally[0];
    int i;
    int index = 1;

    //find the number of fingers that has had the most inputs
    //start with the first number being the most, then record any next number that is larger

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

  public int getPlayerAverage() {
    int sumTotal = player.getSumTotal();
    double divisor = roundNumber-1;

    //use double type, in order to calculate correct decimal

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

  public void decideResult(int[] humanInput, int[] aiMoves) {
    int fingers = humanInput[0];
    int aiFingers = aiMoves[0];
    int sum = humanInput[1];
    int aiSum = aiMoves[1];

    int realSum = fingers + aiFingers;

    //check whether the play or jarvis has guessed the correct number or not.

    // if they have the same guess, then they draw
    if ((realSum == aiSum) && (realSum == sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return;

      //if either player or jarvis guess the the correct sum, then they win
    } else if (realSum == sum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      player.incrementNumOfWins();

      return;

    } else if (realSum == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvis.incrementNumOfWins();

      return;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

      return;
    }
  }
}

