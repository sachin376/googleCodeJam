package codejam.R22016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Prg2 {

	private static final String INPUT_FILENAME = "prg2.in";
	private static final String OUTPUT_FILENAME = "prg2.txt";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		PrintWriter out = new PrintWriter(write);

		Scanner scanInput = new Scanner(reader);
		int t = scanInput.nextInt();
		String a, b;
		for (int i = 0; i < t; ++i) {
			a = scanInput.next();
			b = scanInput.next();
			// System.out.println("Case #" + (i + 1) + ": " + a + " , " + b);

			char[] a1 = a.toCharArray();
			char[] b1 = b.toCharArray();
			
			int j =0; 
			
			for ( ; j < a1.length; j++) {
				char c1 = a1[j];
				char c2 = b1[j];
				
				if(c1 !=c2 && c1 !='?'){
					break;
				}
				
				
			}
			
			for (int k = 0; k <= j; k++) {
				char c1 = a1[k];
				char c2 = b1[k];
				
				if(c1==c2 && c1=='?'){
					a1[k]=0;
					
				}
			}

			

			String out1 = new String(a1);
			String out2 = new String(b1);
//			for (int m = 0; m < a1.length; m++) {
//				out1.append(a1[m]);
//				out2.append(a2[m]);
//			}

//			System.out.println("Case #" + (i + 1) + ": " + out1 + " " + out2);

			out.println("Case #" + (i + 1) + ": " + out1 + " " + out2);
		}

		scanInput.close();
		reader.close();
		write.flush();
		write.close();
		out.close();

	}
}
