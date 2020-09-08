package com.blackjack.reporters;

import com.blackjack.Player;

public class TerminalReporter implements IReporter {

    @Override
    public void reportResult(Player dealer, Player player, Player winner) {
        System.out.println(winner.name);
        displayPlayerResult(player);
        displayPlayerResult(dealer);
    }

    private void displayPlayerResult(Player player){
        System.out.println(player.name+": "+player.hand);
    }

    @Override
    public void reportNewState(Player dealer, Player player) {}
}
