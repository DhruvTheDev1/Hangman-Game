import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
  private int playerWins; // player wins
  private int aiWins; // computer wins
  private int chances; // total chances depending on difficulty
  private Set<Character> guessedLetters; // guesses
  List<String> wordList; // words that will be read from file
  private String currentWord; // the word being guessed
  private StringBuilder currentWordState; // // e.g., "h_llo"

  public Hangman() {
    this.playerWins = 0;
    this.aiWins = 0;
    this.guessedLetters = new HashSet<>(26);
    this.wordList = new ArrayList<>();
  }

  // difficulty mode and chances according to level
  public void readWord(int difficultyChoice) {
    File file = null;
    wordList.clear(); // if playing again, clears word list

    try {
      if (difficultyChoice == 1) { // easy
        file = new File("easy.txt");
        this.chances = 15; // 15 chances
      } else if (difficultyChoice == 2) {
        file = new File("medium.txt");
        this.chances = 10;
      } else if (difficultyChoice == 3) {
        file = new File("hard.txt");
        this.chances = 8;
      }
      // read all words from file and add to list
      Scanner reader = new Scanner(file);
      while (reader.hasNextLine()) {
        String word = reader.nextLine();
        wordList.add(word);
      }
      reader.close();
      // generate random word
      Random random = new Random();
      this.currentWord = wordList.get(random.nextInt(wordList.size()));
      this.currentWordState = new StringBuilder("_".repeat(currentWord.length()));

    } catch (Exception e) {
      System.out.println("Error" + e.getMessage());
    }
  }

  // checks user guess
  public boolean makeGuess(char guess) {
    if (!alreadyGuessed(guess)) {
      guessedLetters.add(guess);
    }
    boolean correctGuess = false;

    for (int i = 0; i < currentWord.length(); i++) {
      if (currentWord.charAt(i) == guess) {
        currentWordState.setCharAt(i, guess);
        correctGuess = true;
      }
    }

    if (!correctGuess) {
      this.chances -= 1;
    }

    return correctGuess;
  }

  public boolean alreadyGuessed(char guess) {
    return this.guessedLetters.contains(guess);
  }

  public Set<Character> getGuessedLetters() {
    return this.guessedLetters;
}

  public boolean wordGuessed() { // entire word guessed
    return currentWordState.toString().equals(currentWord);
  }

  public boolean isGameOver() { // chances == 0 OR word guessed
    return chances == 0 || wordGuessed();

  }

  public String getWordState() { // current state of word
    return currentWordState.toString();
  }

  public int getChances() { // remaining guesses
    return this.chances;
  }

  public String getWord() { // word being guessed (not hidden)
    return currentWord;
  }

  public void incrementPlayerWins() {
    this.playerWins++;
  }

  public void incrementAIWins() {
    this.aiWins++;
  }

  public int getPlayerWins() {
    return this.playerWins;
  }

  public int getAIWins() {
    return this.aiWins;
  }

}
