package codejam.Q2010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWords {
	public static void main(String[] args) throws IOException {

//		final String inputFileName = "B-large-practice.in";
		final String inputFileName = "ReverseWords.txt";
		final String outputFileName = "ReverseWordsOutput.txt";

		BufferedReader read = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter write = new BufferedWriter(new FileWriter(outputFileName));
		int testCases = Integer.valueOf(read.readLine());

		String readLine = "";
		String output = "";
		String temp = "";
		String[] split;
		int len = 0;

		for (int i = 0; i < testCases; i++) {
			StringBuilder revSentence = new StringBuilder();
			readLine = read.readLine();
			split = readLine.split(" ");
			len = split.length;
			for (int j = 0; j < len; j++) {
				revSentence.append(split[len - j - 1] + " ");
			}
			output = revSentence.toString();
			write.write("Case #" + (i + 1) + ": " + output.trim() + "\n");


			/*for (int j = 0; j < len/2; j++) {
				temp = split[len-j-1];
				split[len-j-1] = split[j];
				split[j] = temp;
			}

			write.write("Case #" + (i + 1) + ": " + Arrays.toString(split) + "\n");*/



		}
		write.flush();
	}

}