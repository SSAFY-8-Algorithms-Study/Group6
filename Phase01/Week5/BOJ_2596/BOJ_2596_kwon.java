package study_group_06.week05;

import java.io.*;

public class Problem_2596 {
	static String[] table = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();
		String sub;
		boolean isMatch;

		for (int i = 0; i < N; i++) {
			isMatch = false;

			for (int j = 0; j < table.length; j++) {
				sub = input.substring(i * table[0].length(), (i + 1) * table[0].length());
				if (compare(sub, table[j])) {
					sb.append((char) (j + 'A'));
					isMatch = true;
				}
			}

			if (!isMatch) {
				sb = new StringBuilder();
				sb.append(i + 1);
				break;
			}
		}

		System.out.println(sb);

		br.close();
	}

	static boolean compare(String str1, String str2) {
		int cnt = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i))
				cnt++;
		}
		return str1.length() - cnt < 2 ? true : false;
	}
}
