package nz.ac.auckland.se281;

public class Player {
  String playerName;
  int fingers;
  int sum;

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

    int[] processedInt = round.convertStringtoIntArray(input);
    
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

    this.sumTotal = sumTotal +fingers;


    int[] playerInputs = {fingers,sum};
    

    return playerInputs;
  }

  public int getSumTotal() {
    return sumTotal;
  }
}

  
