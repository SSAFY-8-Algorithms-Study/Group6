package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int A = 300;
		int B = 60;
		int C = 10;
		int a = T/300;
		int b = (T%300)/60;
		int c = ((T%300)%60)/10;
		if((((T%300)%60)%10)==0){
			System.out.println(a+" "+b+" "+c);
		}
		else {
			System.out.println(-1);
		}
	}
}
