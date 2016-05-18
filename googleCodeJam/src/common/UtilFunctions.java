package common;

import java.util.ArrayList;
import java.util.Arrays;

public class UtilFunctions {
	
	public static void main(String[] arg){
		
		ArrayList<ArrayList<Integer>> partitions = UtilFunctions.partitions(3, 12, false);
		for (ArrayList<Integer> arrayList : partitions) {
			
			for (Integer integer : arrayList) {
				System.out.print(integer+", ");
			}
			System.out.println();
		}
	}

	// Util methods
	public static String sortCharsInString(String pattern) {
		char[] patternArray = pattern.toCharArray();
		Arrays.sort(patternArray);
		String p = new String(patternArray);
		return p;
	}

	public static int[][] matrixMultiply(int[][] A, int[][] B) {
		int A_rows = A.length;
		int A_cols = A[0].length;
		int B_rows = B.length;
		int B_cols = B[0].length;
		if (A_cols != B_rows)
			throw new IllegalStateException("Bad dimensions in matrixMultiply");
		int[][] C = new int[A_rows][B_cols];
		for (int r = 0; r < A_rows; r++) {
			for (int c = 0; c < B_cols; c++) {
				int d = 0;
				for (int i = 0; i < A_cols; i++) {
					d += A[r][i] * B[i][c];
				}
				C[r][c] = d;
			}
		}
		return C;
	}

	public static int[][] matrixAdd(int[][] A, int[][] B) {
		int A_rows = A.length;
		int A_cols = A[0].length;
		int B_rows = B.length;
		int B_cols = B[0].length;
		if (A_rows != B_rows || A_cols != B_cols)
			throw new IllegalStateException("Bad dimensions in matrixAdd");
		int[][] C = new int[A_rows][A_cols];
		for (int r = 0; r < A_rows; r++) {
			for (int c = 0; c < A_cols; c++) {
				C[r][c] = A[r][c] + B[r][c];
			}
		}
		return C;
	}

	public static int[][] matrixPower(int[][] A, int n) {
		int A_rows = A.length;
		int A_cols = A[0].length;

		if (A_rows != A_cols)
			throw new IllegalStateException("matrixPower matrix must be square");

		if (n < 0)
			throw new IllegalStateException("matrixPower power must be non-negative.");

		if (n == 0) {
			// identity
			int[][] I = new int[A_rows][A_cols];
			for (int i = 0; i < A_rows; i++) {
				I[i][i] = 1;
			}
			return I;
		}

		if (n == 1)
			return A;
		if (n % 2 == 1)
			return matrixMultiply(A, matrixPower(A, n - 1));
		int[][] half = matrixPower(A, n / 2);
		return matrixMultiply(half, half);
	}

	public static long power(long a, long b) {
		// a^b
		if (b == 0)
			return 1L; // return 0^0 as 1
		if (b == 1)
			return a;
		if (b % 2 == 1) {
			long oneless = power(a, b - 1);
			return (a * oneless);
		} else {
			long half = power(a, b / 2);
			return (half * half);
		}
	}

	public static ArrayList<ArrayList<Integer>> partitions(int length, int totalCount, boolean allowZero) {
		// generates all lists of numbers of length "length" with sum
		// "totalCount".
		int lowest = allowZero ? 0 : 1;

		if (length == 1) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(totalCount);
			ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
			if (totalCount >= lowest)
				ll.add(l);
			return ll;
		}

		ArrayList<ArrayList<Integer>> out = new ArrayList<>();
		for (int i = lowest; i <= totalCount; i++) {
			ArrayList<ArrayList<Integer>> head = partitions(length - 1, totalCount - i, allowZero);
			for (ArrayList<Integer> l : head) {
				l.add(i);
				out.add(l);
			}
		}
		return out;

	}

}