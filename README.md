# Hangman Game - Java
This is a classic **Hangman** game implemented in **Java** featuring multiple difficulty levels and prompts user to guess the word letter by letter, keeping track of guesses along with user and AI wins.
During my time at University, one of my first projects was to develop a Hangman game. I decided to recreate the game with a focus on simplicity, while applying **Object-Oriented Programming (OOP)** principles to ensure modularity, reusability, and clean code structure.

Features:
- Difficulty Levels - The game will prompt users to enter a difficulty level. There is easy (15 guesses), medium (10 guesses) and hard (8 guesses) each having its own file of words.
- Guesses - Users guess the word one at a time and each incorrect guess will decrement guess by 1. Guesses are stores in a Set with a capacity of 26. When a player makes a guess, it checks the Set in constant time O(1) and ensures no duplicate guesses.
- Input Validation - Ensures valid input such as when selecting a difficulty level, making guesses, etc. E.g. when asked to play again - accepts any input starting with 'y' or 'n'.
- Score Tracking - Tracks scores for both user and AI across game and displays the score at the end of the game.
- Play again - After finishing a round the user can choose to play again. It resets the game state by clearing the Set of guessed letters and the current word list.

Code Structure:
- App Class - The entry point of the program.
- Hangman Class- Contains the core logic of the game, such as selecting the word, processing guesses, and tracking scores.
- UserInterface Class - Manages the interaction with the user, such as displaying prompts, accepting input, and managing the game flow.

Game Flow:
- The user is prompted to select a difficulty level.
![image](https://github.com/user-attachments/assets/ae1cdae8-155b-4421-adab-31505f9656ae)

GamePlay:
- The user is show the state of the current word and is prompted to make a guess
![image](https://github.com/user-attachments/assets/e9d47575-37b0-4389-bffb-ca60d64f7e84)
- If the guess it correct - it show display correct guess or else incorrect guess.
- If the user makes the same guess, it will tell the user.

GameOver:
- If the player wins or runs out of guesses, the game ends and the word and scores are shown. The user is then asked whether they want to play again.
![image](https://github.com/user-attachments/assets/ed9582ae-7bf6-4207-a854-3d49a2684a84)

Future Improvements:
- Allowing the user to guess the entire word.
- Having a front-end interface to make the game more visually appealing and interactive.
