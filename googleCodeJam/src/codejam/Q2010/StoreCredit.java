package codejam.Q2010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StoreCredit {
	public static void main(String[] args) throws FileNotFoundException {

		// Set system input to the file. If you remove first line then application starts taking input from the console
//		System.setIn(new FileInputStream("StoreCredit.txt"));
//		System.setIn(new FileInputStream("A-small-practice.in"));
		System.setIn(new FileInputStream("A-large-practice.in"));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// Set Output to a file
		PrintStream out = new PrintStream("StoreCreditOutput.txt");
		System.setOut(out);

		// input directly from the input file
		// File file = new File("input.txt");
		// Scanner in = new Scanner(file);

		int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int creditAmount;
		int noOfItems;
		List<Integer> itemLs = null;

		for (int testCase = 1; testCase <= testCases; ++testCase) {
			itemLs = new ArrayList<Integer>();
			creditAmount = in.nextInt();
			noOfItems = in.nextInt();
			for (int item = 1; item <= noOfItems; item++) {
				itemLs.add(in.nextInt());
			}
			// printInput(creditAmount, noOfItems, itemLs, testCase);
			// Collections.copy(sortedItemLs, itemLs);
			// Collections.sort(sortedItemLs);

			// System.out.println("itemLs #" + itemLs.toString());
			// System.out.println("sortedItemLs #" + sortedItemLs.toString());

			for (int i = 0; i < noOfItems; i++) {

				for (int j = i + 1; j < noOfItems; j++) {
					if (itemLs.get(i) + itemLs.get(j) == creditAmount) {
						printOutput(testCase, i, j);
					}
				}

			}

		}
		in.close();



	}

	private static void printOutput(int i1, int i2, int i3) {
		if (i2 < i3)
			System.out.println("Case #" + i1 + ": " + ++i2 + " " + ++i3);
		else
			System.out.println("Case #" + i1 + ": " + ++i3 + " " + ++i2);

	}

	/**
	 * @param creditAmount
	 * @param noOfItems
	 * @param itemLs
	 * @param testCase
	 */
	private static void printInput(int creditAmount, int noOfItems, List<Integer> itemLs, int testCase) {
		System.out.println("Case #" + testCase + ": " + "");
		System.out.println("creditAmount #" + creditAmount);
		System.out.println("noOfItems #" + noOfItems);
		System.out.println("itemLs #" + itemLs.toString());
	}
}