package study_group_06.week08;

import java.io.*;
import java.util.*;

public class Problem_11387 {

	static class Stat {
		int atk, str, crit, crit_mul, atk_spd;

		public Stat(int atk, int str, int crit, int crit_mul, int atk_spd) {
			this.atk = atk;
			this.str = str;
			this.crit = crit;
			this.crit_mul = crit_mul;
			this.atk_spd = atk_spd;
		}

		public void equip(Stat equip) {
			this.atk += equip.atk;
			this.str += equip.str;
			this.crit += equip.crit;
			this.crit_mul += equip.crit_mul;
			this.atk_spd += equip.atk_spd;
		}

		public void unequip(Stat equip) {
			this.atk -= equip.atk;
			this.str -= equip.str;
			this.crit -= equip.crit;
			this.crit_mul -= equip.crit_mul;
			this.atk_spd -= equip.atk_spd;
		}

		public long calcDamage() {
			long result = atk;

			result *= (100 + str);
			result *= (100 * (100 - Math.min(crit, 100)) + Math.min(crit, 100) * crit_mul);
			result *= (100 + atk_spd);

			return result;
		}

		public char compareToDamage(Stat equip1, Stat equip2) {
			long oldDamage = calcDamage();

			this.unequip(equip1);
			this.equip(equip2);

			long curDamage = calcDamage();

			int comp = Long.compare(curDamage, oldDamage);

			if (comp > 0) {
				return '+';
			} else if (comp < 0) {
				return '-';
			} else {
				return '0';
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		Stat cri = new Stat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		Stat pabu = new Stat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		Stat cri_weapon = new Stat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		Stat pabu_weapon = new Stat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		System.out.println(cri.compareToDamage(cri_weapon, pabu_weapon));
		System.out.println(pabu.compareToDamage(pabu_weapon, cri_weapon));

		br.close();
	}
}
