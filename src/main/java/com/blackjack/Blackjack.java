package com.blackjack;

import com.blackjack.reporters.IReporter;


public class Blackjack {
    IReporter reporter;
    CardList deck;
    Player player;
    Player dealer;

    public Blackjack(CardList deck, IReporter reporter, String playerName){
        this.deck = deck;
        this.reporter = reporter;
        // Initialize player and dealer
        player = new Player(playerName);
        dealer = new Player("dealer");
    }

    private void initializeHands(){
        for(int i = 0; i < 4; i++){
            giveCardTo(i%2 == 0 ? player : dealer);
        }
    }


    private boolean giveCardUntilScorePasses(Player player, int maxScore){
        while(player.score < maxScore){
            giveCardTo(player);
            if(player.score > 21){
                return false;
            }
        }
        return true;
    }

    public void start(){
        // Initialize hands
        initializeHands();

        Player winner = checkForInitialBlackjack(player, dealer);
        if(winner != null){
            this.crownWinner(winner);
            return;
        }

        winner = checkForInitialFourAces(player, dealer);
        if(winner != null){
            this.crownWinner(winner);
            return;
        }
        
        boolean validScore = giveCardUntilScorePasses(player, 17);
        if(!validScore){
            this.crownWinner(dealer);
            return;
        }

        validScore = giveCardUntilScorePasses(dealer, player.score + 1);
        if(!validScore){
            this.crownWinner(player);
            return;
        }

        this.crownWinner(dealer);
    }

    private void giveCardTo(Player player){
        Card card = deck.pop();
        player.add(card);
    }

    private void crownWinner(Player winner){
        this.reporter.reportResult(dealer, player, winner);
    }

    private static Player checkForInitialBlackjack(Player player, Player dealer){
        if(hasBlackjack(player)){
            return player;
        } else if (hasBlackjack(dealer)){
            return dealer;
        }
        return null;
    }

    private static Player checkForInitialFourAces(Player player, Player dealer){
        int doubleAceScore = 22;
        return player.score == doubleAceScore && dealer.score == 22 ? dealer : null;
    }

    private static boolean hasBlackjack(Player player){
        return player.score == 21;
    }
}

