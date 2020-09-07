package com.blackjack;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.net.URL;

import com.blackjack.helpers.SpyReporter;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldFollowSpecExample()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "D5", "H9", "HQ", "S8" });
        SpyReporter spyReporter = new SpyReporter();
        new Blackjack(cardList, spyReporter).start();
        assertEquals(spyReporter.winner.name, "sam");
        assertEquals(spyReporter.winner.hand.toString(), "CA, H9");
    }


    @Test
    public void shouldFollowSpecExampleWithFile() throws FileNotFoundException
    {   

        URL url = getClass().getResource("cardlist.txt");
        CardList cardList = CardList.createFrom(url.getPath());
        SpyReporter spyReporter = new SpyReporter();
        new Blackjack(cardList, spyReporter).start();
        assertEquals(spyReporter.winner.name, "sam");
        assertEquals(spyReporter.winner.hand.toString(), "CA, H9");
    }
}
