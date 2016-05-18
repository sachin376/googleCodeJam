package codejam.R12008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Numbers {

	private static final String INPUT_FILENAME = "Numbers.txt";
	private static final String OUTPUT_FILENAME = "NumbersOutput.txt";

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		Scanner scanInput = new Scanner(reader);
		int testCases = scanInput.nextInt();

		int input, result;
		double a, cal;
		String output;

		for (int testCase = 0; testCase < testCases; ++testCase) {
			input = scanInput.nextInt();
			a = Math.log(3 + Math.sqrt(5));
			cal = Math.pow(Math.E, a * input);
			result = (int) cal % 1000;
			output = String.format("%03d", result);
			System.out.println(cal);

			write.write("Case #" + (testCase + 1) + ": " + output + "\n");
		}

		scanInput.close();
		write.flush();
		write.close();
	}
}