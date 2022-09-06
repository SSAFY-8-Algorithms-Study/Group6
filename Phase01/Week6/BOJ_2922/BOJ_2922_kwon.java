package study_group_06.week06;

import java.io.*;

public class Problem_2922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inStr = br.readLine().trim();

		long caseCnt = perm(inStr, 0, 0, 0, false);

		System.out.println(caseCnt);

		br.close();
	}

	static boolean isVowel(char c) {
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			return true;
		return false;
	}

	static long perm(String str, int idx, int vCnt, int cCnt, boolean isL) {
		long caseCnt = 0;

		if (cCnt == 3 || vCnt == 3)
			return 0;

		if (idx == str.length())
			return isL ? 1 : 0;

		if (str.charAt(idx) == '_') {
			caseCnt += perm(str, idx + 1, 0, cCnt + 1, true);
			caseCnt += perm(str, idx + 1, 0, cCnt + 1, isL) * 20;
			caseCnt += perm(str, idx + 1, vCnt + 1, 0, isL) * 5;
		} else if (str.charAt(idx) == 'L') {
			caseCnt = perm(str, idx + 1, 0, cCnt + 1, true);
		} else {
			if (isVowel(str.charAt(idx)))
				caseCnt = perm(str, idx + 1, vCnt + 1, 0, isL);
			else
				caseCnt = perm(str, idx + 1, 0, cCnt + 1, isL);
		}

		return caseCnt;
	}
}
