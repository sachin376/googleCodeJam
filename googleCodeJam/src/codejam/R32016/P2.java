package codejam.R32016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P2 {

	private static final String PATH = ".//src//codejam//R32016//";
	private static final String INPUT_FILENAME = PATH+"p2.in";
	private static final String OUTPUT_FILENAME = PATH+"p2-out.in";
	
	
	
	public static String solve(int a, int b) {
		StringBuffer sb = new StringBuffer();
		sb.append(a * b);
		return sb.toString();

	}


	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILENAME)));
//		PrintWriter pr = new PrintWriter(System.out);

		Scanner scanInput = new Scanner(reader);
		StringBuffer sb = new StringBuffer();

		int testCases = scanInput.nextInt();
		for (int test = 1; test <= testCases; ++test) {

			// scanInput.useDelimiter(" ");
			int a = scanInput.nextInt();
			int b = scanInput.nextInt();
			System.out.println("*****************Test Case ******************************************** : "+test);
			System.out.println("********inputs are : "+a+", "+b);

			String answer = solve(a, b);
			System.out.println("*********out is : "+answer);

			sb.append("Case #" + test + ": ");
			sb.append(" Multiplication = ");
			sb.append(answer);
			sb.append("\n");
		}

		
		// **************Printing the output & closing all resources************
		
		pr.print(sb.toString()); // output result
		pr.flush();
		pr.close(); // close the output file
		scanInput.close();
		reader.close();

	}

	
	private static String sortCharsInString(String pattern) {
		char[] patternArray = pattern.toCharArray();
		Arrays.sort(patternArray);
		String p = new String(patternArray);
		return p;
	}

}