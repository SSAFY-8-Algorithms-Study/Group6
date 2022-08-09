package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_hwang {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine()); //검은 색종이 수
		boolean[][] paper = new boolean[100][100]; //흰 도화지
		int area = 0; //색종이가 붙어 있는 영역의 넓이
		
		for(int tc=0; tc<num; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x; i<x+10; i++) { //도화지가 있는 위치는 1로 값을 변환.
				for(int j=y; j<y+10; j++) {
					paper[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j] == true)
					area++;
			}
		}
		
		System.out.println(area);
	}

}
