package codejam.R22016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prg3 {

	private static final String INPUT_FILENAME = "prg1.in";
	private static final String OUTPUT_FILENAME = "prg2.in";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	public static void main(String[] args) throws IOException {

		// Set system input to the file. If you remove first line then
		// application starts taking input from the console
		// System.setIn(new FileInputStream(INPUT_FILENAME));
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));

		// ****Reading token by token from file.. tokenizer is space*********

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		PrintWriter out = new PrintWriter(write);

		Scanner scanInput = new Scanner(reader);
		int t = scanInput.nextInt();
		int a,b;
		for (int i = 0; i < t; ++i) {
			a = scanInput.nextInt();
			b = scanInput.nextInt();
			System.out.println("Case #" + (i + 1) + ": " + a + b);
			// write.write("Case #" + (i + 1) + ": " + a + b);
			out.println("Case #" + (i + 1) + ": " + a + b);
		}

		scanInput.close();
		reader.close();
		write.flush();
		write.close();
		out.close();

		// ****************************************************************************

	}
}