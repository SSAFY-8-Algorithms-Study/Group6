package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2917_seo {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M, count;
	static int[] end, hyeon;
	static char[][] map;
	static int[][] visited, dijk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		map = new char[N][M];
		visited = new int[N][M];
		dijk =  new int[N][M];
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j]=='V') hyeon = new int[] {i, j};
				if (map[i][j]=='J') end = new int[] {i, j};
			}
		}
		
		//printmap();
		bfs();
		printVisited();
		System.out.println(count);
		djikstra();
		System.out.println(dijk[end[0]][end[1]]-1);
	}



	private static void djikstra() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				dijk[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point (hyeon[0], hyeon[1], visited[hyeon[0]][hyeon[1]]));
		dijk[hyeon[0]][hyeon[1]] =  visited[hyeon[0]][hyeon[1]];
		boolean finished = false;
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			
			for (int d=0; d<4; d++) {
				int nextx = now.x+dx[d];
				int nexty = now.y+dy[d];
				
				if (nextx<0 || nextx>=N || nexty<0 || nexty>=M) continue;
				
				//int total = visited[nextx][nexty]+dijk[now.x][now.y];
				int total = visited[nextx][nexty];
				if (dijk[nextx][nexty] <= total) continue;
				dijk[nextx][nexty]=Math.min(visited[nextx][nexty], dijk[now.x][now.y]);
				
				//System.out.println(nextx+" "+nexty+" "+visited[nextx][nexty]);
				if (nextx==end[0]&& nexty==end[1]) {
					finished = true;
					break;
				}
				pq.add(new Point(nextx, nexty, visited[nextx][nexty]));
				//printdijk();
			}
			if (finished) break;
		}
		//printdijk();
	}



	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j]=='+') {
					que.add(new int[] {i, j});
					visited[i][j] = 1;
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for (int d=0; d<4; d++) {
				int[] next = new int[2];
				next[0] = now[0] + dx[d];
				next[1] = now[1] + dy[d];
				
				if (next[0]<0 || next[0]>=N || next[1]<0 || next[1] >= M) continue;
				if (visited[next[0]][next[1]]==0) {
					que.add(new int[] {next[0], next[1]});
					visited[next[0]][next[1]] = visited[now[0]][now[1]] + 1;
				}
			}
			printVisited();
			count++;
		}
	}

	private static void printdijk() {
		System.out.println("------------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (dijk[i][j]>100) System.out.print("I ");
				else System.out.print(dijk[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void printmap() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void printVisited() {
		System.out.println("------------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static class Point implements Comparable<Point>{
		int x,y,dis;

		public Point(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			return o.dis-this.dis;
		}
	}
}
