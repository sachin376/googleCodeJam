package codejam.R12016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Prg3 {

	private static final String INPUT_FILENAME = "input.in";
	private static final String OUTPUT_FILENAME = "output.in";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	static boolean[] flag;
	static int prevCount = 0;
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	static Map<Integer,Integer> mapEndpoints = new HashMap<Integer,Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		Scanner scanInput = new Scanner(reader);

		int t = scanInput.nextInt();

		for (int i = 0; i < t; ++i) {
			int n = scanInput.nextInt();
			flag = new boolean[n];
			prevCount = 0;

			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				list.add(j, scanInput.nextInt());
			}

			int count = 0;
			for (int id = 0; id < n; id++) {

				count = 0;
				count = countStudents(id, id, list, count);
				map.put(id,count);


				if (count < prevCount) {
					count = prevCount;
				}
				prevCount = count;

			}



			for (int id = 0; id < n; id++) {

				int startPoint = id;
				int endPoint = mapEndpoints.get(id);
				count = map.get(id);
				count = countStudents(id, startPoint, list, count);
				count = countStudents(id, endPoint, list, count);


				count = 0;
				count = countStudents(id, id, list, count);
				map.put(id,count);


				if (count < prevCount) {
					count = prevCount;
				}
				prevCount = count;

			}

//			findTotalCount(n);




			System.out.println(count + 1);

			// write.write("Case #" + (t + 1) + ": " + sb.toString() + "\n");
			// write.write(sb.toString().trim() + "\n");
			// System.out.println(sb.toString().trim() + "\n");
		}

		scanInput.close();
		write.flush();
		write.close();

	}

	private static int countStudents(int original, int id, List<Integer> list, int count) {

		// System.out.println(id +"--"+list);
		int bbf = list.get(id);
		if (flag[bbf - 1] == true) {
			mapEndpoints.put(original, id);
			return count;
			/*
			if (Collections.frequency(list, bbf) > 1) {

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == bbf && flag[i] == false) {
						count++;
						break;
					}
				}
			}
			return count;
		*/} else {
			flag[id] = true;
			count++;
			return countStudents(original, bbf - 1, list, count);
		}

		// TODO Auto-generated method stub

	}
}