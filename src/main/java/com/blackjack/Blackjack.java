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

    public void start(){
        // Initialize hands
        initializeHands();

        Player winner = checkForInitialBlackjack();
        if(winner != null){
            this.crownWinner(winner);
            return;
        }

        winner = checkForInitialFourAces();
        if(winner != null){
            this.crownWinner(winner);
            return;
        }
        
        // No winner from initial cards, time to start the roulette stage
        winner = this.startRoulette();
        this.crownWinner(winner);
    }

    private void initializeHands(){
        for(int i = 0; i < 4; i++){
            giveCardTo(i%2 == 0 ? player : dealer);
        }
    }

    // Roulette for player where the player gets a new card until score is between loopUntilScore and 21
    // If player gets a card that makes his / her hand have a score more than 21 they have lost
    private boolean startRouletteForPlayer(Player player, int loopUntilScore){
        while(player.score < loopUntilScore){
            // We dont have to check for empty deck before givecard to, because the total value of one of 
            // the players hand will be larger than 21 long before all the cards in the deck have been 
            // given out. (Because 2*22 is much smaller than the total value of the initial deck)
            giveCardTo(player);  
            if(player.score > 21){
                return false;
            }
        }
        return true;
    }

    private void giveCardTo(Player player){
        Card card = deck.pop();
        player.add(card);
    }

    private void crownWinner(Player winner){
        this.reporter.reportResult(dealer, player, winner);
    }

    private Player checkForInitialBlackjack(){
        if(hasBlackjack(player)){
            return player;
        } else if (hasBlackjack(dealer)){
            return dealer;
        }
        return null;
    }

    private Player checkForInitialFourAces(){
        int doubleAceScore = 22;
        return player.score == doubleAceScore && dealer.score == 22 ? dealer : null;
    }


    private Player startRoulette(){
        // Start roulette for player
        boolean validScore = startRouletteForPlayer(player, 17);
        if(!validScore){
            return dealer;
        }

        // Start roulette for dealer
        validScore = startRouletteForPlayer(dealer, player.score + 1);
        if(!validScore){
            return player;
        }

        // the previous check loops until dealer score is higher than
        // then player.score so we know that dealer has the highest score if we have
        // gotten this far.
        return dealer;
    }

    private static boolean hasBlackjack(Player player){
        return player.score == 21;
    }
}

