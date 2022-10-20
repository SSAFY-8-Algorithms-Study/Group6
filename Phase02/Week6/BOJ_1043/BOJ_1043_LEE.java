package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int TN = Integer.parseInt(st.nextToken());
		int[] truth = new int[TN];
		for(int i=0; i<TN; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		ArrayList<int[]> party = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] p = new int[n];
			for(int j=0; j<n; j++) {
				p[j] = Integer.parseInt(st.nextToken());
			}
			party.add(p);
			union(p);
		}
		
		int ans = 0;
		for(int i=0; i<M; i++) {
			int[] p = party.get(i);
			boolean check = true;
			loop:
			for(int j=0; j<p.length; j++) {
				for(int k=0; k<TN; k++) {
					if(find(truth[k]) == find(p[j])) {
						check = false;
						break loop;
					}
				}
			}
			if(check)
				ans++;
		}
		
		System.out.println(ans);
		
		
	}
	
	static void union(int[] p) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<p.length; i++) {
			min = Math.min(min, find(p[i]));
		}
		for(int i=0; i<p.length; i++) {
			parent[find(p[i])] = find(min);
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
}
