package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_10162 {
	static public void main(String []args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[3];
		
		if ( n<10 ) System.out.println("-1");
		else {
			while ( n>=300 ) {
				n-=300;
				arr[0]++;
			}
			while ( n>=60 ) {
				n-=60;
				arr[1]++;
			}
			while ( n>=10 ) {
				n-=10;
				arr[2]++;
			}
			if ( n!=0 ) System.out.println("-1");
			else {
				for ( int i=0 ; i<3 ; i++ ) {
					System.out.println(arr[i]);
				}
			}
		}
    }
}