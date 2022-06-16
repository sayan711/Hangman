package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Round nextRound = new Round("20k.txt");
        System.out.println("Welcome to hangman!");
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);

       //While the user is in a new round and hasn't won or lost the round, the user will be asked to guess letters.
        while(playAgain) {
            while (!nextRound.hasLost() && !nextRound.hasWon()) {
                System.out.println(nextRound.getCurrentState());
                System.out.println("Guess a single letter of the alphabet.");
                String guess = scan.next();
                //If the user enters something that isn't a single letter it will print out the message.
                while (guess.length() != 1 || !"abcdefghijklmnopqrstuvwxyz".contains(guess)) {
                    System.out.println("Please pick a single letter of the alphabet.");
                    guess = scan.nextLine();
                }
                nextRound.userGuess(guess.charAt(0));
            }
            //If the user has won the round it prints out the message and reveals the word.
            if(nextRound.hasWon()) {
                System.out.println("Congratulations you won!");
                System.out.println("The word was " + nextRound.getTheWord());
            }
            scan.reset();
            //If the user has lost the round it prints out the message and reveals the word.
            if(nextRound.hasLost()){
                System.out.println(nextRound.getCurrentState());
                System.out.println("Game over you lose! The word was: " + nextRound.getTheWord());
            }
            nextRound = new Round("20k.txt");
            scan = new Scanner(System.in);
            String response = "";
            //After the round if the user enters something that isn't y or n, it repeats the question.
            while(!response.equals("y") && ! response.equals("n") ) {
                System.out.println("Do you want to play again (y/n)?");
                response = scan.nextLine();
            }
            //If the user enters y, a new round is started.
            playAgain = response.equals("y");
        }

    }
}

