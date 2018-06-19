package com.ManifestKata.pokerkata;
import java.util.ArrayList;
import java.util.List;

public abstract class PokerPlayer {

	protected List<Hand> hands = new ArrayList<>();

	public int getPairTieValue() {
		int x = 0;
		for (PokerRules hand : hands) {
			x = hand.checkValueForTieInPair();
		}
		return x;
	}

	public int get2PairTieValue() {
		int x = 0;
		for (PokerRules hand : hands) {
			x = hand.checkValueForTieInPair();
		}
		return x;
	}

	public int getThreeOfAKindTieValue() {
		int x = 0;
		for (PokerRules hand : hands) {
			x = hand.checkValueForTieInThreeOfAKind();
		}
		return x;
	}

	public int getFourOfAKindTieValue() {
		int x = 0;
		for (PokerRules hand : hands) {
			x = hand.checkValueForTieInFourOfAKind();
		}
		return x;
	}

	public boolean hasPair() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkFor2OfAKind()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean has2Pair() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkFor2Pairs()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean has3OfAKind() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkFor3OfAKind()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean has4OfAKind() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkFor4OfAKind()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasFullHouse() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkFullHouse()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasFlush() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkForFlush()) {
				x++;
			}
		}
		return x == 1;
	}

	public boolean hasStraight() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkForStraight()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasStraightFlush() {
		int x = 0;
		for (PokerRules hand : hands) {
			if (hand.checkForStraightFlush()) {
				x++;
			}
		}

		return x == 1;
	}

	public Card getHighCardInHand() {
		Card answer = null;
		for (PokerRules cards : hands) {
			answer = cards.getHighCard();

		}
		return answer;

	}

	public Card getNextHighestCardInHand() {
		Card answer = null;
		for (PokerRules cards : hands) {
			answer = cards.getNextHighestCard();

		}
		return answer;
	}

}
