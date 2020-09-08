package com.blackjack;

import static org.junit.Assert.assertEquals;

import com.blackjack.helpers.SpyReporter;

import org.junit.Test;

public class BlackjackTest 
{
    @Test
    public void shouldFollowSpecExample()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "D5", "H9", "HQ", "S8" });
        SpyReporter spyReporter = new SpyReporter();
        new Blackjack(cardList, spyReporter, "sam").start();
        assertEquals(spyReporter.winner.name, "sam");
        assertEquals(spyReporter.player.hand.toString(), "CA, H9");
        assertEquals(spyReporter.dealer.hand.toString(), "D5, HQ, S8");
    }


    @Test
    public void shouldMakeDealerWinWhenFourAces()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "DA", "HA", "SA", "S8" });
        SpyReporter spyReporter = new SpyReporter();
        new Blackjack(cardList, spyReporter, "sam").start();
        assertEquals(spyReporter.winner.name, "dealer");
    }


    @Test
    public void shouldMakeDealerWinWhenOnlyDealerStartsWithBlackjack()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "DA", "HA", "SK", "S8" });
        SpyReporter spyReporter = new SpyReporter();
        new Blackjack(cardList, spyReporter, "sam").start();
        assertEquals(spyReporter.winner.name, "dealer");
    }


    @Test
    public void shouldMakePlayerWinWhenBothStartsWithBlackjack()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "CK", "HA", "SK", "S8" });
        SpyReporter spyReporter = new SpyReporter();
        new Blackjack(cardList, spyReporter, "sam").start();
        assertEquals(spyReporter.winner.name, "sam");
    }
}
