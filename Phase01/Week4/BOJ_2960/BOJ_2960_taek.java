package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2960 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> arr = new LinkedList<>();
		for(int i=2; i<=n; i++) {
			arr.add(i);
		}
		loop:
		while(true) {
			int t = arr.remove(0);
			k--;
			if(k==0) {
				System.out.println(t);
				break;
			}
				
			for(int i=0; i<arr.size(); i++) {
				if(arr.get(i)%t==0) {
					int s = arr.remove(i);
					i--;
					k--;
					if(k==0) {
						System.out.println(s);
						break loop;
					}				
				}				
			}
		}	
	}
}
