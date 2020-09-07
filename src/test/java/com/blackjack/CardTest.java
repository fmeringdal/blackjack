package com.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest 
{
    @Test
    public void shouldGiveCorrectScoreForCards()
    {
        Card c = new Card("CA");
        assertEquals(c.score, 11);
    }
}
