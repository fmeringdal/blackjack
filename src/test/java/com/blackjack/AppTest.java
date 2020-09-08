package com.blackjack;

import java.io.FileNotFoundException;

import org.junit.Test;


/*
 * A couple of dummy integration tests to validate that things arent crashing 
 */
public class AppTest 
{
    
    @Test
    public void shouldRunWithoutCrashing() throws FileNotFoundException
    {
        App.main(new String[]{});
    }


    @Test
    public void shouldRunWithoutCrashingWhenReadingFromFile() throws FileNotFoundException
    {
        String filepath = System.getProperty("user.dir")+"/src/test/java/com/blackjack/data/cardlist.txt";
        App.main(new String[]{ filepath });
    }
}
