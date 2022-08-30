package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2596 {
	static String[] str = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
	static char[] str2 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String ans = "";
		for (int i = 0; i < n; i++) {
			String s2 = s.substring(i * 6, (i + 1) * 6);
			if (encrypt(s2) == 'X') {
				ans = Integer.toString(i + 1);
				break;
			}
			ans += encrypt(s2);
		}
		System.out.println(ans);
	}

	static char encrypt(String s) {
		for (int i = 0; i < 8; i++) {
			int diff = 0;
			for (int j = 0; j < 6; j++) {
				if (s.charAt(j) != str[i].charAt(j))
					diff++;
			}
			if (diff <= 1)
				return str2[i];
		}
		return 'X';
	}
}
