package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11387_seo {
	
	static int[][] stat;
	static int[] user;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 0: 크리(무기장착중), 1: 파부(무기장착중) 
		// 2: 크리 무기의 증가 수치,  3: 파부 무기의 증가 수치
		// 공, 힘, 크확, 크율, 공속
		stat = new int[4][5];
		
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		
		weapon_test(0,2,3); // 크리기준, 크리가 파부의 무기를 장착할때
		weapon_test(1,3,2); // 파부기준, 파부가 크리의 무기를 장착할때
	}

	
	// 전투력 테스트
	private static void weapon_test(int equip, int user_weapon, int other_weapon) {
		user = new int[5];
		for (int i=0; i<5; i++) {
			user[i] = stat[equip][i] - stat[user_weapon][i]; // 유저의 실제 스탯 저장
		}
		//System.out.println(Arrays.toString(user));
		
		long own_power = power(user_weapon);
		long other_power = power(other_weapon);
		
		if (own_power-other_power>0) System.out.println("-");
		else if(own_power-other_power<0) System.out.println("+");
		else System.out.println("0");
	}

	// 전투력 계산
	// 공, 힘, 크확%, 크율%, 공속%
	// 100을 나누니까 답이 안나온다 100을 곱해줘서 나누는 일이 없도록 하자
	// 오버플로우 때문에 test[]배열까지 long으로 해야한다
	private static long power( int weapon) {
		//System.out.println((100 - min(user[2] + stat[weapon][2], 100)));
		long[] test = new long[5];
		for (int i=0; i<5; i++) {
			test[i] = user[i] + stat[weapon][i]; // 무기 착용 시 스탯 저장
		}
		
		long result = test[0] // 공격력
				* (100 + test[1]) // 힘
				* (10000 - 100 * min(test[2], 100) + min(test[2], 100) * (test[3]) ) 
				* (100 + test[4]); // 공속
		//System.out.println(result);
		return result;
	}


	private static long min(long i, long j) {
		if (i>100) return 100;
		else return i;
	}

}