package com.ManifestKata.pokerkata;
public class CompareHands {
	protected static int playerBlacksHandValue = 0;
	protected static int playerWhitesHandValue = 0;
	protected static String bWinCon = "";
	protected static String wWinCon = "";

	public static void whoWins(PlayerBlack name, PlayerWhite name2) {

		playerBlackWinConsAndHandValues(name);
		playerWhiteWinConsAndHandValues(name2);

		decideVictor(name, name2);
	}

	public static void decideVictor(PlayerBlack name, PlayerWhite name2) {

		if (playerBlacksHandValue > playerWhitesHandValue) {
			System.out.println("Black wins. - with " + bWinCon);
		} else if (playerBlacksHandValue < playerWhitesHandValue) {
			System.out.println("White wins. - with " + wWinCon);
		} else if (playerBlacksHandValue == playerWhitesHandValue) {
			resolveTie(name, name2);

		}
	}

	private static void resolveTie(PlayerBlack name, PlayerWhite name2) {
		tieOnStraightFlush(name, name2);
		tieOnFourOfAKind(name, name2);
		tieOnFullHouse(name, name2);
		tieOnFlush(name, name2);
		tieOnStraight(name, name2);
		tieOnThreeOfAKind(name, name2);
		tieOn2Pair(name, name2);
		tieOnPair(name, name2);
		if (playerBlacksHandValue < 15 && playerWhitesHandValue < 15)
			nextHighestCard(name, name2);
	}

	private static void tieOnStraightFlush(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 22 && playerWhitesHandValue == 22) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieOnFourOfAKind(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 21 && playerWhitesHandValue == 21) {
			if (name.getFourOfAKindTieValue() > name2.getFourOfAKindTieValue()) {
				System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
						+ name.getFourOfAKindTieValue() + " high");
			} else if (name.getFourOfAKindTieValue() < name2.getFourOfAKindTieValue()) {
				System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
						+ name2.getFourOfAKindTieValue() + " high");
			} else if (name.getFourOfAKindTieValue() == name2.getFourOfAKindTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOnFullHouse(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 20 && playerWhitesHandValue == 20) {
			if (name.getThreeOfAKindTieValue() > name2.getThreeOfAKindTieValue()) {
				System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
						+ name.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() < name2.getThreeOfAKindTieValue()) {
				System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
						+ name2.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() == name2.getThreeOfAKindTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOnFlush(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 19 && playerWhitesHandValue == 19) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieOnStraight(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 18 && playerWhitesHandValue == 18) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieOnThreeOfAKind(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 17 && playerWhitesHandValue == 17) {
			if (name.getThreeOfAKindTieValue() > name2.getThreeOfAKindTieValue()) {
				System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
						+ name.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() < name2.getThreeOfAKindTieValue()) {
				System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
						+ name2.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() == name2.getThreeOfAKindTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOn2Pair(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 16 && playerWhitesHandValue == 16) {
			if (name.get2PairTieValue() > name2.get2PairTieValue()) {
				System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
						+ name.get2PairTieValue() + " high");
			} else if (name.get2PairTieValue() < name2.get2PairTieValue()) {
				System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
						+ name2.get2PairTieValue() + " high");
			} else if (name.get2PairTieValue() == name2.get2PairTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOnPair(PlayerBlack name, PlayerWhite name2) {
		if (playerBlacksHandValue == 15 && playerWhitesHandValue == 15) {
			if (name.getPairTieValue() > name2.getPairTieValue()) {
				System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
						+ name.getPairTieValue() + " high");
			} else if (name.getPairTieValue() < name2.getPairTieValue()) {
				System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
						+ name2.getPairTieValue() + " high");
			} else if (name.getPairTieValue() == name2.getPairTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieWithNothing(PlayerBlack name, PlayerWhite name2) {
		int playerBlackTieHandValue = 0;
		int playerWhiteTieHandValue = 0;
		playerBlackTieHandValue = name.getHighCardInHand().getValue();
		playerWhiteTieHandValue = name2.getHighCardInHand().getValue();
		if (playerBlackTieHandValue > playerWhiteTieHandValue) {
			System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
					+ name.getHighCardInHand() + " high");
		} else if (playerBlackTieHandValue < playerWhiteTieHandValue) {
			System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
					+ name2.getHighCardInHand() + " high");
		} else if (playerBlackTieHandValue == playerWhiteTieHandValue && playerBlackTieHandValue > 0
				&& playerWhiteTieHandValue > 0) {
			nextHighestCard(name, name2);

		}
	}

	private static void nextHighestCard(PlayerBlack name, PlayerWhite name2) {
		int playerBlackTieHandValue;
		int playerWhiteTieHandValue;
		playerBlackTieHandValue = name.getNextHighestCardInHand().getValue();
		playerWhiteTieHandValue = name2.getNextHighestCardInHand().getValue();
		if (playerBlackTieHandValue > playerWhiteTieHandValue) {
			System.out.println("Black Ties with White. - with " + bWinCon + " Black wins with "
					+ name.getNextHighestCardInHand() + " high");
		} else if (playerBlackTieHandValue < playerWhiteTieHandValue) {
			System.out.println("White Ties with Black. - with " + wWinCon + " White wins with "
					+ name2.getNextHighestCardInHand() + " high");
		} else if (playerBlackTieHandValue == playerWhiteTieHandValue) {
			System.out.println("Tie.");

		}
	}

	public static void playerBlackWinConsAndHandValues(PlayerBlack name) {
		if (name.hasStraightFlush()) {
			bWinCon = "StraightFlush!" + " " + name.getHighCardInHand() + " high";
			playerBlacksHandValue = 22;
		} else if (name.has4OfAKind()) {
			bWinCon = "Four of a Kind!";
			playerBlacksHandValue = 21;
		} else if (name.hasFullHouse()) {
			bWinCon = "Full House!";
			playerBlacksHandValue = 20;
		} else if (name.hasFlush()) {
			bWinCon = "Flush!" + " " + name.getHighCardInHand() + " high";
			playerBlacksHandValue = 19;
		} else if (name.hasStraight()) {
			bWinCon = "Straight!" + " " + name.getHighCardInHand() + " high";
			playerBlacksHandValue = 18;
		} else if (name.has3OfAKind()) {
			bWinCon = "Three of a Kind!";
			playerBlacksHandValue = 17;
		} else if (name.has2Pair()) {
			bWinCon = "2 Pairs!";
			playerBlacksHandValue = 16;
		} else if (name.hasPair()) {
			bWinCon = "Pair!";
			playerBlacksHandValue = 15;
		} else {
			bWinCon = name.getHighCardInHand() + " high";
			playerBlacksHandValue = name.getHighCardInHand().getValue();
		}
	}

	public static void playerWhiteWinConsAndHandValues(PlayerWhite name2) {
		if (name2.hasStraightFlush()) {
			wWinCon = "StraightFlush!" + " " + name2.getHighCardInHand() + " high";
			playerWhitesHandValue = 22;
		} else if (name2.has4OfAKind()) {
			wWinCon = "Four of a Kind!";
			playerWhitesHandValue = 21;
		} else if (name2.hasFullHouse()) {
			wWinCon = "Full House!";
			playerWhitesHandValue = 20;
		} else if (name2.hasFlush()) {
			wWinCon = "Flush!" + " " + name2.getHighCardInHand() + " high";
			playerWhitesHandValue = 19;
		} else if (name2.hasStraight()) {
			wWinCon = "Straight!" + " " + name2.getHighCardInHand() + " high";
			playerWhitesHandValue = 18;
		} else if (name2.has3OfAKind()) {
			wWinCon = "Three of a Kind!";
			playerWhitesHandValue = 17;
		} else if (name2.has2Pair()) {
			wWinCon = "2 Pairs!";
			playerWhitesHandValue = 16;
		} else if (name2.hasPair()) {
			wWinCon = "Pair!";
			playerWhitesHandValue = 15;
		} else {
			wWinCon = name2.getHighCardInHand() + " high";
			playerWhitesHandValue = name2.getHighCardInHand().getValue();
		}
	}
}
