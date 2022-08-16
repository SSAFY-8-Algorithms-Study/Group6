package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n, m;
	static int[][] maze, count;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// 문제 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		count = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String st2 = br.readLine().trim();
			for(int j=0; j<m; j++) {
				maze[i][j] = st2.charAt(j) - '0';
			}
		}
		// 문제 입력 끝
		
		count[0][0] = 1; // 시작점도 count
		bfs(0, 0);
		System.out.println(count[n-1][m-1]); // (n,m)의 최소경로 가짓수
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			for(int i=0; i<4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				if(visited[nx][ny]||maze[nx][ny]==0) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				count[nx][ny] = count[pos[0]][pos[1]] + 1;
			}
		}
	}
}
