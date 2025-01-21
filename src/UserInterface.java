import java.util.Scanner;

public class UserInterface {
  private Scanner scanner;
  private Hangman hangman;

  public UserInterface(Scanner scanner) {
    this.scanner = scanner;
    this.hangman = new Hangman();
  }

  public void start() {
    while (true) {
      System.out.println("WELCOME TO HANGMAN");
      System.out.println("");

      System.out.println("Rules ");
      System.out.println("An incorrect letter guess will cost 1 guess");
      System.out.println("");

      System.out.println("Please select a difficulty level");
      System.out.println("1. Easy - 15 chances");
      System.out.println("2. Medium - 10 chances");
      System.out.println("3. Hard - 8 chances");

      int userChoice = scanner.nextInt();
      scanner.nextLine();

      if (userChoice == 1) {
        System.out.println("Welcome to Easy mode");

      } else if (userChoice == 2) {
        System.out.println("Welcome to Medium mode");

      } else if (userChoice == 3) {
        System.out.println("Welcome to hard mode");

      } else {
        System.out.println("Please enter a valid input");
        continue; 
      }
      System.out.println("");


      hangman.readWord(userChoice);
      playGame();

      System.out.println("Do you want to play again? (yes/no)");
      String playAgain = scanner.nextLine().toLowerCase();
      if (playAgain.equals("no")) {
        System.out.println("Goodbye!");
        break;
      }
    }
  }

  private void playGame() {
    while (!hangman.isGameOver()) {
      System.out.println(hangman.getWordState());
      System.out.println("Guesses: " + hangman.getChances());
      System.out.println("Enter your guess: ");

      String input = scanner.nextLine();

      if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
        System.out.println("Invalid input");
        continue;
      }

      char guess = input.charAt(0);

      if (hangman.alreadyGuessed(guess)) {
        System.out.println("You already guessed the letter");
        continue;
      }

    if (hangman.makeGuess(guess)) {
      System.out.println("Correct guess");
    } else {
      System.out.println("Incorrect guess");
    }

    if (hangman.wordGuessed()) {
      System.out.println("Congratulations! You win! The word was: " + hangman.getWord());
      hangman.incrementPlayerWins();
      break;  
  } else if (hangman.getChances() == 0) {
      System.out.println("Game Over! You lose. The word was: " + hangman.getWord());
      hangman.incrementAIWins();
      break;  
  }
    }

    System.out.println("Scores: ");
    System.out.println("Player Wins: " + hangman.getPlayerWins());
    System.out.println("AI Wins: " + hangman.getAIWins());
  }

}
