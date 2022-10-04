package Week4.BOJ_1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_seo {
	// 한수는 왼쪽 아래점, 집은 오른쪽 위
	// 거리가 K인 가짓수 출력 
	// 최단거리를 구하는 것이 아님 -> dfs?? -> 완탐해야함
	
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static boolean[][] visited;
	static int R,C,K, ans;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
    	for (int i = 0; i < R; i++) {
    		String str = br.readLine();
    		for (int j = 0; j < C; j++) {
    			map[i][j] = str.charAt(j);
    		}
    	}
    	
    	visited[R-1][0] = true; // 시작점 방문체크
    	dfs(R-1,0,1);   
    	System.out.println(ans);
	}
	
	static void dfs(int x, int y, int distance){
		// System.out.println(x+" "+y+" "+distance);
	    if(distance==K && x==0 && y==C-1) { // 거리가 K를 만족하고 목적지에 도달했다면
	    	ans++; // 가짓수 추가
	    	return;
	    }
	    
	    for(int i = 0; i < 4; i++){
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        
	        
	        if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue; // 범위 밖
	        if(map[nx][ny] == 'T') continue; // 못지나감 
	        if(visited[nx][ny]) continue; // 방문한 적이 있음
	        visited[nx][ny] = true;
	        dfs(nx, ny, distance + 1);
	        visited[nx][ny] = false;
	    }
	}
}
