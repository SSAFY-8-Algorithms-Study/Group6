package Study08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2304_seo {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[1001]; // 전체 면적 배열
		int n = Integer.parseInt(br.readLine()); // 기둥 개수
		int minIdx=1001, maxIdx=0; // 건물 세워져 있는 구간
		int top=0, topIdx=0; // 건물의 최대 높이
		int result=0; // 면적
		
		// 건물 정보 입력
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			arr[idx] = Integer.parseInt(st.nextToken());
			if (idx<minIdx) minIdx=idx; // 구간 최소 번호
			if (idx>maxIdx) maxIdx=idx; // 구간 최대 번호
			if (arr[idx]>top) {
				top = arr[idx]; // 최대 높이
				topIdx = idx; // 최대 높이 번호
			}
		}
		result+=top;
		//System.out.println(minIdx+" "+topIdx+" "+maxIdx);
		//System.out.println(Arrays.toString(arr));
		
		
		// 왼쪽 지붕 세우기
		for (int i=minIdx; i<topIdx; i++) {
			if (arr[i]>arr[i+1]) arr[i+1]=arr[i]; 
			result+=arr[i];
			
		}
		// 오른쪽 지붕 세우기
		for (int i=maxIdx; i>topIdx; i--) {
			if (arr[i-1]<arr[i]) arr[i-1]=arr[i]; 	
			result+=arr[i];
		}
		
		
		//System.out.println(Arrays.toString(arr));
		System.out.println(result);
	}
}
