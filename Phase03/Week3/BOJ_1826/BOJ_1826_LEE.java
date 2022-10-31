package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1826 {
	static class Point {
		int p, f;

		public Point(int p, int f) {
			this.p = p; // 거리
			this.f = f; // 연료
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] gas_station = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			gas_station[i] = new Point(a, b);
		}

		Arrays.sort(gas_station, (o1, o2) -> {
			return o1.p - o2.p;
		});

		StringTokenizer st = new StringTokenizer(br.readLine());
		int end = Integer.parseInt(st.nextToken());
		int gas = Integer.parseInt(st.nextToken());
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.f - o1.f;
		});
		boolean notReached = false;
		int cnt = 0;
		loop: for (int i = 0; i < N; i++) {
			if (gas >= gas_station[i].p) {
				pq.add(gas_station[i]);
			} else {
				while (gas < gas_station[i].p) {
					if (pq.isEmpty()) {
						notReached = true;
						break loop;
					}
					gas += pq.poll().f;
					cnt++;
				}
				pq.add(gas_station[i]);
			}
		}
		
		while (gas < end) {
			if (pq.isEmpty()) {
				notReached = true;
				break;
			}
			gas += pq.poll().f;
			cnt++;
		}

		if (notReached)
			System.out.println(-1);
		else
			System.out.println(cnt);
	}
}
