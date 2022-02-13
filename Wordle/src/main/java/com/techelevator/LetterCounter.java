package com.techelevator;

public class LetterCounter {


    public LetterCounter() {};

    public int countLetters(String fullWord, String letter){
        int counter = 0;
        for (int i = 0; i < fullWord.length(); i++) {
            if (fullWord.substring(i, i + 1).equals(letter)) {
                counter++;
            }
        }

        return counter;
    }


}
