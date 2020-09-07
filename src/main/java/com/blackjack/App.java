package com.blackjack;

import java.io.FileNotFoundException;

import com.blackjack.reporters.TerminalReporter;




public class App 
{

    public static void main(String[] args) throws FileNotFoundException {
        
        CardList cardList = args.length == 1 ?
            CardList.createFrom(args[0]) :
            CardList.createRandomDeck(); 

        new Blackjack(cardList, new TerminalReporter()).start();
    }
}
