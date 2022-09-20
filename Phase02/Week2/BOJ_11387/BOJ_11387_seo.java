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
		
		// 0: ũ��(����������), 1: �ĺ�(����������) 
		// 2: ũ�� ������ ���� ��ġ,  3: �ĺ� ������ ���� ��ġ
		// ��, ��, ũȮ, ũ��, ����
		stat = new int[4][5];
		
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		
		weapon_test(0,2,3); // ũ������, ũ���� �ĺ��� ���⸦ �����Ҷ�
		weapon_test(1,3,2); // �ĺα���, �ĺΰ� ũ���� ���⸦ �����Ҷ�
	}

	
	// ������ �׽�Ʈ
	private static void weapon_test(int equip, int user_weapon, int other_weapon) {
		user = new int[5];
		for (int i=0; i<5; i++) {
			user[i] = stat[equip][i] - stat[user_weapon][i]; // ������ ���� ���� ����
		}
		//System.out.println(Arrays.toString(user));
		
		long own_power = power(user_weapon);
		long other_power = power(other_weapon);
		
		if (own_power-other_power>0) System.out.println("-");
		else if(own_power-other_power<0) System.out.println("+");
		else System.out.println("0");
	}

	// ������ ���
	// ��, ��, ũȮ%, ũ��%, ����%
	// 100�� �����ϱ� ���� �ȳ��´� 100�� �����༭ ������ ���� ������ ����
	// �����÷ο� ������ test[]�迭���� long���� �ؾ��Ѵ�
	private static long power( int weapon) {
		//System.out.println((100 - min(user[2] + stat[weapon][2], 100)));
		long[] test = new long[5];
		for (int i=0; i<5; i++) {
			test[i] = user[i] + stat[weapon][i]; // ���� ���� �� ���� ����
		}
		
		long result = test[0] // ���ݷ�
				* (100 + test[1]) // ��
				* (10000 - 100 * min(test[2], 100) + min(test[2], 100) * (test[3]) ) 
				* (100 + test[4]); // ����
		//System.out.println(result);
		return result;
	}


	private static long min(long i, long j) {
		if (i>100) return 100;
		else return i;
	}

}