package com.blackjack;

import java.util.ArrayList;

class Card {
    public int score;
    private String representation;
    public Card(String representation){
        this.representation = representation;
        this.score = getScoreOf(representation);
    }

    private static Integer getScoreOf(String representation){
        ArrayList<Character> chars = new ArrayList<>();
        chars.add('J');
        chars.add('Q');
        chars.add('K');
        Character cardValue = representation.charAt(1);
        if(cardValue == 'A'){
            return 11;
        } else if (chars.contains(cardValue)){
            return 10;
        }
        int cardNumber = Integer.parseInt(representation.substring(1));
        return cardNumber;
    }


    @Override
    public String toString() {
        return representation;
    }
}
