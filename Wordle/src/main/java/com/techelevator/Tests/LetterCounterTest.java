package com.techelevator.Tests;

import com.techelevator.LetterCounter;
import org.junit.Assert;
import org.junit.Test;


public class LetterCounterTest {

    @Test
    public void tests_number_of_g_in_engineering() {
        LetterCounter letterCounter = new LetterCounter();
        int result = letterCounter.countLetters("engineering", "g");
        Assert.assertEquals("Count was incorrect", 2, result);
    }

}
