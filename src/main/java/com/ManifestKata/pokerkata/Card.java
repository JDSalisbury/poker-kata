package com.ManifestKata.pokerkata;

public class Card {

	private char suit;
	private char rank;

	public Card(char rank, char suit) {
		this.suit = suit;
		this.rank = rank;
	}

	public char getSuit() {
		return suit;
	}

	public char getRank() {
		return rank;
	}

	public int getValue() {
		int value = 0;
		if (rank == '2')
			value = 2;
		if (rank == '3')
			value = 3;
		if (rank == '4')
			value = 4;
		if (rank == '5')
			value = 5;
		if (rank == '6')
			value = 6;
		if (rank == '7')
			value = 7;
		if (rank == '8')
			value = 8;
		if (rank == '9')
			value = 9;
		if (rank == 'T')
			value = 10;
		if (rank == 'J')
			value = 11;
		if (rank == 'Q')
			value = 12;
		if (rank == 'K')
			value = 13;
		if (rank == 'A')
			value = 14;

		return value;
	}

	@Override
	public String toString() {
		String ranked = Character.toString(rank);
		String suited = Character.toString(suit);
		return ranked + suited;
	}

}
