package codejam.Q2010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pancakes {

	private static final String INPUT_FILENAME = "input.in";
	private static final String OUTPUT_FILENAME = "pancakesOutput.txt";

	public static void main(String[] args) throws IOException {

		BufferedReader read = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		int testCases = Integer.valueOf(read.readLine());

		String readLine = "";
		char[] charArray;
		int len = 0;

		for (int i = 0; i < testCases; i++) {
			int count = 0;
			readLine = read.readLine();
			charArray = readLine.toCharArray();

			len = charArray.length;

			for (int j = len - 1; j >= 0; j--) {

				if (charArray[j] == '-') {
					flip(charArray, j);
					count = count + 1;
				} else {

				}

			}

			write.write("Case #" + (i + 1) + ": " + count + "\n");

		}
		read.close();
		write.flush();
		write.close();
	}

	private static void flip(char[] charArray, int start) {
		for (int j = start; j >= 0; j--) {
			if (charArray[j] == '-')
				charArray[j] = '+';
			else
				charArray[j] = '-';
		}
	}

}