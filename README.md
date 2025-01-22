# Hangman Game - Java
This is a classic **Hangman** game implemented in **Java**. It features multiple difficulity and prompts the user to guess a word letter by letter, keeping track of guesses along with user and AI wins. It includes input validation and a smooth game flow.
During my time at University, one of my first projects was to develop a Hangman game. I decided to recreate the game with a focus on simplicity, while applying **Object-Oriented Programming (OOP)** principles to ensure modularity, reusability, and clean code structure.

Features
- Start the game - The game will prompt users to enter a difficulty level. There is easy (15 guesses), medium (10 guesses) and hard (8 guesses) each having its own file of words.
- Guesses - Users guess the word one at a time and each incorrect guess will decrement guess by 1. Guesses are stores in a Set with a capacity of 26 (number of letters in the English alphabet). When a player makes a guess, it checks the Set in constant time O(1).
- Input Validation - Ensures valid input when guessing and making choices. E.g. when asked to play again - accepts any input starting with 'y' or 'n'.
- Scores - Tracks scores for both user and AI across game.
- Play Again - When the user decides to play again, it will clear the Set of guessed letters along with the List that stores words. E.g. if the user decides to play easy mode, the list will store words from easy.txt however if the user decides to play again and chooses hard, it will clear the List and then store it from hard.txt.
