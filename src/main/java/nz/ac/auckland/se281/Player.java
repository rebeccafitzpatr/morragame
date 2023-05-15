package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Player {
  String playerName;
  int fingers;
  int sum;

  ArrayList<Integer> fingersRecord = new ArrayList<Integer>();

  int sumTotal = 0;

  public Player(String playerName) {
    this.playerName = playerName;
  }

  public Player(int fingers, int sum){
    
    this.fingers = fingers;
    this.sum = sum;
  }

  public int[] takePlayerInputs(Morra round) {
    
  boolean play = true;
    while (play) {
    String input = Utils.scanner.nextLine();

    int[] processedInt = convertStringtoIntArray(input);
    
    this.fingers = processedInt[0];
    this.sum = processedInt[1];

    if ((fingers >= 1) && (fingers <= 5)) { 
      if ((sum >= 1) && (sum <= 10)) {
      MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingers), String.valueOf(sum));
      play = false;
      } else{
        MessageCli.INVALID_INPUT.printMessage();
      }
    } else {
      MessageCli.INVALID_INPUT.printMessage();
    }

    }

    sumTotal = sumTotal + fingers;

    //record the players fingers
    fingersRecord.add(fingers);


    int[] playerInputs = {fingers,sum};
    

    return playerInputs;
  }

  public int[] fingersTally() {
    int i;
    int top;
    int oneFinger = 0;
    int twoFingers = 0;
    int threeFingers = 0;
    int fourFingers = 0;
    int fiveFingers = 0;
    int[] fingersTally = {oneFinger, twoFingers, threeFingers, fourFingers, fiveFingers};



    for (i = 0; i < fingersRecord.size(); i++) {

      switch(fingersRecord.get(i)){
        case 1:
          oneFinger++;

        case 2:
          twoFingers++;
        
        case 3:
          threeFingers++;

        case 4:
          fourFingers++;

        case 5:
          fiveFingers++;

      }
    }

    return fingersTally;
    
  }

  

  public int getSumTotal() {
    return sumTotal;
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
}

  
