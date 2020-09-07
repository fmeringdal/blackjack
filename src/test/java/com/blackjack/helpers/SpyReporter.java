package com.blackjack.helpers;

import java.util.List;

import com.blackjack.Player;
import com.blackjack.reporters.IReporter;

public class SpyReporter implements IReporter {

    public List<Player> players;
    public Player winner;


    @Override
    public void reportResult(List<Player> players, Player winner) {
        this.players = players;
        this.winner = winner;

    }

    @Override
    public void reportState(List<Player> players) {
        this.players = players;
    }
    
}
