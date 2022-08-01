package algo_07_4.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1059 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int[] s = new int[l];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < l; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		Arrays.sort(s);
		int a = 0;
		int b = 0;
		int check = 0;
		if(s[0] > n) { // 리스트의 모든 수보다 n이 작을 때
			b = s[0];
			System.out.println((n - (a + 1)) * (b - n) + (b - n - 1));
		}
		else {
			for (int i = 1; i < l; i++) {
				if(s[i] > n && s[i-1] < n) { // n이상, n이하인 리스트안에서 n을 포함하는 좋은 구간 갯수 세기
					a = s[i-1];
					b = s[i];
					System.out.println((n - (a + 1)) * (b - n) + (b - n - 1));
					check++;
					break;
				}
			}
			if(check == 0) {
				System.out.println(0);
			}
		}

		
	}
}

