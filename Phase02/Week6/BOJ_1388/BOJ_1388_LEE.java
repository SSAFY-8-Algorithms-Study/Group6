package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int cnt = 0;
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) continue;
				visited[i][j] = true;
				cnt++;
				if(map[i][j]=='-') {
					for(int k=j+1; k<M; k++) {
						if(map[i][k]=='|') 
							break;
						visited[i][k] = true;
					}
				}else {
					for(int k=i+1; k<N; k++) {
						if(map[k][j]=='-')
							break;
						visited[k][j] = true;
					}
				}
			}
		}
		System.out.println(cnt);
				
	}
}
