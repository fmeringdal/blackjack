package com.blackjack;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldNotThrow()
    {
        assertTrue( true );
    }


    @Test
    public void shouldFollowSpecExample()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "D5", "H9", "HQ", "S8" });
        new Blackjack(cardList, new TerminalReporter()).start();
    }


    @Test
    public void shouldFollowSpecExampleWithFile() throws FileNotFoundException
    {   

        URL url = getClass().getResource("cardlist.txt");
        CardList cardList = CardList.createFrom(url.getPath());
        new Blackjack(cardList, new TerminalReporter()).start();
    }
}
