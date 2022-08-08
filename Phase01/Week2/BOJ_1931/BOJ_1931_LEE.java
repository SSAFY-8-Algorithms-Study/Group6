package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int arr[][] = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1]> b[1]) return 1;
				else if(a[1] == b[1]) {
					if(a[0] > b[0]) return 1;
					else if(a[0] == b[0]) return 0;
					else return -1;
				}
				else return -1;
			}
		});
		
		int cnt = 0;
		int prev = 0;
		for(int i=0; i<n; i++) {
			if(prev <= arr[i][0]) {
				prev = arr[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);
		
	}

}
