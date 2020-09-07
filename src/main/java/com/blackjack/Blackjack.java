package com.blackjack;

import java.util.ArrayList;
import java.util.List;

interface IReporter {
    void reportResult(List<Player> players, Player winner);
    void reportState(List<Player> players);
}


public class Blackjack {
    IReporter reporter;
    CardList deck;
    List<Player> players;

    public Blackjack(CardList cardList, IReporter reporter){
        // init deps
        this.reporter = reporter;
        deck = cardList;
        this.players = new ArrayList<>();
    }

    public void start(){

        // Create players and give them some cards
        Player sam = new Player("sam");
        Player dealer = new Player("dealer");
        this.players.add(sam);
        this.players.add(dealer);


        for(int i = 0; i < 4; i++){
            giveCardTo(i%2 == 0 ? sam : dealer);
        }

        // Check if we have a winner after initial cards
        if(sam.getScore() == 21){
            this.crownWinner(sam);
            return;
        } else if (dealer.getScore() == 21){
            this.crownWinner(dealer);
            return;
        }
        
        if(dealer.getScore() == 22 && sam.getScore() == 22){
            this.crownWinner(dealer);
            return;
        }

        // Some while logic
        while(sam.getScore() < 17){
            giveCardTo(sam);
            if(sam.getScore() > 21){
                this.crownWinner(dealer);
                return;
            }
        }

        // Some while logic
        while(dealer.getScore() <= sam.getScore()){
            giveCardTo(dealer);
            if(dealer.getScore() > 21){
                this.crownWinner(sam);
                return;
            }
        }

        this.crownWinner(dealer);

    }

    private void giveCardTo(Player player){
        Card card = deck.pop();
        player.add(card);
    }

    private void crownWinner(Player winner){
        this.reporter.reportResult(this.players, winner);
    }
}

