package Week4.BOJ_18353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18353 {
	
	// ���� ���� �κ� ����???
	//  Ư�� ��ġ�� �ִ� ���縦 ���� 
	// -> ���ʿ� �ִ� ������ �������� �� �ʿ� �ִ� ������ �����º��� ����
	// -> �����ִ� ������ ���� �ִ�
	// ������������ ���̰� �ִ� = �����ϴ� ����
	// �̺�Ž���� ����ϸ� �� �����ٰ� ��..
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] power = new int[N+1]; // ������ ����
        int[] dp = new int[N+1]; // dp
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
        	power[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        // ������������ ���̰� �ִ� = �����ϴ� ����
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(power[j]> power[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]); // ���� �� ���� ���� ����
        }

        System.out.println(N-max); // �迭�� ���� - ���� �� ���� ����
	}
}	
