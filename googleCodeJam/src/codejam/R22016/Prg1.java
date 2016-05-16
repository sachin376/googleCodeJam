package codejam.R22016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Prg1 {

	private static final String INPUT_FILENAME = "prg1.in";
	private static final String OUTPUT_FILENAME = "prg1.txt";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		PrintWriter out = new PrintWriter(write);

		Scanner scanInput = new Scanner(reader);
		int t = scanInput.nextInt();
		String str;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; ++i) {
			str = scanInput.next();
			sb.setLength(0);
			 StringBuilder input = new StringBuilder(str);
			findPhoneNum2(input, sb);
			char a[] = sb.toString().toCharArray();
			Arrays.sort(a);
			String output = new String(a);
			out.println("Case #" + (i + 1) + ": " + output);
			// System.out.println("Case #" + (i + 1) + ": " + output);
		}

		scanInput.close();
		reader.close();
		write.flush();
		write.close();
		out.close();

		// ****************************************************************************

	}

	private static void findPhoneNum2(StringBuilder str, StringBuilder sb) {

		while (str.indexOf("Z") >= 0) {
			sb.append('0');
			str.deleteCharAt(str.indexOf("Z"));
			str.deleteCharAt(str.indexOf("E"));
			str.deleteCharAt(str.indexOf("R"));
			str.deleteCharAt(str.indexOf("O"));
		}

		while (str.indexOf("W") >= 0) {
			sb.append('2');
			str.deleteCharAt(str.indexOf("T"));
			str.deleteCharAt(str.indexOf("W"));
			str.deleteCharAt(str.indexOf("O"));
		}

		while (str.indexOf("X") >= 0) {
			sb.append('6');
			str.deleteCharAt(str.indexOf("S"));
			str.deleteCharAt(str.indexOf("I"));
			str.deleteCharAt(str.indexOf("X"));
		}

		while (str.indexOf("U") >= 0) {
			sb.append('4');
			str.deleteCharAt(str.indexOf("F"));
			str.deleteCharAt(str.indexOf("O"));
			str.deleteCharAt(str.indexOf("U"));
			str.deleteCharAt(str.indexOf("R"));
		}

		while (str.indexOf("G") >= 0) {
			sb.append('8');
			str.deleteCharAt(str.indexOf("E"));
			str.deleteCharAt(str.indexOf("I"));
			str.deleteCharAt(str.indexOf("G"));
			str.deleteCharAt(str.indexOf("H"));
			str.deleteCharAt(str.indexOf("T"));
		}

		while (str.indexOf("R") >= 0) {
			sb.append('3');
			str.deleteCharAt(str.indexOf("T"));
			str.deleteCharAt(str.indexOf("H"));
			str.deleteCharAt(str.indexOf("R"));
			str.deleteCharAt(str.indexOf("E"));
			str.deleteCharAt(str.indexOf("E"));
		}
		while (str.indexOf("O") >= 0) {
			sb.append('1');
			str.deleteCharAt(str.indexOf("O"));
			str.deleteCharAt(str.indexOf("N"));
			str.deleteCharAt(str.indexOf("E"));
		}

		while (str.indexOf("S") >= 0) {
			sb.append('7');
			str.deleteCharAt(str.indexOf("S"));
			str.deleteCharAt(str.indexOf("E"));
			str.deleteCharAt(str.indexOf("V"));
			str.deleteCharAt(str.indexOf("E"));
			str.deleteCharAt(str.indexOf("N"));
		}

		while (str.indexOf("V") >= 0) {
			sb.append('5');
			str.deleteCharAt(str.indexOf("F"));
			str.deleteCharAt(str.indexOf("I"));
			str.deleteCharAt(str.indexOf("V"));
			str.deleteCharAt(str.indexOf("E"));
		}
		while (str.indexOf("E") >= 0) {
			sb.append('9');
			str.deleteCharAt(str.indexOf("N"));
			str.deleteCharAt(str.indexOf("I"));
			str.deleteCharAt(str.indexOf("N"));
			str.deleteCharAt(str.indexOf("E"));
		}
	}
}