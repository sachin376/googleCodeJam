package codejam.Q2010;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.Scanner;

public class CoinJam {

//	 private static final String INPUT_FILENAME = "C-small-attempt2.in";
	private static final String INPUT_FILENAME = "coin.in";
	private static final String OUTPUT_FILENAME = "coinOutput.txt";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		

		File file = new File(INPUT_FILENAME);
		Scanner in = new Scanner(file);

		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));

//		write.write(new Boolean(isPrime(337)).toString());
		int testCases = in.nextInt();

		for (int i = 0; i < testCases; i++) {
			int N = in.nextInt();
			int J = in.nextInt();
			int j = 1;

			write.write("Case #" + (i + 1) + ": " + "\n");

			BitSet bitRepresentation = new BitSet();
			bitRepresentation.set(0);
			bitRepresentation.set(N - 1);
			Long numberValue = bitRepresentation.toLongArray()[0];
			numberValue = numberValue + 2;

			while (j <= J) {
				StringBuilder divisors = new StringBuilder();
				for (int baseSystem = 2; baseSystem <= 10; baseSystem++) {
					long val = 0;
					for (int k = 0; k < N; k++) {
						if (bitRepresentation.get(k)) {
							val += (int) Math.pow(baseSystem, k);
						}
					}

					if (isPrime(val)) {
						numberValue = numberValue + 2;
						bitRepresentation = BitSet.valueOf(new long[] { numberValue });
						baseSystem = 1;
						divisors.setLength(0);
						continue;
					} else {
						divisors.append(getDivisor(val, baseSystem) + " ");
						// ArrayList<Integer> allFactors = allFactors(val);
						// divisors.append(allFactors.get(allFactors.size()/2-1)
						// + " ");
					}
//					write.write("base"+baseSystem+" value ="+val + " -- ");
				}

				write.write(Long.toBinaryString(numberValue) + " ");
//				write.write("base10 value ="+numberValue + " -- ");
				write.write(divisors.toString().trim() + "\n");
				j++;
				numberValue = numberValue + 2;
				bitRepresentation = BitSet.valueOf(new long[] { numberValue });
			}
		}
		write.flush();
		write.close();
	}

	private static boolean isPrime(long n) {
		/*if (n <= 1) {
			return false;
		}*/
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int getDivisor(long num, int baseSystem) {
		int result = -1;
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if (num % i == 0) {
				result = i;
			}
		}
		return result;
	}

	/*
	 * private static ArrayList<Integer> allFactors(long a) { int upperlimit =
	 * (int)(Math.sqrt(a)); ArrayList<Integer> factors = new
	 * ArrayList<Integer>(); for(int i=1;i <= upperlimit; i+= 1){ if(a%i == 0){
	 * factors.add(i); if(i != a/i){ factors.add((int)a/i); } } }
	 * Collections.sort(factors); return factors; }
	 */

}