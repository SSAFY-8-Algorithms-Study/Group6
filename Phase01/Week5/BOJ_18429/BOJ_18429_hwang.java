package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18429_hwang {
	
	static int N, K, ans;
	static int[] kit;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		kit = new int[N]; //키트 중량
		numbers = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		} //end input
			
		
		perm(0);
		System.out.println(ans);
	}

	static void perm(int cnt) {
		
		if(cnt == N) {
			int sum = 500;
			for(int i=0; i<N; i++) {
					sum -= K; 
					sum += kit[numbers[i]];
					if(sum<500) //합이 500미만인 경우 return 
						return;
			}
			ans++; //sum>=500 인 경우에만 여기까지 오기 때문에 여기서 ans++해줌
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}
