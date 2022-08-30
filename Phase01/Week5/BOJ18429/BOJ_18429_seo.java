package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_seo {
	// 3대 500 -> 하루가 지날수록 k씩 감소
	// n개의 운동키트 
	// -> 사용 시 중량 즉시 증가, 증가량이 같아도 다른 기구면 다른 취급, n일동안 한번씩 사용 가능
	// 어떤 시점이라도 500보다 작아지지 않도록
	
	static int n, k, result;
	static int[] arr, list;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		list = new int[n];
		select = new boolean[n];
		result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0, 500);
		
		System.out.println(result);
	}

	private static void perm(int idx, int weight) {
		
		if (weight<500) return;
		if (idx==n) {
			//System.out.println(Arrays.toString(list));
			result++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			if(select[i]) continue;
			select[i] = true;
			list[idx] = arr[i];
			perm(idx+1, weight-k+arr[i]);
			select[i] = false;
		}
	}
}