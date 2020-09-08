package com.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest
{  
    @Test
    public void shouldGiveCorrectScoreForPlayerHand()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "D5", "H9", "HQ", "S8" });
        Player p = new Player("sam");
        assertEquals(p.score, 0);
        
        for(Card c: cardList){
            int oldScore = p.score;
            p.add(c);
            assertEquals(p.score, c.value+oldScore);
        }
    }
}
