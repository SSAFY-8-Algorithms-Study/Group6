package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pipe {
	int x, y, direction;

	public Pipe(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}

public class BOJ_17070 {
	static int n, ans;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 1);
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int direction) {
		if(x==n-1&&y==n-1) {
			ans++;
			return;
		}

		int nx, ny;
		switch(direction) {
		case 1: // 가로
			nx=x;
			ny=y+1;
			if(ny<n&&map[nx][ny]==0)
				dfs(nx, ny, 1);
			
			break;
		case 2: // 세로
			nx=x+1;
			ny=y;
			if(nx<n&&map[nx][ny]==0) 
				dfs(nx, ny, 2);
			
			break;
		case 3: // 대각선
			nx=x;
			ny=y+1;
			if(ny<n&&map[nx][ny]==0)
				dfs(nx, ny, 1);
			
			nx=x+1;
			ny=y;
			if(nx<n&&map[nx][ny]==0) 
				dfs(nx, ny, 2);
			
			break;
		}
		nx=x+1;
		ny=y+1;
		if(nx>=0&&ny>=0&&nx<n&&ny<n&&map[nx][ny]==0&&map[nx-1][ny]==0&&map[nx][ny-1]==0) {
			dfs(nx, ny, 3);
		}
			
	}
}