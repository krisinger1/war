package org.risinger;

import java.util.LinkedList;

import javax.swing.ImageIcon;

public class GameRunner {
	Deck deck;
	Hand hand1,hand2;
	Card card1InPlay,card2InPlay;
	LinkedList<Card> cardsWon= new LinkedList<Card>();

	public GameRunner(){
		deck=new Deck();
		deck.shuffle();
		hand1=new Hand();
		hand2=new Hand();

		// deal cards out
		for (int i=0;i<26;i++){
			hand1.pickUpDealtCard(deck.dealCard());
			hand2.pickUpDealtCard(deck.dealCard());
		}


	}

	public LinkedList<ImageIcon> playCard(){
		
		LinkedList<ImageIcon> playedCardsIcons = new LinkedList<ImageIcon>();
		card1InPlay=hand1.playCard();
		if (card1InPlay==null) return null;
		playedCardsIcons.add(card1InPlay.getImageIcon());
		card2InPlay=hand2.playCard();
		if (card1InPlay==null) return null;
		playedCardsIcons.add(card2InPlay.getImageIcon());
		return playedCardsIcons;
	}


	public void battle(){
		int play = card1InPlay.compareTo(card2InPlay);
		
		if (Math.random()>.5){
			cardsWon.add(card1InPlay);
			cardsWon.add(card2InPlay);
		}
		else{
			cardsWon.add(card2InPlay);
			cardsWon.add(card1InPlay);
		}
		System.out.println("battle: "+card1InPlay+" "+card2InPlay);
		if (play==1){

			hand1.pickUpCardsWon(cardsWon);
			cardsWon.clear();
			return;
		}
		else if(play==-1){

			hand2.pickUpCardsWon(cardsWon);
			cardsWon.clear();
			return;
		}
		else {
			cardsWon.add(hand1.playCard());
			cardsWon.add(hand2.playCard());
			card1InPlay=hand1.playCard();
			card2InPlay=hand2.playCard();
			System.out.println("war: "+card1InPlay+" "+card2InPlay);
			battle();
			return;
		}
		//cardsWon.clear();
	}
	
	public int[] handSizes(){
		int[] sizes=new int[2];
		sizes[0]=hand1.size();
		sizes[1]=hand2.size();
		return sizes;
		}
}
