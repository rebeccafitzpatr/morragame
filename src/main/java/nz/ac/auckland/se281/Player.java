package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Player {
  private String playerName;
  private int fingers;
  private int sum;
  private int numOfWins;


  private ArrayList<Integer> fingersRecord = new ArrayList<Integer>();

  private int sumTotal = 0;

  public Player(String playerName) {
    this.playerName = playerName;
  }

  public Player(int fingers, int sum) {
    this.fingers = fingers;
    this.sum = sum;
  }

  public int[] takePlayerInputs(Morra round) {
    int[] playerInputs = new int[2];
    
    boolean play = true;

    //keep iterating until a successful input is made by the user
    while (play) {

      //scan the users input, then try convert it to integer(check that it was valid)
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();

      int[] processedInt = convertStringtoIntArray(input);
      
      //only continue if it is valid, other wise send an error and redo the loop
      if (processedInt != null) {
  
        this.fingers = processedInt[0];
        this.sum = processedInt[1];
        
        // check that the input is within the valid range
        if ((fingers >= 1) && (fingers <= 5)) { 
          if ((sum >= 1) && (sum <= 10)) {
            MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingers), String.valueOf(sum));
            play = false;

          } else {
            MessageCli.INVALID_INPUT.printMessage();
          }
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      
        //record the players fingers
        fingersRecord.add(fingers);


        playerInputs[0] = fingers;
        playerInputs[1] = sum;
    

    
      } else {
        play = true;
      }
    }
    return playerInputs;
  }

  public void incrementTotalFingers() {
    sumTotal = sumTotal + fingers;
  }

  public int[] fingersTally() {
    int i;
    int oneFinger = 0;
    int twoFingers = 0;
    int threeFingers = 0;
    int fourFingers = 0;
    int fiveFingers = 0;
    



    for (i = 0; i < fingersRecord.size(); i++) {
      // for each input that is recorded from the user, increment its corresponding element
      //to get a record of how many time that number of fingers has been inputted
      int value = fingersRecord.get(i);
      if (value == 1) {
        oneFinger++;
      } else if (value == 2) {
        twoFingers++;
      } else if (value == 3) { 
        threeFingers++;
      } else if (value == 4) {
        fourFingers++;
      } else if (value == 5) {
        fiveFingers++;

      }
    }
    //combine these to a array
    int[] fingersTally = {oneFinger, twoFingers, threeFingers, fourFingers, fiveFingers};

    return fingersTally;
    
  }


  public String getPlayerName() {
    return playerName;
  }
  

  public int getSumTotal() {
    return sumTotal;
  }

  public int[] convertStringtoIntArray(String string) {
    //first split the string by spaces

    String[] splitString = string.split(" ");
    
    //check that it has exactly two elements in it only
    //otherwise ask the user to try again

    if (splitString.length != 2) {
      MessageCli.INVALID_INPUT.printMessage();
      return null;
    }

    //check that the inputs are really integers
    if (Utils.isInteger(String.valueOf(splitString[0])) && Utils.isInteger(String.valueOf(splitString[1]))) {
      // if they are valid, save it to the variables, and return it to the morra class
      int fingers = Integer.valueOf(splitString[0]);
      int sum = Integer.valueOf(splitString[1]);
      
      int[] output = new int[2];
      output[0] = fingers;
      output[1] = sum;

      return output;
      //otherwise they need to be dealt with by asking for a new input from user
    } else {
      MessageCli.INVALID_INPUT.printMessage();
      return null;
      
    }


  }

  public void incrementNumOfWins() {
    this.numOfWins++;
  }

  public int getNumOfWins() {
    return numOfWins;
  }
}

  
