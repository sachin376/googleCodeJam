package codejam.R12008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinScalarProduct {

	private static final String INPUT_FILENAME = "MinScalarProduct.txt";
	private static final String OUTPUT_FILENAME = "MinScalarProductOutput.txt";

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));

		Scanner scanInput = new Scanner(reader);
		int testCases = scanInput.nextInt();
		int noCountInVector = 0;
		long result;
		long[] v1, v2;
		for (int testCase = 0; testCase < testCases; ++testCase) {
			noCountInVector = scanInput.nextInt();
			v1 = new long[noCountInVector];
			v2 = new long[noCountInVector];
			result = 0;

			for (int i = 0; i < noCountInVector; i++) {
				v1[i] = scanInput.nextInt();

			}
			for (int j = 0; j < noCountInVector; j++) {
				v2[j] = scanInput.nextInt();
			}

			Arrays.sort(v1);
			Arrays.sort(v2);

			for (int k = 0; k < noCountInVector; k++) {
				result += v1[k] * v2[noCountInVector - k - 1];
			}

			write.write("Case #" + (testCase + 1) + ": " + result+"\n");
		}

		scanInput.close();
		write.flush();
		write.close();
	}
}