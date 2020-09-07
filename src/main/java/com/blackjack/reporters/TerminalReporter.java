package com.blackjack.reporters;

import java.util.List;

import com.blackjack.Player;

public class TerminalReporter implements IReporter {

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
