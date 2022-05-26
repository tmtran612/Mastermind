//Name: Ted Tran

import java.util.Scanner; //import Scanner

public class Mastermind{
   private String possibleCharacters; //creates string possibleCharacters
   private String answer; //creates string answer

  //use keyword this to write the constructor
//pick a default list of possible Characters
   public  Mastermind(){
      this("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); //calls itself with default parameter "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
   }

   public Mastermind(String str){
   //assign input here 
      possibleCharacters = str; //assigns possibleCharacters to str
   }

//plays the easy version of the game with a limit on guesses
   public void play(String easy, int limit){
      answer = ""; //resets answer back to no characters
      String temp = "";
      for (int i = 0; i < 4; i++) {
         temp += possibleCharacters.charAt((int)(Math.random()*possibleCharacters.length())); //4 random characters from A-G
      }
      this.setAnswer(temp); //sets answer
      //System.out.println(answer);
      int count = 0; 
      Scanner input = new Scanner(System.in); // creates scanner object
      while (count < 4 && limit > 0) { //while loop only when they get it right or run out of guesses
         count = 0;
         System.out.println("Enter guess: ");
         
         String guess = input.nextLine(); //gets guess
         limit--; //subtracts one from guess
         String output = "";
         if (guess.length() >= 4) { //checks if guess is greater or equal than 4
            output = checkGuess(guess, false); //checks guess
            if (output.equals("$$$$")) { //if it's right then continue
               count = 4; //count is now 4
               System.out.println("Congratulations, you're right.");
               break; //break
            }
            System.out.println("You have " + limit + " guesses left.");
         } else {
            System.out.println("null"); //invalid input
         }
         System.out.println(output); //returns feedback
      }
   }

//plays the easy version of the game with no limit on guesses
   public void play(String easy){
      play(easy, Integer.MAX_VALUE); //plays on easy mode without a limit on guesses
   }

//plays the hard version of the game with a limit on guesses
   public void play(int limit){
      answer = ""; //resets ans
      String temp = "";
      for (int i = 0; i < 4; i++) {
         temp += possibleCharacters.charAt((int)(Math.random()*possibleCharacters.length())); //4 random characters from A-G
      }
      this.setAnswer(temp); //set answer
      //System.out.println(answer);
      int count = 0;
      Scanner input = new Scanner(System.in); //creates scanner object
      while (count < 4 && limit > 0) { //while loop only when they get it right or run out of guesses
         count = 0;
         System.out.println("Enter guess: ");
         String guess = input.nextLine(); //grabs guess
         limit--; //minuses one from guesses
         String output = "";
         if (guess.length() >= 4) { //checks if guess is greater or equal than 4
            output = checkGuess(guess, true); //checks guess
            if (output.equals("$$$$")) { //if it's right then continue
               count = 4; //count is now 4
               System.out.println("Congratulations, you're right.");
               break; //break
            }
            System.out.println("You have " + limit + " guesses left.");
         } else {
            System.out.println("null"); //invalid input
         }
         System.out.println(output); //returns feedback
      }
      
   }

//plays the hard version of the game with no limit on guesses
   public void play( ){
      play(Integer.MAX_VALUE); //plays hard mode without a limit on guesses
   }

// private methods for testing your code.

//Sets the answer to the given String
   private void setAnswer(String str){
      answer = str; //sets answer to str
   }

//Checks the answer against the input(str) and returns the appropriate feedback
//flag equals true indicates hard play, flag equals false indicates the easy play
//Check guess should return null if the String is the wrong length
   private String checkGuess(String str,boolean flag ){
      if (str.length() == 4) { //if string is equal to 4
         String output = "";
         for (int i = 0; i < 4; i++) { //for loop that loops 4 times
            if (str.substring(i,i+1).equals(answer.substring(i,i+1))) { //checks answer
               output += "$"; //right
            } else if (!flag) {
               output += "*"; //wrong
            }
         }
         return output; 
      }
     
      return null;
   }
   
//Determine expected output for tests
   public static void main(String[] args){
      Mastermind myGame = new Mastermind("ABCDEFG"); //creates object
      myGame.setAnswer("ACAD"); //sets answer
   
      System.out.println("Expected output: null -> " + myGame.checkGuess("ABCDEFG",true)); //test output
      System.out.println("Expected output: null -> " + myGame.checkGuess("AA",false)); //test output
      System.out.println("Expected output: $$ -> " + myGame.checkGuess("AAAA",true)); //test output
      System.out.println("Expected output: $*$* -> " + myGame.checkGuess("AAAA",false)); //test output
      System.out.println("Expected output: $ -> " + myGame.checkGuess("ABZZ",true)); //test output
      System.out.println("Expected output: $*** -> " + myGame.checkGuess("ABZZ",false)); //test output
      System.out.println("Expected output: $ -> " + myGame.checkGuess("CDAA",true)); //test output
      System.out.println("Expected output: **$* -> " + myGame.checkGuess("CDAA",false)); //test output
      System.out.println("Expected output: $$$$ -> " + myGame.checkGuess("ACAD",true)); //test output
      System.out.println("Expected output: $$$$ -> " + myGame.checkGuess("ACAD",false)); //test output
   
      myGame.play("easy"); //test output
      myGame.play("easy",1); //test output
      myGame.play(); //test output
      myGame.play(1); //test output
   }

}
