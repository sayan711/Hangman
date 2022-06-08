package com.company;

import java.util.HashMap;
import java.util.Map;

public class Round {
    int guessesSoFar;
    String theWord;
    String whichDictionary;
    Map<Integer, String> pictures = new HashMap<>();

    public Round(String whichDictionary) {
        this.whichDictionary = whichDictionary;
    }

    public int getGuessesSoFar() {
        return guessesSoFar;
    }

    public void setGuessesSoFar(int guessesSoFar) {
        this.guessesSoFar = guessesSoFar;
    }

    public String getTheWord() {
        return theWord;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public String getWhichDictionary() {
        return whichDictionary;
    }

    public void setWhichDictionary(String whichDictionary) {
        this.whichDictionary = whichDictionary;
    }
}
