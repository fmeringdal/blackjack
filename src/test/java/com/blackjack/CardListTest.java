package com.blackjack;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

public class CardListTest
{  
    @Test
    public void shouldCreateCardListFromArray()
    {   
        CardList cardList = CardList.createFrom(new String[]{ "CA", "D5", "H9", "HQ", "S8" });
        assertEquals(cardList.size(), 5);
        assertEquals(cardList.pop().toString(), "CA");
    }


    @Test
    public void shouldCreateCardListFromFilepath() throws FileNotFoundException
    {   
        String filepath = System.getProperty("user.dir")+"/src/test/java/com/blackjack/data/cardlist.txt";
        CardList cardList = CardList.createFrom(filepath);
        assertEquals(cardList.size(), 5);
        assertEquals(cardList.pop().toString(), "CA");
    }
}
