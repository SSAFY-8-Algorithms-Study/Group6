package study_group_06.week08;

import java.io.*;
import java.util.*;

public class Problem_1504 {

	static int N, E;
	static Vertex[] vertices;

	static class Edge {
		int from;
		int to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static class Vertex {
		int no;
		ArrayList<Edge> edges;

		public Vertex(int no) {
			this.no = no;
			this.edges = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		vertices = new Vertex[N + 1];
		for (int i = 1; i <= N; i++)
			vertices[i] = new Vertex(i);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			vertices[a].edges.add(new Edge(a, b, c));
			vertices[b].edges.add(new Edge(b, a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		long path1 = 0, path2 = 0, tmp = 0;

		tmp = dijkstra(1, v1);
		path1 = (tmp != -1) ? path1 + tmp : tmp;
		if (path1 != -1) {
			tmp = dijkstra(v1, v2);
			path1 = (tmp != -1) ? path1 + tmp : tmp;
		}
		if (path1 != -1) {
			tmp = dijkstra(v2, N);
			path1 = (tmp != -1) ? path1 + tmp : tmp;
		}
		if (path1 == -1)
			path1 = Long.MAX_VALUE;

		tmp = dijkstra(1, v2);
		path2 = (tmp != -1) ? path2 + tmp : tmp;
		if (path2 != -1) {
			tmp = dijkstra(v2, v1);
			path2 = (tmp != -1) ? path2 + tmp : tmp;
		}
		if (path2 != -1) {
			tmp = dijkstra(v1, N);
			path2 = (tmp != -1) ? path2 + tmp : tmp;
		}
		if (path2 == -1)
			path2 = Long.MAX_VALUE;

		if (path1 == Long.MAX_VALUE && path2 == Long.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Math.min(path1, path2));

		br.close();
	}

	static long dijkstra(int start, int end) {
		PriorityQueue<Edge> PQ = new PriorityQueue<>((o1, o2) -> o1.weight > o2.weight ? 1 : -1);

		long[] VW = new long[N + 1];
		for (int i = 1; i <= N; i++)
			VW[i] = Long.MAX_VALUE;

		VW[start] = 0;
		PQ.add(new Edge(start, start, 0));

		while (!PQ.isEmpty()) {
			Edge e = PQ.poll();

			if (e.from == end)
				break;

			for (Edge edge : vertices[e.to].edges) {
				long weight = VW[edge.from] + edge.weight;
				if (weight < VW[edge.to]) {
					VW[edge.to] = weight;
					PQ.add(new Edge(edge.from, edge.to, edge.weight));
				}
			}
		}

		if (VW[end] == Long.MAX_VALUE)
			return -1;
		else
			return VW[end];
	}
}
