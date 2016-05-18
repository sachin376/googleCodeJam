package codejam.R32016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P3 {

	private static final String PATH = ".//src//codejam//R32016//";
	private static final String INPUT_FILENAME = PATH+"p3.in";
	private static final String OUTPUT_FILENAME = PATH+"p3-out.in";

	public static String solve(int test, int J, int P, int S, int K) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();

		int k1 = 1;
		int k2 = 1;
		int count =0;

		for (int j = 1; j <= J; j++) {

			for (int p = 1; p <= P; p++) {
//				if (k1 > K && k2 > K) {
//					k1=1;
//					break;
//				}

				for (int s = 1; s <= S; s++) {
					if (k2 > K) {
						k2=1;
						break;
					}
					System.out.println(j+", "+p+", "+s);
//					System.out.println(k1+", "+k2);
					sb1.append(j+", "+p+", "+s);
					sb1.append("\n");
					count++;
					k2++;
				}
				if(k2 > K){
					k1++;
				}
			}

		}

		sb.append("Case #" + test + ": ");
		sb.append(count);
		sb.append("\n");
		
		
		sb.append(sb1);
		return sb.toString();

	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILENAME)));
//		 PrintWriter pr = new PrintWriter(System.out);

		Scanner scanInput = new Scanner(reader);
		StringBuffer sb = new StringBuffer();

		int testCases = scanInput.nextInt();
		for (int test = 1; test <= testCases; ++test) {

			// scanInput.useDelimiter(" ");
			int J = scanInput.nextInt();
			int P = scanInput.nextInt();
			int S = scanInput.nextInt();
			int K = scanInput.nextInt();
			System.out.println("*****************Test Case ******************************************** : " + test);
			System.out.println("********inputs are : " + J + ", " + P + ", " + S + ", " + K);

			String answer = solve(test, J, P, S, K);
//			System.out.println("*********out is : " + answer);

			sb.append(answer);
		}

		// **************Printing the output & closing all resources************

		pr.print(sb.toString()); // output result
		pr.flush();
		pr.close(); // close the output file
		scanInput.close();
		reader.close();

	}

}