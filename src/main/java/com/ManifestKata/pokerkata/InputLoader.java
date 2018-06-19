package com.ManifestKata.pokerkata;
import java.io.IOException;
import java.util.List;

public class InputLoader {

	public static List<PlayerBlack> playerBlackStart() throws IOException {
		List<PlayerBlack> gamesBlack = FileReader.readPlayerBlackFromInputFile("input.txt");
		List<Hand> handsBlack = FileReader.readPlayerBlacksCards("input.txt");
		FileReader.addHandToPlayerBlack(gamesBlack, handsBlack, "input.txt");
		return gamesBlack;
	}

	public static List<PlayerWhite> playerWhiteStart() throws IOException {
		List<PlayerWhite> gamesWhite = FileReader.readPlayerWhiteFromInputFile("input.txt");
		List<Hand> handsWhite = FileReader.readPlayerWhitesCards("input.txt");
		FileReader.addHandToPlayerWhite(gamesWhite, handsWhite, "input.txt");
		return gamesWhite;
	}
}
