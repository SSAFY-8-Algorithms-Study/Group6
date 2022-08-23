package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17608_hwang {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //end input
		
		int lastpillar = arr[N-1]; //마지막 막대기
		int cnt = 1; //보이는 막대기 수
		
		for(int i=N-1; i>=0; i--) {
			if(lastpillar < arr[i]) {
				lastpillar = arr[i]; //마지막 막대기보다 높지만 최고 높이의 막대기보다 앞 쪽에 있어서(index가) 보이지 않는 막대기가 있을 수 있기 때문에 이 부분이 없다면 틀림.
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
