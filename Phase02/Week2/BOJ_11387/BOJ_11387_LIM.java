
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class man {
	int attack;
	int force;
	double cri;
	double cri_damage;
	double speed;

	public man(int attack, int force, double cri, double cri_damage, double speed) {
		this.attack = attack;
		this.force = force;
		this.cri = cri;
		this.cri_damage = cri_damage;
		this.speed = speed;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a;

		man m1;
		man m2;
		man w1;
		man w2;
		int temp[] = new int[5];

		a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);

		for (int s = 0; s < 5; s++) {

			temp[s] = Integer.parseInt(st.nextToken());

		}

		m1 = new man(temp[0], temp[1], temp[2], temp[3], temp[4]);

		a = br.readLine();
		st = new StringTokenizer(a);

		for (int s = 0; s < 5; s++) {

			temp[s] = Integer.parseInt(st.nextToken());

		}

		m2 = new man(temp[0], temp[1], temp[2], temp[3], temp[4]);

		a = br.readLine();
		st = new StringTokenizer(a);

		for (int s = 0; s < 5; s++) {

			temp[s] = Integer.parseInt(st.nextToken());

		}

		w1 = new man(temp[0], temp[1], temp[2], temp[3], temp[4]);

		a = br.readLine();
		st = new StringTokenizer(a);

		for (int s = 0; s < 5; s++) {

			temp[s] = Integer.parseInt(st.nextToken());

		}

		w2 = new man(temp[0], temp[1], temp[2], temp[3], temp[4]);

		double ans1 = get_status(m1.attack, m1.force, m1.cri, m1.cri_damage, m1.speed);// man1 armed
		double ans2 = get_status(m2.attack, m2.force, m2.cri, m2.cri_damage, m2.speed); // man2 armed

		m1.attack -= w1.attack;
		m1.cri -= w1.cri;
		m1.cri_damage -= w1.cri_damage;
		m1.force -= w1.force;
		m1.speed -= w1.speed;

		m1.attack += w2.attack;
		m1.cri += w2.cri;
		m1.cri_damage += w2.cri_damage;
		m1.force += w2.force;
		m1.speed += w2.speed;

		// @@@

		m2.attack -= w2.attack;
		m2.cri -= w2.cri;
		m2.cri_damage -= w2.cri_damage;
		m2.force -= w2.force;
		m2.speed -= w2.speed;

		m2.attack += w1.attack;
		m2.cri += w1.cri;
		m2.cri_damage += w1.cri_damage;
		m2.force += w1.force;
		m2.speed += w1.speed;

		double ans3 = get_status(m1.attack, m1.force, m1.cri, m1.cri_damage, m1.speed);// man1 armed
		double ans4 = get_status(m2.attack, m2.force, m2.cri, m2.cri_damage, m2.speed); // man2 armed

		if (ans1 < ans3) {
			System.out.println("+");
		} else if (ans1 > ans3) {
			System.out.println("-");

		} else if (ans1 == ans3) {
			System.out.println("0");
		}

		if (ans2 < ans4) {
			System.out.println("+");
		} else if (ans2 > ans4) {
			System.out.println("-");

		} else if (ans2 == ans4) {
			System.out.println("0");
		}

		//System.out.println(ans1 + " " + ans3);

		//System.out.println(ans2 + "@" + ans4);

	}

	public static double get_status(int attack, double force, double cri, double cri_damage, double speed) {

		double res = 0;

		if (cri >= 100) {
			cri = 1;
		} else {
			cri = cri / 100;
		}

		if (cri_damage >= 100) {

			cri_damage = (int) cri_damage / 100 + (cri_damage % 100) / 100;
		} else {
			cri_damage = cri_damage / 100;
		}

		if (speed >= 100) {

			speed = (speed % 100) / 100 + (int) speed / 100;
		} else {
			speed = speed / 100;
		}

		// System.out.println("cri= "+cri+" cd= "+cri_damage+"spd= "+speed);

		res = attack * (1 + ((int) (force / 100) + ((force % 100) / 100))) * ((1.0 - cri) + (cri * cri_damage))
				* (1.0 + speed);

		return res;

	}

}
