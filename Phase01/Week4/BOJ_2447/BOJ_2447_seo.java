package Study08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447_seo {
	
	static char[][] arr;
	static int n;
	
	public static void main(String[] args)  throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new char[n][n];
        star(0,0,n,false);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for ( int i=0 ; i<n ; i++ ) {
        	for ( int j=0; j<n ; j++ ) {
        		sb.append(arr[i][j]);
        	}
        	sb.append('\n');
        }
        System.out.println(sb);
        
	}
	
	public static void star(int x, int y, int size, boolean empty) {
		// 빈칸이라면
		if (empty) {
			for ( int i=x ; i<x+size ; i++ ) {
				for ( int j=y ; j<y+size ; j++ ) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		
		// 사이즈가 1이라면
		if (size==1) {
			arr[x][y]='*';
			return;
		}
		
		int block = size/3; // 블록 한칸을 담을 변수
		int cnt = 0; // 별 누적 수
		for ( int i=x ; i<x+size ; i+=block ) {
			for ( int j=y ; j<y+size ; j+=block ) {
				cnt++; 
				// 별출력 5번째는 공백
				if (cnt==5) star(i,j,block,true);
                else star(i,j,block,false);
			}
		}
	}
}
