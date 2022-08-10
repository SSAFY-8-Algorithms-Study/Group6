package Study;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_16992_seo {
	
	static int[] value = {1,5,10,50};
	static HashSet<Integer> set;
	static int[] arr;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		set = new HashSet<>();
		n = sc.nextInt();
		arr = new int[4];
		perm(0,0);
		System.out.println(set.size());
	}

	private static void perm(int idx, int sum) {
		if (idx==3) {
			arr[idx]=n-sum;
			//System.out.println(Arrays.toString(arr));
			int result=0;
			for (int i=0; i<4; i++) {
				for(int j=0; j<arr[i]; j++) {
					result+=value[i];
				}
			}
			set.add(result);
			return;
		}
		
		for (int i=0; i<=n-sum; i++) {
			arr[idx] = i;
			perm(idx+1, sum+i);
		}
	}

}
