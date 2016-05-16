package codejam.R32016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P1 {

	private static final String PATH = ".//src//codejam//R32016//";
	private static final String INPUT_FILENAME = PATH+"p1.in";
	private static final String OUTPUT_FILENAME = PATH+"p1-out.in";
	
	public static String solve(int N, int[] p) {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<N;i++){
			System.out.println((char)(65+i));
		}
		
		sb.append(p);
		return sb.toString();

	}


	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
//		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILENAME)));
		PrintWriter pr = new PrintWriter(System.out);

		Scanner scanInput = new Scanner(reader);
		StringBuffer sb = new StringBuffer();

		int testCases = scanInput.nextInt();
		for (int test = 1; test <= testCases; ++test) {

			// scanInput.useDelimiter(" ");
			int N = scanInput.nextInt();
			int[] parties = new int[N];
			
			for (int p = 0; p < N; p++) {
				parties[p]=scanInput.nextInt();
				
			}
			System.out.println("*****************Test Case ******************************************** : "+test);
			System.out.println("********inputs are : "+N+", " +Arrays.toString(parties));

			String answer = solve(N, parties);
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