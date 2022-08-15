package study_group_06.week03;

import java.io.*;

public class Problem_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sbForward, sbBackward;

		char[] charArr = new char[26];

		for (int i = 0; i < line.length(); i++) {
			charArr[line.charAt(i) - 'A']++;
		}

		int oddCnt = 0;

		for (int i = 0; i < 26; i++) {
			if (charArr[i] % 2 == 1) {
				oddCnt++;
			}
		}

		sbForward = new StringBuilder();
		sbBackward = new StringBuilder();
		char ch = '0';
		char center = '0';

		if (oddCnt > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			for (int i = 0; i < 26; i++) {
				ch = (char) (i + 'A');
				if (charArr[i] % 2 == 1) {
					center = ch;
				}
				for (int j = 0; j < charArr[i] / 2; j++) {
					sbForward.append(ch);
					sbBackward.insert(0, ch);
				}

			}
		}

		if (center == '0') {
			sbForward.append(sbBackward);
		} else {
			sbForward.append(center).append(sbBackward);
		}

		System.out.println(sbForward);

		br.close();
	}
}
