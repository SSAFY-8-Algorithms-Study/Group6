package Study08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_seo {
	
	// 모두 같은 색으로 칠해져 있는지 각 종이 cnt개 검사
	// -> 다른색이면 4등분
	// -> 같은색이면 종료;
	
	static int[][] arr; // 종이 배열
	static int white, blue; // 하얀색, 파란색
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		// 종이 입력
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 종이 검사
		divide(0,0,N);
				
		System.out.println(white+"\n"+blue);
				
	}

	
	private static void divide(int x, int y, int size) {
		// 한 덩어리면 종료
		if ( check(x,y,size) ) return;
		
		// 아니라면 4등분
		size = size/2;
		//[0,0]
		divide(x, y, size);
		//[0,1]
		divide(x, y+size, size);
		//[1,0]
		divide(x+size, y, size);
		//[1,1]
		divide(x+size, y+size, size);	
		
	}

	
	public static boolean check( int x, int y, int size ) {
		
		// 색종이 1개 확인
		int num = arr[x][y]; // 첫 항 가져오기
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				if (arr[i][j]!=num) return false;
			}
		}
		
		// 개수 세기
		// System.out.println(x1+","+y1+":"+num);
		if ( num==0 ) white++;
		else blue++;
		return true;
		
	}
	
}
