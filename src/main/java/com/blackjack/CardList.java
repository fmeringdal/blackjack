package com.blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardList {
    private LinkedList<Card> cardList;
    // value seems to be a better name than score
    public int value;

    private CardList(String[] cardList){
        this.cardList = Arrays.stream(cardList)
            .map(c -> new Card(c))
            .collect(Collectors.toCollection(LinkedList::new));
    }

    public static CardList createFrom(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        String[] cardList = scanner.nextLine().split(",");
        scanner.close();
        return new CardList(cardList);
    }

    public static CardList createFrom(String[] cardList){
        return new CardList(cardList);
    }

    public static CardList createRandomDeck() {
        Character[] suits = { 'C', 'D', 'H', 'S' };
        String[] values = { "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        String[] cardList = new String[suits.length * values.length];
        int counter = 0;
        for (Character suit : suits) {
            for (String value : values) {
                cardList[counter] = suit + value;
                counter += 1;
            }
        }
        return new CardList(cardList);
    }

    public static CardList createEmpty() {
        String[] cardList = {};
        return new CardList(cardList);
    }

    public Card pop(){
        return cardList.removeFirst();
    }

    public void add(Card card){
        this.cardList.add(card);
        value += card.score;
    }

    @Override
    public String toString() {
        return this.cardList.stream()
        .map(card -> card.toString())
        .collect(Collectors.joining(", "));
    }
}
