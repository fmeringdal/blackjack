package com.blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.blackjack.utils.Utils;

public class CardList implements Iterable<Card> {
    private LinkedList<Card> cardList;

    private CardList(String[] cardList) {
        this.cardList = Arrays.stream(cardList).map(Card::new).collect(Collectors.toCollection(LinkedList::new));
    }

    public static CardList createFrom(String filepath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filepath));
        String[] cardList = scanner.nextLine().split(",");
        scanner.close();
        return new CardList(cardList);
    }

    public static CardList createFrom(String[] cardList) {
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
        Utils.shuffle(cardList);
        return new CardList(cardList);
    }

    public static CardList createEmpty() {
        String[] cardList = {};
        return new CardList(cardList);
    }

    public Card pop() {
        return cardList.removeFirst();
    }

    public void add(Card card) {
        cardList.add(card);
    }

    public int size() {
        return cardList.size();
    }

    @Override
    public String toString() {
        return cardList.stream().map(card -> card.toString()).collect(Collectors.joining(", "));
    }

    @Override
    public Iterator<Card> iterator() {
        return this.cardList.iterator();
    }
}
