package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int up=0, down =0, cnt=0; // up : 분자, down : 분모, cnt : X 횟수 카운트
		
		for(int i=0; i<=X/2; i++) {
			if(cnt==X)
				break;
			if(i%2==1) { //j가 오름차순과 내림차순이 번갈아 나오도록 함.
				for(int j=0; j<=i; j++) {
					cnt++;
					up = j+1;
					down = i-j+1;
					
					if(cnt==X)
						break;
				}
			}
			
			else {
				for(int j=i; j>=0; j--) {
					cnt++;
					up = j+1;
					down = i-j+1;
					if(cnt==X)
						break;
				}
			}
		}
		System.out.println(up+"/"+down);
	}

}
