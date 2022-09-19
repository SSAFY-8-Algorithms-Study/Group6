package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
	static class Edge {
		int v, cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	static int N;
	static ArrayList<Edge>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[start].add(new Edge(end, cost));
			adjList[end].add(new Edge(start, cost));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int d1 = dijkstra(1, v1);
		int d2 = dijkstra(v1, v2);
		int d3 = dijkstra(v2, N);
		int dist1 = Integer.MAX_VALUE;
		if (d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE && d3 != Integer.MAX_VALUE) {
			dist1 = d1 + d2 + d3;
		}
		d1 = dijkstra(1, v2);
		d2 = dijkstra(v2, v1);
		d3 = dijkstra(v1, N);
		int dist2 = Integer.MAX_VALUE;
		if (d1 != Integer.MAX_VALUE && d2 != Integer.MAX_VALUE && d3 != Integer.MAX_VALUE) {
			dist2 = d1 + d2 + d3;
		}

		if (dist1 == Integer.MAX_VALUE && dist2 == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Math.min(dist1, dist2));

	}

	static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.cost - o2.cost;
		});

		pq.add(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge minE = pq.poll();

			if (visited[minE.v])
				continue;

			if (minE.v == end)
				break;

			visited[minE.v] = true;
			for (Edge e : adjList[minE.v]) {
				if (visited[e.v])
					continue;
				if (dist[e.v] > dist[minE.v] + e.cost) {
					dist[e.v] = dist[minE.v] + e.cost;
					pq.add(new Edge(e.v, dist[e.v]));
				}
			}
		}

		return dist[end];
	}
}
