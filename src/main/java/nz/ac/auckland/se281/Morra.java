package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int roundNumber = 0;
  private String playerName;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
  }

  public void play() {
    // increment the round number for each time the user starts a new round.
    roundNumber++;
    String roundNumberString = convertIntToString(roundNumber);
    
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();
    
    while (true) {
    String input = Utils.scanner.nextLine();

    int[] processedInt = convertStringtoIntArray(input);
    
    int fingers = processedInt[0];
    System.out.println(fingers);
    int sum = processedInt[1];
    System.out.println(sum);

    if ((fingers >= 1) && (fingers <= 5)) { 
      if ((sum >= 1) && (sum <= 10)) {
      MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingers), String.valueOf(sum));
      break;
      }
    } else {
      MessageCli.INVALID_INPUT.printMessage();
    }



      
  }

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
    } 

    //the first element of the split array should suit the restrictions for fingers sum
    int fingers = Integer.valueOf(splitString[0]);
    int sum = Integer.valueOf(splitString[1]);
    
    int[] output = new int[2];
    output[0] = fingers;
    output[1] = sum;

    return output;


  }
}
