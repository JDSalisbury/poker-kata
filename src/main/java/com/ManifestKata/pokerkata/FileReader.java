package com.ManifestKata.pokerkata;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

	public static List<PlayerBlack> readPlayerBlackFromInputFile(String fileName) {
		List<PlayerBlack> playerBlacksGames = new ArrayList<>();

		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String line = reader.readLine();

			while (line != null) {
				String[] setUp = line.split(" ");
				PlayerBlack black = setUpPlayerBlack(setUp);
				playerBlacksGames.add(black);

				line = reader.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return playerBlacksGames;
	}

	public static List<PlayerWhite> readPlayerWhiteFromInputFile(String fileName) {
		List<PlayerWhite> playerWhitesGames = new ArrayList<>();

		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String line = reader.readLine();

			while (line != null) {
				String[] setUp = line.split(" ");
				PlayerWhite white = setUpPlayerWhite(setUp);
				playerWhitesGames.add(white);

				line = reader.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return playerWhitesGames;
	}

	public static List<Hand> readPlayerBlacksCards(String fileName) {
		List<Hand> cards = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String line = reader.readLine();
			while (line != null) {
				String[] setUp = line.split(" ");
				Hand hand = setUpHandBlack(setUp);
				cards.add(hand);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cards;
	}

	public static List<Hand> readPlayerWhitesCards(String fileName) {
		List<Hand> cards = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String line = reader.readLine();
			while (line != null) {
				String[] setUp = line.split(" ");
				Hand hand = setUpHandWhite(setUp);
				cards.add(hand);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cards;
	}

	private static Hand setUpHandBlack(String[] meta) {
		Card card1 = new Card(meta[1].charAt(0), meta[1].charAt(1));
		Card card2 = new Card(meta[2].charAt(0), meta[2].charAt(1));
		Card card3 = new Card(meta[3].charAt(0), meta[3].charAt(1));
		Card card4 = new Card(meta[4].charAt(0), meta[4].charAt(1));
		Card card5 = new Card(meta[5].charAt(0), meta[5].charAt(1));
		return new Hand(card1, card2, card3, card4, card5);
	}

	private static Hand setUpHandWhite(String[] meta) {
		Card card1 = new Card(meta[8].charAt(0), meta[8].charAt(1));
		Card card2 = new Card(meta[9].charAt(0), meta[9].charAt(1));
		Card card3 = new Card(meta[10].charAt(0), meta[10].charAt(1));
		Card card4 = new Card(meta[11].charAt(0), meta[11].charAt(1));
		Card card5 = new Card(meta[12].charAt(0), meta[12].charAt(1));
		return new Hand(card1, card2, card3, card4, card5);
	}

	private static PlayerBlack setUpPlayerBlack(String[] meta) {
		String name = meta[0];
		return new PlayerBlack(name);
	}

	private static PlayerWhite setUpPlayerWhite(String[] meta) {
		String name = meta[7];
		return new PlayerWhite(name);
	}

	public static void addHandToPlayerBlack(List<PlayerBlack> games, List<Hand> hands, String fileName)
			throws IOException {
		Path pathToFile = Paths.get(fileName);
		List<String> linesInFile = Files.readAllLines(pathToFile);
		int indexLine = 0;

		for (PlayerBlack game : games) {
			for (Hand hand : hands) {
				if (linesInFile.get(indexLine).toString().contains(game.getName())
						&& linesInFile.get(indexLine).toString().contains(hand.toString())
						&& game.getHand().isEmpty()) {
					game.addHand(hand);
					if (indexLine < linesInFile.size() - 1)
						indexLine++;
				}

			}

		}

	}

	public static void addHandToPlayerWhite(List<PlayerWhite> games, List<Hand> hands, String fileName)
			throws IOException {
		Path pathToFile = Paths.get(fileName);
		List<String> linesInFile = Files.readAllLines(pathToFile);
		int indexLine = 0;

		for (PlayerWhite game : games) {
			for (Hand hand : hands) {
				if (linesInFile.get(indexLine).toString().contains(game.getName())
						&& linesInFile.get(indexLine).toString().contains(hand.toString())
						&& game.getHand().isEmpty()) {
					game.addHand(hand);
					if (indexLine < linesInFile.size() - 1)
						indexLine++;
				}

			}

		}

	}
}
