package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11387 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] pabu = new long[5];
		long[] kri = new long[5];
		long[] pabu_w = new long[5];
		long[] kri_w = new long[5];
		long origin_pabu_stat = 0;
		long origin_kri_stat = 0;
		long after_pabu_stat = 0;
		long after_kri_stat = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			kri[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			pabu[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			kri_w[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			pabu_w[i] = Integer.parseInt(st.nextToken());
		}

		origin_kri_stat = kri[0] * (100 + kri[1])
				* (100 * (100 - Math.min(kri[2], 100)) + Math.min(kri[2], 100) * kri[3]) * (100 + kri[4]);
		origin_pabu_stat = pabu[0] * (100 + pabu[1])
				* (100 * (100 - Math.min(pabu[2], 100)) + Math.min(pabu[2], 100) * pabu[3]) * (100 + pabu[4]);

//		System.out.println("origin_pabu_stat: " + origin_pabu_stat);
//		System.out.println("origin_kri_stat: " + origin_kri_stat);

		for (int i = 0; i < 5; i++) {
			pabu[i] = pabu[i] - pabu_w[i] + kri_w[i];
		}

		for (int i = 0; i < 5; i++) {
			kri[i] = kri[i] - kri_w[i] + pabu_w[i];
		}

		after_kri_stat = kri[0] * (100 + kri[1])
				* (100 * (100 - Math.min(kri[2], 100)) + Math.min(kri[2], 100) * kri[3]) * (100 + kri[4]);
		after_pabu_stat = pabu[0] * (100 + pabu[1])
				* (100 * (100 - Math.min(pabu[2], 100)) + Math.min(pabu[2], 100) * pabu[3]) * (100 + pabu[4]);

//		System.out.println("after_pabu_stat: " + after_pabu_stat);
//		System.out.println("after_kri_stat: " + after_kri_stat);

		if (origin_kri_stat > after_kri_stat) {
			System.out.println('-');
		} else if (origin_kri_stat == after_kri_stat) {
			System.out.println(0);
		} else {
			System.out.println('+');
		}

		if (origin_pabu_stat > after_pabu_stat) {
			System.out.println('-');
		} else if (origin_pabu_stat == after_pabu_stat) {
			System.out.println(0);
		} else {
			System.out.println('+');
		}

	}
}
