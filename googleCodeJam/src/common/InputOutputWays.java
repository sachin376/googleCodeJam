package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputOutputWays {

	private static final String INPUT_FILENAME = "input.in";
	private static final String OUTPUT_FILENAME = "output.in";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	public static void main(String[] args) throws IOException {

		// ************************************Reading line by line from
		// file**********************************************************
		BufferedReader read = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));

		int testCases = Integer.valueOf(read.readLine());
		for (int tc = 0; tc < testCases; tc++) {

			write.write("Case #" + (tc + 1) + ": " + " fsdfsdf \n");
		}

		read.close();
		write.flush();
		write.close();

		// **************************************Reading token by token from
		// file.. tokenizer is
		// space********************************************************

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		Scanner scanInput = new Scanner(reader);
		scanInput.next();
		scanInput.nextInt();

		int t = scanInput.nextInt(); // Scanner has functions to read ints,
										// longs, strings, chars, etc.
		for (int i = 0; i < t; ++i) {
			int a = scanInput.nextInt();
			int b = scanInput.nextInt();
			System.out.println("Case #" + (i + 1) + ": " + " dsfdsfsdfsdf");
		}

		PrintWriter pr = new PrintWriter(new File("/* File name */"));
		pr.print("sdfdsf");
		pr.close();
		scanInput.close();

		// **********************************************************************************************

		// Set system input to the file. If you remove first line then
		// application starts taking input from the console
		System.setIn(new FileInputStream(INPUT_FILENAME));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// Set Output to a file
		PrintStream pout = new PrintStream(OUTPUT_FILENAME);
		System.setOut(pout);

		// input directly from the input file
		// File file = new File("input.txt");
		// Scanner in = new Scanner(file);

		int allTestCase = in.nextInt(); // Scanner has functions to read ints,
										// longs, strings, chars, etc.
		for (int i = 1; i <= allTestCase; ++i) {
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
		}
		in.close();

		// **********************************************************************************************

		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken()); // second integer
		out.println(i1 + i2); // output result
		out.close(); // close the output file

	}

	// Util methods
	private static String sortCharsInString(String pattern) {
		char[] patternArray = pattern.toCharArray();
		Arrays.sort(patternArray);
		String p = new String(patternArray);
		return p;
	}

}