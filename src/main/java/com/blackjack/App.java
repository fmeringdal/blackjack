package com.blackjack;

import java.io.FileNotFoundException;
import java.util.List;


class TerminalReporter implements IReporter {

    @Override
    public void reportResult(List<Player> players, Player winner) {
        System.out.println(winner.name);
        for(Player player: players){
            System.out.println(player.name+": "+player.hand);
        }
    }

    @Override
    public void reportState(List<Player> players) {
        
    }
}



public class App 
{

    public static void main(String[] args) throws FileNotFoundException {
        
        CardList cardList = args.length == 1 ?
            CardList.createFrom(args[0]) :
            CardList.createRandomDeck(); 

        new Blackjack(cardList, new TerminalReporter()).start();
    }
}
