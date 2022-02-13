package com.techelevator;


import java.util.ArrayList;
import java.util.List;

public class WordList {

    public static List<String> words = new ArrayList<>();

    public WordList(){
        words.add("ESSAY");
        words.add("WITCH");
        words.add("SLANT");
        words.add("READY");
        words.add("DISCO");
        words.add("STATE");
        words.add("STRAP");
        words.add("ARISE");
        words.add("EXILE");
        words.add("SLAVE");
        words.add("TENSE");
        words.add("COACH");
        words.add("SPRAY");
        words.add("COLOR");
        words.add("MERCY");
        words.add("DRIFT");
        words.add("TITLE");
        words.add("LASER");
        words.add("QUOTE");
        words.add("FLASH");
        words.add("TRACT");
        words.add("BRAVE");
        words.add("BENCH");
        words.add("CROWN");
        words.add("DRILL");
        words.add("ADULT");
        words.add("THINK");
        words.add("PIECE");
        words.add("SLUMP");
        words.add("SKATE");
        words.add("MINER");
        words.add("CRACK");
        words.add("RIDER");
        words.add("SOUTH");
        words.add("HEAVY");
        words.add("SHAME");
        words.add("SPITE");
        words.add("VIRUS");
        words.add("MARCH");
        words.add("WOUND");
        words.add("FAITH");
        words.add("THICK");
        words.add("LEARN");
        words.add("URINE");
        words.add("FRAME");
        words.add("ENJOY");
        words.add("YEARN");
        words.add("SWARM");
        words.add("GLARE");
        words.add("QUOTA");
    }

    public String getWord(){
        return words.get((int) ((Math.random() * 50) - 1));
    }
    public static String createAnswerWord() {
        words.add("ESSAY");
        words.add("WITCH");
        words.add("SLANT");
        words.add("READY");
        words.add("DISCO");
        words.add("STATE");
        words.add("STRAP");
        words.add("ARISE");
        words.add("EXILE");
        words.add("SLAVE");
        words.add("TENSE");
        words.add("COACH");
        words.add("SPRAY");
        words.add("COLOR");
        words.add("MERCY");
        words.add("DRIFT");
        words.add("TITLE");
        words.add("LASER");
        words.add("QUOTE");
        words.add("FLASH");
        words.add("TRACT");
        words.add("BRAVE");
        words.add("BENCH");
        words.add("CROWN");
        words.add("DRILL");
        words.add("ADULT");
        words.add("THINK");
        words.add("PIECE");
        words.add("SLUMP");
        words.add("SKATE");
        words.add("MINER");
        words.add("CRACK");
        words.add("RIDER");
        words.add("SOUTH");
        words.add("HEAVY");
        words.add("SHAME");
        words.add("SPITE");
        words.add("VIRUS");
        words.add("MARCH");
        words.add("WOUND");
        words.add("FAITH");
        words.add("THICK");
        words.add("LEARN");
        words.add("URINE");
        words.add("FRAME");
        words.add("ENJOY");
        words.add("YEARN");
        words.add("SWARM");
        words.add("GLARE");
        words.add("QUOTA");
        return words.get((int) ((Math.random() * 50) - 1));

    }

}
