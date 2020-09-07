package com.blackjack.reporters;

import java.util.List;

import com.blackjack.Player;

public interface IReporter {
    void reportResult(List<Player> players, Player winner);
    void reportNewState(List<Player> players);
}

