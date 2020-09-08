package com.blackjack;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class CardTest 
{
    @Test
    public void shouldGiveCorrectScoreForCards()
    {
        Map<String, Integer> data = new HashMap<>();
        data.put("CA", 11);
        data.put("D4", 4);
        data.put("DK", 10);
        for(Entry<String, Integer> card: data.entrySet()){
            Card c = new Card(card.getKey());
            assertTrue(card.getValue() == c.value);
        }
    }
}
