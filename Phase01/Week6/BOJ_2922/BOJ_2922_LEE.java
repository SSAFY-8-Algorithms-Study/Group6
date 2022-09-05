package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2922 {
	static String S;
	static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		perm(0, 0, 0, false, 1);
		System.out.println(ans);

	}

	static void perm(int idx, int vowel, int consonant, boolean isExistL, long cnt) {
		if (vowel == 3 || consonant == 3)
			return;

		if (idx == S.length()) {
			if (!isExistL)
				return;
			ans += cnt;
			return;
		}

		if (S.charAt(idx) == '_') {
			perm(idx + 1, vowel + 1, 0, isExistL, cnt * 5);
			perm(idx + 1, 0, consonant + 1, true, cnt);
			perm(idx + 1, 0, consonant + 1, isExistL, cnt * 20);

		} else if (isVowels(S.charAt(idx))) {
			perm(idx + 1, vowel + 1, 0, isExistL, cnt);
		} else if (S.charAt(idx) == 'L') {
			perm(idx + 1, 0, consonant + 1, true, cnt);
		} else {
			perm(idx + 1, 0, consonant + 1, isExistL, cnt);
		}
	}

	static boolean isVowels(char c) {
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			return true;
		return false;
	}
}
