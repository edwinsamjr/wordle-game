package com.techelevator;

import java.util.*;
import static com.techelevator.WordList.createAnswerWord;


public class WordleApp {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        WordleApp application = new WordleApp();

        //Create Word List and pick an answer
        String correctWord = createAnswerWord();

        //Print introduction
        application.printIntroduction();

        //Sets initial conditions for hasWon and guessNumber
        boolean hasWon = false;
        int guessNumber = 1;

        /*Creates Map with letter as key and number of times it has been correctly
        guessed as the value --> So the app does not mistakenly print a star for a
        letter that is in the word one time and has already been correctly guessed*/
        Map<String, Integer> correctLetterCounter = new HashMap<>();

        while (guessNumber < 6 && hasWon == false) {
            String currentAnswerReveal = "";

            //Prompts user for guess and prints guess number
            System.out.print("Please enter guess #" + guessNumber + ": ");

            //Receive user's guess and convert it to uppercase
            String currentGuess = userInput.nextLine();
            String currentGuessCaps = currentGuess.toUpperCase();

            //Create counter to see how many times a letter is in the answer
            LetterCounter letterCounter = new LetterCounter();

            /*If the user guesses the correct word, set hasWon to true
            --> Skips the other code of the game and prints winning message*/
            if (currentGuessCaps.equals(correctWord)) {
                hasWon = true;
            } else {

                //For loop to iterate through each letter of the word
                for (int i = 0; i < 5; i++) {

                    //Helper variables for readability
                    String givenLetterGuess = currentGuessCaps.substring(i, i + 1);
                    String givenLetterAnswer = correctWord.substring(i, i + 1);
                    boolean hasLetterInAnswer = correctWord.contains(givenLetterGuess);
                    boolean isLetterInCorrectSpot = givenLetterGuess.equals(givenLetterAnswer);

                    /*booleans to reveal how many times the answer has the given letter
                    Sets hasLetterOnce to true if the letter is in the answer once
                    Sets hasLetterTwice to true if the letter is in the answer twice*/
                    boolean hasLetterOnce = false;
                    boolean hasLetterTwice = false;
                    int counter = letterCounter.countLetters(correctWord, givenLetterGuess);
                    if (counter == 2) {
                        hasLetterTwice = true;
                    } else if (counter == 1) {
                        hasLetterOnce = true;
                    }

                    //Adds letter to string if it is in the answer and in the correct spot
                    if (isLetterInCorrectSpot) {
                        currentAnswerReveal += givenLetterGuess + " ";

                        //Adds letter to Map with value 1
                        correctLetterCounter.put(givenLetterAnswer, 1);
                    } else if (hasLetterInAnswer && hasLetterOnce) {
                        //Prints a star if letter is in the answer once and has not been guessed correctly elsewhere
                        if (correctLetterCounter.get(givenLetterGuess) == null) {
                            currentAnswerReveal += "* ";
                        }
                        //Prints an underscore if letter is in the answer once has been correctly guessed elsewhere
                        else if (correctLetterCounter.get(givenLetterGuess) == 1) {
                            currentAnswerReveal += "_ ";

                        }

                    } else if (hasLetterInAnswer && hasLetterTwice) {
                        /*Prints star if given letter in the answer but in the incorrect spot
                         and letter is in the answer twice */
                        currentAnswerReveal += "*";
                    } else {
                        //Prints underscore if letter is not in answer
                        currentAnswerReveal += "_ ";
                    }
                }
                //Reveals guess with stars, underscores, and correct letters
                System.out.println(currentAnswerReveal);

                //Increments the guess number
                guessNumber++;
            }
        //End of do while loop
        }

        //Losing message after 5th incorrect guess
        if (guessNumber == 6) {
            System.out.println("");
            System.out.println("I'm sorry. You have lost the game.");
            System.out.println("The correct answer is " + correctWord + ".");
        }

        //Winning message
        if (hasWon == true) {
            System.out.println("");
            System.out.println("Congratulations! You have won the game!");
        }

    }

    // Print introduction
    public void printIntroduction() {
        System.out.println("-----------------Welcome to Wordle!-----------------");
        System.out.println("");
        System.out.println("----You will get FIVE guesses to find the answer----");
        System.out.println("");
        System.out.println("The correct word has five letters");
        System.out.println("[_] will print for each letter not in the word");
        System.out.println("[*] will print for a letter in the incorrect spot");
        System.out.println("A letter in the correct spot will print itself");
        System.out.println("");
        System.out.println("Good luck and may the odds be ever in your favor!");
        System.out.println("");
        System.out.println("");
    }


}



