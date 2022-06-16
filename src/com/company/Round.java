package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Round {
    int failedGuessesSoFar;
    List<Character> charsGuessedSoFar = new ArrayList<>();
    String theWord;
    String whichDictionary;
    List<String> pictures = new ArrayList<>();
    private boolean lostFlag;
    private boolean wonFlag;

    //Sets up the round of hangman.
    public Round(String whichDictionary) {
        this.whichDictionary = whichDictionary;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(whichDictionary));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        Random rand = new Random();
        theWord = words.get(rand.nextInt(words.size()));
        lostFlag = false;
        wonFlag = false;
        setupImages();
    }

    //This function returns true if the game is over, false if not.
    public boolean hasWon() {
        return this.wonFlag;
    }

    public boolean hasLost() {
        return this.lostFlag;
    }

    //It adds the users guess to either the word or adds the guess to the amount of wrong guesses.
    public void userGuess(char c) {
        charsGuessedSoFar.add(c);
        if(!theWord.contains(String.valueOf(c))) {
            failedGuessesSoFar++;
        }
        //Check to see if the user has won or lost, and update.
        wonFlag = true;
        for(char ch : theWord.toCharArray()) {
            if (!charsGuessedSoFar.contains(ch)) {
                wonFlag = false;
            }
        }
        if (failedGuessesSoFar >= pictures.size() -1 ){
            lostFlag = true;
        }
    }

    //Gets a graphic representing the current state of the game -- that is, the "hanged" man.
    public String getCurrentState() {
        String result = "";
        for(Character c : theWord.toCharArray()) {
            if(charsGuessedSoFar.contains(c)) {
                result += c;
            } else {
                result += "_";
            }
            result += " ";
        }
        return result + "\n" + pictures.get(failedGuessesSoFar);
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

    //The actual hanged man graphics that will print out as the user makes a wrong guess.
    private void setupImages() {
        pictures.add(0, "  +---+\n"
        + "  |   \n"
        + "      \n"
        + "      \n"
        + "      \n"
        + "=========");
        pictures.add(1,
                "  +---+\n"
                + "  |   \n"
                + "  o   \n"
                + "      \n"
                + "      \n"
                + "=========");
        pictures.add(2,
                "  +---+\n"
                        + "  |   \n"
                        + "  o   \n"
                        + "  |   \n"
                        + "      \n"
                        + "=========");
        pictures.add(3,
                "  +---+\n"
                        + "  |   \n"
                        + "  o   \n"
                        + " /|   \n"
                        + "      \n"
                        + "=========");
        pictures.add(4,
                "  +---+\n"
                        + "  |   \n"
                        + "  o   \n"
                        + " /|\\ \n"
                        + "      \n"
                        + "=========");
        pictures.add(5,
                "  +---+\n"
                        + "  |   \n"
                        + "  o   \n"
                        + " /|\\ \n"
                        + " /    \n"
                        + "=========");
        pictures.add(6,
                "  +---+\n"
                        + "  |   |\n"
                        + "  o   |\n"
                        + " /|\\ |\n"
                        + " / \\ |\n"
                        + "=========");

    }
}
