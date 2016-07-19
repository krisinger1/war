package org.risinger;

public enum Suit {
	CLUBS,DIAMONDS,HEARTS,SPADES;
	public String toString(){
		if (this==SPADES) return "spades";
		else if (this==CLUBS) return "clubs";
		else if (this==HEARTS) return"hearts";
		else if (this==DIAMONDS) return "diamonds";
		else return "not a suit";
	}
}
