package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22116_seo {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int n, result;
	static int[][] map;
	static int[][] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (n==1) System.out.println(0);
		else {
			dijkstra();
			System.out.println(result);
		}
	}

	
	private static void dijkstra() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				visited[i][j]=-1;
			}
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point (0,0,0));
		visited[0][0] = 0;
		
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			visited[now.x][now.y] = now.weight;
			result = Math.max(now.weight, result);
			
			if (now.x==n-1 && now.y==n-1) {
				//System.out.println("Á¾·á");
				//System.out.println(visited[n-1][n-1]);
				//printVisited();
				break;
			}
			
			//printVisited();
			for (int d=0; d<4; d++) {
				int nextx = now.x + dx[d];
				int nexty = now.y + dy[d];
				
				if (nextx<0 || nexty<0 || nextx>=n || nexty>=n || visited[nextx][nexty]!=-1) continue;
				
				int height = Math.abs(map[now.x][now.y]-map[nextx][nexty]);	
				pq.add(new Point(nextx, nexty, height));
			}
		}
		
	}
	
	

	private static void printVisited() {
		System.out.println("---------------");
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}



	static class Point implements Comparable<Point> {
		int x,y,weight;

		public Point(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight =weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
	}
	
	
}
