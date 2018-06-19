package com.ManifestKata.pokerkata;
import java.io.IOException;
import java.util.List;

public class PlayApp {

	public static void main(String[] args) throws IOException {

		List<PlayerBlack> gamesBlack = InputLoader.playerBlackStart();
		List<PlayerWhite> gamesWhite = InputLoader.playerWhiteStart();

		Report.reportPerLine(gamesBlack, gamesWhite);
	}

}
