
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int ans = 0;

	static int N, K;

	public static void main(String[] args) throws IOException {

		int map[] = new int[1000001];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		

		for (int s = 0; s < N; s++) {
			a = br.readLine();
			st = new StringTokenizer(a);

			int first = Integer.parseInt(st.nextToken());// 얼음양
			int sec = Integer.parseInt(st.nextToken());// 양동이좌표

			map[sec] = first;

		}
		
		
		

		int sum = 0;

		
		
		
		
		 for (int i = 0; i < 1+2*K && i <= 1000000; i++) {
	            sum += map[i];
	        }
		 
		 
		 
	        int max = sum;
	        
	        
	        for (int i = 1+2*K, j = 0; i <= 1000000; i++, j++) {
	            sum -= map[j];
	            sum += map[i];
	            
	            if (sum > max)
	                max = sum;
	        }
	        
	        
	      

		System.out.println(max);

	}

}
