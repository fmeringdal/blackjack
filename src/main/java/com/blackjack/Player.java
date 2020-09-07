package com.blackjack;

public class Player {
    public CardList hand;
    public String name;

    public Player(String name) {
        this.name = name;
        this.hand = CardList.createEmpty();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public int getScore() {
        return this.hand.value;
    }
}