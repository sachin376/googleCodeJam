package codejam.R32016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P4 {
	
	private static final String PATH = ".//src//codejam//R32016//";
	private static final String INPUT_FILENAME = PATH+"p4.in";
	private static final String OUTPUT_FILENAME = PATH+"p4-out.in";

	public static String solve(int test, int J, int P, int S, int K) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();

		int k1 = 1;
		int k2 = 1;
		int count = 0;

		for (int j = 1; j <= J; j++) {

			for (int p = 1; p <= P; p++) {
				// if (k1 > K && k2 > K) {
				// k1=1;
				// break;
				// }

				for (int s = 1; s <= S; s++) {
					if (k2 > K) {
						k2 = 1;
						break;
					}
					System.out.println(j + ", " + p + ", " + s);
					// System.out.println(k1+", "+k2);
					sb1.append(j + ", " + p + ", " + s);
					sb1.append("\n");
					count++;
					k2++;
				}
				if (k2 > K) {
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

	public static void abc(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILENAME)));
		// PrintWriter pr = new PrintWriter(System.out);

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
			// System.out.println("*********out is : " + answer);

			sb.append(answer);
		}

		// **************Printing the output & closing all resources************

		pr.print(sb.toString()); // output result
		pr.flush();
		pr.close(); // close the output file
		scanInput.close();
		reader.close();

	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILENAME)));
		

		Scanner scan = new Scanner(reader);
		int testCases = scan.nextInt();
		for (int t = 0; t < testCases; t++) {
			int M = scan.nextInt();
			int N = scan.nextInt();
			Map<Integer, String> c = new HashMap<Integer, String>();
			for (int i = 1; i <= N; i++) {
				int value = scan.nextInt();
				if (c.get(value) != null) {
					c.put(value, c.get(value) + "," + i);
				} else {
					c.put(value, i + "");
				}
			}

			int n1 = Integer.MAX_VALUE;
			int n2 = Integer.MAX_VALUE;

			int t1, t2;
			t1 = t2 = 0;

			for (Integer k : c.keySet()) {

				// System.out.println(" **k="+k);
				// System.out.println(" **"+c.get(k));

				if ((k * 2 == M) && (c.get(k).indexOf(",") > 0)) {
					// System.out.println("**inside 2k==m");
					t1 = findPositionAtIndex(c.get(k), 0);
					t2 = findPositionAtIndex(c.get(k), 1);
					if (t1 < n1) {
						n1 = t1;
						n2 = t2;
					}
					// break;
				}
				if (M > k && c.get(M - k) != null) {
					// System.out.println("**inside other");

					t1 = findPositionAtIndex(c.get(k), 0);
					t2 = findPositionAtIndex(c.get(M - k), 0);
					if ( (t1< n1) && t1!=t2) {
						n1 = t1;
						n2 = t2;
					}

					// break;
				}

			}

			if (n1 < n2) {
				pr.print(n1);
				pr.print(" ");
				pr.println(n2);
			} else {
				pr.print(n2);
				pr.print(" ");
				pr.println(n1);
			}

		}
		pr.flush();
		pr.close(); // close the output file
		scan.close();
	}

	private static int findPositionAtIndex(String s, int index) {
		String[] split = s.split(",");
		// System.out.println("FFFFF ="+Arrays.toString(split));
		return Integer.parseInt(split[index]);
	}

}