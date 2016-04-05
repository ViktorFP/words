import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import by.epamlab.Constants;

public class Runner {
	public static void main(String[] args) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(Constants.FILE_PATH));
			String pattern = Constants.PATTERN;
			Map<String, Integer> words = new HashMap<>();
			while (scanner.hasNextLine()) {
				String[] nextWord = scanner.nextLine().split(pattern);
				for (String word : nextWord) {
					if (word.length() != 0) {
						word = word.toLowerCase();
						Integer count = words.get(word);
						words.put(word, (count == null) ? 1 : count + 1);
					}
				}
			}
//			words = new TreeMap<>(words);
//			for (Entry<String, Integer> wordData : words.entrySet()) {
//				System.out.println(wordData.getKey() + ": "
//						+ wordData.getValue());
//			}
		} catch (FileNotFoundException e) {
			System.out.println(Constants.FILE_EXCEPTION);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
