package com.ManifestKata.pokerkata;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Report {

	public static void reportPerLine(List<PlayerBlack> gamesBlack, List<PlayerWhite> gamesWhite) throws IOException {
		int locationInFile = 0;
		Path pathToFile = Paths.get("input.txt");
		List<String> linesInFile = Files.readAllLines(pathToFile);
		for (PlayerBlack name : gamesBlack) {
			for (PlayerWhite name2 : gamesWhite) {
				if (linesInFile.get(locationInFile).toString().contains(name.toString())
						&& linesInFile.get(locationInFile).toString().contains(name2.toString())) {
					CompareHands.whoWins(name, name2);
					if (locationInFile < linesInFile.size() - 1)
						locationInFile++;
				}

			}
		}
	}
}
