package com.ManifestKata.pokerkata;
import java.util.List;

public class PlayerWhite extends PokerPlayer {
	private String name;

	public PlayerWhite(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hand> getHand() {
		return hands;
	}

	public void addHand(Hand hand) {
		hands.add(hand);
	}

	@Override
	public String toString() {
		return name + " " + getHand().toString().substring(1, getHand().toString().length() - 1);
	}

}
