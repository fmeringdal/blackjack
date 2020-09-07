package com.blackjack;

public class Player {
    public CardList hand = CardList.createEmpty();
    public int score = 0;
    public String name;

    public Player(String name) {
        this.name = name;
    }

    public void add(Card card) {
        this.hand.add(card);
        score += card.value;
    }
}