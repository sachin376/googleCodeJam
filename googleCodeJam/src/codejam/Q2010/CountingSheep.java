package codejam.Q2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CountingSheep {

	public static void main(String[] args) throws FileNotFoundException {

		PrintStream out = new PrintStream("countingSheepOutput.txt");
		System.setOut(out);

		// input directly from the input file
		File file = new File("A-large.in");
		Scanner in = new Scanner(file);

		int testCases = in.nextInt();

		for (int testCase = 1; testCase <= testCases; ++testCase) {
			boolean[] flag = new boolean[10];

			int inputNum = in.nextInt();
			if (inputNum == 0) {
				System.out.println("Case #" + testCase + ": " + "INSOMNIA");
				continue;
			}

			int i = 0;
			boolean condition = true;
			int temp = 0;
			int digit = 0;
			do {

				i = i + 1;
				temp = inputNum * i;

				while (true) {
					digit = temp % 10;
					flag[digit] = true;

					temp = temp / 10;
					if (temp == 0) {
						break;
					}

				}

				if (isAllNumberDone(flag)) {
					System.out.println("Case #" + testCase + ": " + inputNum * i);
					break;
				}

			} while (condition);
		}
		in.close();
	}

	private static boolean isAllNumberDone(boolean[] flag) {
		for (int i = 0; i < 10; i++) {
			if (flag[i] == false)
				return false;
		}
		return true;

	}

}