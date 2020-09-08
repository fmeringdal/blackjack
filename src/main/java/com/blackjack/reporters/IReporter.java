package com.blackjack.reporters;

import com.blackjack.Player;

public interface IReporter {
    void reportResult(Player dealer, Player player, Player winner);
    void reportNewState(Player dealer, Player player);
}

