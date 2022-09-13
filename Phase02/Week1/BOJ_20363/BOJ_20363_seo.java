package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20363_seo {
	
	// 햇빛 +1 -> 온기 +1,  햇빛 +10 -> 수분 -1
	// 물 +1 -> 수분 +1,   물 +10 -> 온기 -1
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int total = 0;
		
		if (x>=y) {
			total += (x+y);
			total += y/10;
		} else {
			total += (y+x);
			total += x/10;
		}
		System.out.println(total);
	}
}
