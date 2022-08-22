package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> {
			if(Math.abs(o1)==Math.abs(o2)) {
				return o1-o2;
			}
			return Math.abs(o1)-Math.abs(o2);
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int j = Integer.parseInt(br.readLine());
			if(j==0) {
				if(pq.isEmpty()) 
					sb.append(0+"\n");
				else {
					sb.append(pq.poll()+"\n");
				}
			}
			else {
				pq.add(j);
			}
		}
		System.out.println(sb);

	}
}
