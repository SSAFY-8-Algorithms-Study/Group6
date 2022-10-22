package Phase03.Week1.BOJ_1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388_seo {
	
	static char[][] map;
	static boolean[][] visited;
	static int[] d= {-1,1};
	static int n,m,count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		count = 0;
		
		for ( int i=0 ; i<n ; i++ ) {
			String s = br.readLine();
			for ( int j=0 ; j<m ; j++ ) {
				map[i][j]=s.charAt(j);
			}
		}
		
		
		for ( int i=0 ; i<n ; i++ ) {
			for ( int j=0 ; j<m ; j++ ) {
				if ( map[i][j]=='-' && !visited[i][j] ) {
					if (j==m-1) count++;
					dfs1(i,j);
				}
				if ( map[i][j]=='|' && !visited[i][j] ) {
					if (i==n-1) count++;
					dfs2(i,j);
				}
			}
		}
		
		System.out.println(count);
	}
	
	
	static void dfs1 ( int x, int y ) {
		visited[x][y] = true;
		
		for ( int i=0 ; i<2 ; i++ ) {
			int a = x;
			int b = y+d[i];
			if ( b>=0 && b<m ) {
				if (!visited[a][b]) {
					if ( map[a][b]=='|' ) {
						//System.out.println("?"+a+" "+b);
						count++;
					}
				}
				
			}
		}
	}
	
	static void dfs2 ( int x, int y ) {
		visited[x][y] = true;
		for ( int i=0 ; i<2 ; i++ ) {
			int a = x+d[i];
			int b = y;
			if ( a>=0 && a<n ) {
				if (!visited[a][b]) {
					if ( map[a][b]=='-' ) {
						//System.out.println("!"+a+" "+b);
						count++;
					}
				}
			}
		}
	}

}
