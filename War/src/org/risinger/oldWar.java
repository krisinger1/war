package org.risinger;
import java.util.LinkedList;

public class oldWar {
	
	static Hand computerHand=new Hand();
	static Hand userHand=new Hand();
	static LinkedList<Card> cardsWon=new LinkedList<Card>();
	
	static void recursiveShuffle(Card[] deck, int length){
		Card temp;
		
		if (length<2) return;
		else{
			//swap last and random card
			System.out.println("length "+length);
			
			int randIndex=(int)(Math.random()*(length));
			System.out.println(randIndex);
			temp = deck[length-1];
			//temp.printCard();
			deck[length-1]=deck[randIndex];
			//deck[randIndex].printCard();
			//System.out.println();
			deck[randIndex]=temp;
			
			recursiveShuffle(deck,length-1);
			return;
		}
	}
	
	static void battle(Card c1, Card c2){
		int play = c1.compareTo(c2);
		if (play==1) {
			
			//userHand.pickUpCardsWon(userCard, computerCard);
			userHand.pickUpCardsWon(cardsWon);
			return;
			
			}
		else if (play==-1) {
			
			computerHand.pickUpCardsWon(cardsWon);
			return;
		}
		
		else //cards are equal - have a war
		{
			if (userHand.size()==0 || computerHand.size()==0) return;
			Card userCardDown=userHand.playCard();
			Card computerCardDown=computerHand.playCard();
			
			if (userHand.size()==0 || computerHand.size()==0) return;
			Card computerCardUp=computerHand.playCard();
			Card userCardUp=userHand.playCard();
			
			cardsWon.add(userCardDown);
			cardsWon.add(userCardUp);
			cardsWon.add(computerCardDown);
			cardsWon.add(computerCardUp);
			System.out.println("   "+userCardUp.toString()+" vs "+computerCardUp.toString()+"\n");
			battle(userCardUp, computerCardUp);
			return;
		}
	}
	
//	public static void main(String[] args) {
//		Deck myDeck = new Deck();
//
//		myDeck.printDeck();
//		System.out.println("\nafter shuffling...");
//		myDeck.shuffle();
//		myDeck.shuffle();
//		myDeck.printDeck();
//		System.out.println();
//			
//		//deal cards to computer
//		for (int i=0;i<26;i++){
//			computerHand.pickUpDealtCard(myDeck.dealCard());
//		}
//		
//		System.out.println("computerHand");
//		computerHand.printHand();
//		
//		//deal cards to user
//		for (int i=0;i<26;i++){
//			userHand.pickUpDealtCard(myDeck.dealCard());
//		}
//		
//		System.out.println("\nuserHand");
//		userHand.printHand();
//
//		// play!
//		
//		Card userCard, computerCard;
//		int play=0;
//		while (userHand.size()!=0 && computerHand.size()!=0)	{
//			userCard=userHand.playCard();
//			computerCard=computerHand.playCard();
//			play =userCard.compareTo(computerCard);
//			cardsWon.clear();
//			System.out.println(userCard.toString()+" vs "+computerCard.toString()+"\n");
//			// randomize order cards are picked up
//			if (Math.random()>.5){
//				cardsWon.add(userCard);
//				cardsWon.add(computerCard);
//			}
//			else {
//				cardsWon.add(computerCard);
//				cardsWon.add(userCard);
//			}
//			battle(userCard,computerCard);
//
//			//userHand.printHand();
//			
//		}
//		if (computerHand.size()==0) System.out.println("You win!");
//		else System.out.println("Computer wins");
//	}
}

