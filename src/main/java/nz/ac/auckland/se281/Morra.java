package nz.ac.auckland.se281;



import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int roundNumber = 0;
  private Player player;

  private Difficulty difficulty;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    this.difficulty = difficulty;

    player = new Player(options[0]);
    
  }

  public void play() {
    // increment the round number for each time the user starts a new round.
    roundNumber++;
    String roundNumberString = convertIntToString(roundNumber);
    
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();

    //players moves

    int [] playerInputs = player.takePlayerInputs(this);    

    //computer moves
    Jarvis jarvis = new Jarvis(difficulty);
    int[] aiMoves = jarvis.setDifficulty();

    //decide the result

    int result = decideResult(playerInputs, aiMoves);
      
  }


  public void showStats() {}

  public String convertIntToString(int number) {
    return String.valueOf(number);
  }

  public int[] convertStringtoIntArray(String string) {
    //first split the string by spaces

    String[] splitString = string.split(" ");
    
    //check that it has exactly two elements in it only
    //otherwise ask the user to try again

    while (splitString.length != 2) {
        MessageCli.INVALID_INPUT.printMessage();
        String input = Utils.scanner.nextLine();
        splitString = input.split("");
    } 

    //the first element of the split array should suit the restrictions for fingers sum
    int fingers = Integer.valueOf(splitString[0]);
    int sum = Integer.valueOf(splitString[1]);
    
    int[] output = new int[2];
    output[0] = fingers;
    output[1] = sum;

    return output;


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

