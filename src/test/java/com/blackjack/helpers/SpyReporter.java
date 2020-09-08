package com.blackjack.helpers;

import com.blackjack.Player;
import com.blackjack.reporters.IReporter;

public class SpyReporter implements IReporter {

    public Player dealer;
    public Player player;
    public Player winner;


    @Override
    public void reportResult(Player dealer, Player player, Player winner) {
        this.player = player;
        this.dealer = dealer;
        this.winner = winner;
    }

    @Override
    public void reportNewState(Player dealer, Player player) {
        this.player = player;
        this.dealer = dealer;
    }
    
}
