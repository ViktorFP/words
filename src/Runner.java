import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import by.epamlab.Constants;
import by.epamlab.beans.Library;

public class Runner {
	public static void main(String[] args) {
		BufferedReader br = null;
		Library library = null;
		// ---reading data---
		try {
			library = Library.getInstance(Constants.FILE_PATH,
					Constants.PATTERN);
			// ---search data---
			String str = "";
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(Constants.QUIT_MESSAGE);
			do {
				str = br.readLine();
				int count = library.search(str);
				String message = "Word \"" + str + "\" ";
				if (count > 0) {
					System.out.println(message + "encountered " + count
							+ " times");
				} else {
					System.out.println(message + "not found");
				}
			} while (!str.equals(Constants.QUIT_STRING));
		} catch (FileNotFoundException e) {
			System.out.println(Constants.FILE_EXCEPTION);
		} catch (IOException e) {
			System.out.println(Constants.READING_EXCEPTION);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(Constants.CLOSING_EXCEPTION);
				}
			}
		}
	}
}
