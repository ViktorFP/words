package by.epamlab.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
	private Map<String, Integer> words;

	public Library() {
		words = new HashMap<>();
	}

	public static Library getInstance(String filePath, String delimiter)
			throws FileNotFoundException {
		Library library = new Library();
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNextLine()) {
			String[] nextWord = scanner.nextLine().split(delimiter);
			for (String word : nextWord) {
				if (word.length() != 0) {
					library.addWord(word);
				}
			}
		}
		return library;
	}

	public void addWord(String word) {
		word = word.toLowerCase();
		Integer count = words.get(word);
		words.put(word, (count == null) ? 1 : count + 1);
	}

	public Map<String, Integer> getDataLibrary() {
		return words;
	}

	public int search(String word) {
		Integer count = words.get(word);
		if (count != null) {
			return count;
		}
		return 0;
	}
}
