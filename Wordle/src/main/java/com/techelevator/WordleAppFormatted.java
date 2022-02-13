package com.techelevator;

import java.util.*;
import static com.techelevator.WordList.createAnswerWord;


public class WordleAppFormatted {
    private static List<String> wordList = new ArrayList<>();

    private static Scanner userInput = new Scanner(System.in);


    public static void main(String[] args) {

        WordleAppFormatted application = new WordleAppFormatted();


        //Create Word List and pick an answer
        String correctWord = createAnswerWord();


        //Print introduction
        application.printIntroduction();

        //Play game
        boolean hasWon = false;
        int guessNumber = 1;
        Map<String, Integer> correctLetterCounter = new HashMap<>();
        while (guessNumber < 6 && hasWon == false) {
            String currentAnswerReveal = "";
            System.out.print("Please enter guess #" + guessNumber + ": ");
            String currentGuess = userInput.nextLine();

            String currentGuessCaps = currentGuess.toUpperCase();
            LetterCounter letterCounter = new LetterCounter();



            //If the user guesses the correct word, set hasWon to true;
            if (currentGuessCaps.equals(correctWord)) {
                hasWon = true;
            } else {


                for (int i = 0; i < 5; i++) {

                    boolean hasLetterOnce = false;
                    boolean hasLetterTwice = false;

                    String givenLetterGuess = currentGuessCaps.substring(i, i + 1);
                    String givenLetterAnswer = correctWord.substring(i, i + 1);
                    int counter = letterCounter.countLetters(correctWord, givenLetterGuess);

                    if (counter == 2) {
                        hasLetterTwice = true;
                    } else if (counter == 1) {
                        hasLetterOnce = true;
                    }

                    if (givenLetterGuess.equals(givenLetterAnswer)) {
                        //Print correct letter
                        currentAnswerReveal += givenLetterAnswer + " ";

                        //Add letter to Map with value 1
                        correctLetterCounter.put(givenLetterAnswer, 1);
                    } else if ((correctWord.contains(givenLetterGuess)) && hasLetterOnce) {
                        //If letter hasn't been guessed correctly elsewhere, print a star
                        if (correctLetterCounter.get(givenLetterGuess) == null) {
                            currentAnswerReveal += "* ";
                        }
                        //If letter has been correctly, guessed elsewhere, print an underscore
                        else if (correctLetterCounter.get(givenLetterGuess) == 1) {
                            currentAnswerReveal += "_ ";

                        }
                    } else if ((correctWord.contains(givenLetterGuess)) && hasLetterTwice) {
                        currentAnswerReveal += "*";
                    } else {
                        currentAnswerReveal += "_ ";
                    }
                }
                System.out.println(currentAnswerReveal);
                guessNumber++;
            }
        }

        if (guessNumber == 6) {
            System.out.println("I'm sorry. You have lost the game");
            System.out.println("The correct answer is " + correctWord);
        }

        if (hasWon == true) {
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



