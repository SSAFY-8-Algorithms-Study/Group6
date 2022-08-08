package Study08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_seo {
	
	static int[][] time; // 시간표
	static int result, N; // 결과, 회의실 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 회의 수
		time = new int[N][2]; // 시간 테이블
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}
		
		// 두번째 기준 오름차순 > 첫번째 기준 오름차순 
		Arrays.sort(time, new Comparator<int[]>() {
		    @Override
			public int compare(int[] o1, int[] o2) {
		    	 if(o1[1] == o2[1])  return o1[0] - o2[0];
		    	 else return o1[1] - o2[1]; 
	        }
		});
		
//		for (int i=0; i<N; i++) {
//			System.out.print(time[i][0]+" ");
//			System.out.println(time[i][1]);
//		}
		
		earlyTime(0, 0);
		
		System.out.println(result);
		
	}


	private static void earlyTime(int start, int idx) {
		boolean exit=false;
		int early = Integer.MAX_VALUE;
		int newidx=-1;
		
		for (int i=idx; i<N; i++) {
			// 시작과 끝 시간이 같은 경우
			if (time[i][1]==time[i][0]) {
				early = time[i][1];
				newidx=i+1; 
				exit=true; // 업데이트 확인용
				break;
			}
			// 빠른 종료 시간 정보 업데이트
			if (early>time[i][1] && start<=time[i][0]) {
				early = time[i][1]; 
				exit=true; // 업데이트 확인용
				newidx=i;
				break;
			}
		}
		
		if (!exit) return; // 업데이트가 안됐으면 종료
		//System.out.println(early+"?"+newidx);
		result++;
		earlyTime(early, newidx);
	}
	
	
}
