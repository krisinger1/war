package org.risinger;

import java.util.LinkedList;

public class Hand {
LinkedList<Card> hand;
	
	Hand(){
		hand = new LinkedList<Card>();
	}
	
	void pickUpDealtCard(Card c){
		hand.add(c);
	}
	
	Card playCard(){
		if (hand.size()!=0)
		return hand.remove();
		else return null;
	}
	

	void pickUpCardsWon(LinkedList<Card> list){
		hand.addAll(list);
	}
	
	void printHand(){
		for (Card c:hand){
			System.out.println(c.toString());
		}
	}
	
	int size(){
		return hand.size();
	}
	
}
