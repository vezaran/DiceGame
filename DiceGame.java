import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.Scanner;

// Rules:
// 2 dice
// Roll both dice
// 7 doubles player money
// 11 breaks even
// 2 busted
// Any other number you lose your bet

public class DiceGame {
  
  static int bank = 500;
  static int bid;
  static double dice1;
  static double dice2;
  static int roll = (int)Math.floor(diceRoll());
  
  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    System.out.println("What would you like to bid? You currently have $" + bank + " in the bank.");
    bid = input.nextInt();
    if (bid > bank) {
      System.out.println("Sorry, you can't bid more than you have in the bank!");
      System.out.println("You currently have $" + bank + " in the bank.");
    } else {
      bank = bank - bid;
      game();
      System.out.println("You now have $" + bank + " in the bank.");
    }
//    System.out.println("Would you like to play again? Y/n");
//    if (input.next() == "Y") {
//      game();
//    } else if (input.next() == "y") {
//      game();
//    } else {
//      System.exit(0);
//    }
  }
  
  public static void game() {
    System.out.println("You rolled " + roll + ".");
    if (roll == 2) {
      bank = 0;
      System.out.println("You busted!");
    } else if (roll == 7) {
      bank = bank * 2;
      System.out.println("You doubled your bid!");
    } else if (roll == 11) {
      bank = bank + bid;
      System.out.println("You broke even!");
    } else {
      System.out.println("You lost your bid.");
    }
  }
  
  public static double diceRoll() {
    dice1 = Math.floor((Math.random() * 5) + 1);
    dice2 = Math.floor((Math.random() * 5) + 1);
    return Math.floor(dice1 + dice2);
  }
  

