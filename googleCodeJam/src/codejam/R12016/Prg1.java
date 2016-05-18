package codejam.R12016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Prg1 {

	private static final String INPUT_FILENAME = "input.in";
	private static final String OUTPUT_FILENAME = "output.in";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	public static void main(String[] args) throws IOException {

		// ************************************Reading line by line from file**********************************************************
		BufferedReader read = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		String s = "";

		int testCases = Integer.valueOf(read.readLine());

		for (int tc = 0; tc < testCases; tc++) {
			s = String.valueOf(read.readLine());
			char[] charArray = s.toCharArray();
			StringBuilder sb = new StringBuilder(charArray.length);

			sb.append(charArray[0]);
			for (int i = 1; i < charArray.length; i++) {
				if (charArray[i] < sb.charAt(0)) {
					sb.append(charArray[i]);
				} else {
					sb.insert(0, charArray[i]);
				}
			}
			write.write("Case #" + (tc + 1) + ": " + sb.toString() + "\n");

		}

		read.close();
		write.flush();
		write.close();

	}
}