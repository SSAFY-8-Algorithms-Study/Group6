package study_group_06.week04;

import java.io.*;
import java.util.*;

public class Problem_11286 {

	static class absInteger {
		int value;
		int absValue;

		absInteger(int value) {
			this.value = value;
			this.absValue = Math.abs(value);
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<absInteger> absHeap = new PriorityQueue<>((o1, o2) -> {
			if (o1.absValue == o2.absValue)
				return o1.value > o2.value ? 1 : -1;
			else
				return o1.absValue > o2.absValue ? 1 : -1;
		});

		int N = Integer.parseInt(br.readLine());
		int in;

		for (int i = 1; i <= N; i++) {
			in = Integer.parseInt(br.readLine());

			if (in == 0) {
				if (absHeap.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(absHeap.poll()).append("\n");

			} else {
				absHeap.add(new absInteger(in));
			}
		}

		System.out.print(sb);

		br.close();
	}
}
