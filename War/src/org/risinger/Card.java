package org.risinger;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card implements Comparable<Card>{
	private final Suit cardSuit;
	private final int cardValue;
	private String image;
	public int frame;


	public Card(Suit s, int v){
		int row=0;
		if (s!=Suit.SPADES && s!=Suit.CLUBS && s!=Suit.HEARTS && s!=Suit.DIAMONDS) throw new IllegalArgumentException("Illegal card suit");
		else cardSuit=s;
		if (v>=1 ||v<=13) cardValue=v;
		else throw new IllegalArgumentException("Illegal playing card value");
		switch (s){
		case SPADES:
			row=1;
			image="images/aclubs.png";
			break;
		case CLUBS:
			row=0;
			image="images/"+v+"clubs.png";
			break;
		case DIAMONDS:
			row=3;
			image="images/aclubs.png";

			break;
		case HEARTS:
			row=2;
			image="images/aclubs.png";

			break;
		default:
			break;
		}
		frame=(13*row)+v-1;
		//image="images/2clubs.png";
	}

	public int getValue(){
		return cardValue;
	}

	public Suit getSuit(){
		return cardSuit;
	}

	public String getValueAsString(){
		switch (cardValue) {
		case 1: return "Ace";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		case 14: return "Ace";
		default: return "Not a Valid Value";
		}
	}

	public String getSuitAsString(){
		return cardSuit.toString();
	}

	public String toString(){
		return getValueAsString() + " of "+getSuitAsString();
		}

	public int compareTo(Card c){
		if (cardValue>c.cardValue) return 1;		//my card is bigger
		else if (cardValue<c.cardValue) return -1;	//my card is smaller
		else return 0;								//cards are equal
	}

	public void printCard(){
		System.out.println(toString());
	}

	public void displayCard(JLabel label){
		label.setIcon(new ImageIcon(image));
		label.setVisible(true);
	}

   public void setImage(String image){
	   this.image=image;
   }

   public String getImage(){
	   return image;
   }

   public ImageIcon getImageIcon(){
	   return new ImageIcon(image);
   }

} // end class Card