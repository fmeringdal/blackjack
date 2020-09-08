package com.blackjack;

import java.io.FileNotFoundException;

import com.blackjack.reporters.TerminalReporter;




public class App 
{

    public static void main(String[] args) throws FileNotFoundException {
        
        // If filename is provided as an arg then use it, otherwise create a random shuffled deck
        CardList deck = args.length == 1 ?
            CardList.createFrom(args[0]) :
            CardList.createRandomDeck(); 

        new Blackjack(deck, new TerminalReporter(), "sam").start();
    }
}
