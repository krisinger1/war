package org.risinger;

public class Deck {
	private Card[] deck;
	public boolean isShuffled=false;
	private int cardsUsed=0;
	
	Deck(){					// create regular 52 card deck
		deck=new Card[52];
		int numCards = 0;
		for (Suit s:Suit.values()){
			for (int v=2;v<=14;v++){
				deck[numCards]=new Card(s,v);
				numCards++;
			}
		}
		isShuffled=false;
	}
	
	public void printDeck(){
		for (Card c:deck){
			System.out.println(c.toString());
		}
	}
	
	public void shuffle(){  //shuffle the deck
		
		cardsUsed=0;
		recursiveShuffle(deck.length);
		isShuffled=true;
	}
	

	private void recursiveShuffle(int length){
		Card temp;
		
		if (length<2) return;
		else{
			//swap last and random card
			int randIndex=(int)(Math.random()*(length));
			temp = deck[length-1];
			deck[length-1]=deck[randIndex];
			deck[randIndex]=temp;
			recursiveShuffle(length-1);
			return;
		}
	}
	
	public Card dealCard(){
		if (cardsUsed==deck.length) throw new IllegalStateException("No cards left in deck.");
		else {
			cardsUsed++;
			//System.out.println(cardsUsed);
			return deck[cardsUsed-1];
		}
	}
}
