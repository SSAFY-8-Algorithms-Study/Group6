package Week4.BOJ_18353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18353 {
	
	// 최장 증가 부분 수열???
	//  특정 위치에 있는 병사를 제거 
	// -> 앞쪽에 있는 병사의 전투력이 뒤 쪽에 있는 병사의 전투력보다 높게
	// -> 남아있는 병사의 수가 최대
	// 내림차순으로 길이가 최대 = 감소하는 수열
	// 이분탐색을 사용하면 더 빠르다고 함..
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] power = new int[N+1]; // 전투력 저장
        int[] dp = new int[N+1]; // dp
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
        	power[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        // 내림차순으로 길이가 최대 = 감소하는 수열
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(power[j]> power[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]); // 가장 긴 증가 수열 저장
        }

        System.out.println(N-max); // 배열의 길이 - 가장 긴 증가 수열
	}
}	
