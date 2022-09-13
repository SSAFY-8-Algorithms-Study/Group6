package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ_2310 {
	static class Room {
		String info;
		int cost;
		ArrayList<Integer> next;
	}

	static int n;
	static Room[] room;
	static boolean ans;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("0")) {
			n = Integer.parseInt(s);
			room = new Room[n + 1];
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				room[i] = new Room();
				room[i].info = st.nextToken();
				room[i].cost = Integer.parseInt(st.nextToken());

				int next_room;
				room[i].next = new ArrayList<>();
				while ((next_room = Integer.parseInt(st.nextToken())) != 0) {
					room[i].next.add(next_room);
				}
			}
			visited = new int[n + 1];
			for(int i=1; i<=n; i++) {
				visited[i] = -1;
			}
			ans = false;
			dfs(1, 0);
			if (ans) {
				sb.append("Yes" + "\n");
			} else {
				sb.append("No" + "\n");
			}

		}
		System.out.println(sb);
	}

	static void dfs(int idx, int money) {
        if(ans)
            return;
		if (idx == n) {
			if (room[idx].info.equals("T")) {
				if (money >= room[idx].cost)
					ans = true;
				return;
			}
			ans = true;
			return;
		}
		if (room[idx].info.equals("T")) {
			if (money >= room[idx].cost) {
				money -= room[idx].cost;
				if(visited[idx] >= money) 
					return;
				visited[idx] = money;
				for (int i = 0; i < room[idx].next.size(); i++) {
					dfs(room[idx].next.get(i), money);
				}
			}
		} else if (room[idx].info.equals("L")) {
			if (money < room[idx].cost) {
				money = room[idx].cost;
			}
			if(visited[idx] >= money) 
				return;
			visited[idx] = money;
			for (int i = 0; i < room[idx].next.size(); i++) {
				dfs(room[idx].next.get(i), money);
			}

		} else if (room[idx].info.equals("E")) {
			if(visited[idx] >= money) 
				return;
			visited[idx] = money;
			for (int i = 0; i < room[idx].next.size(); i++) {
				dfs(room[idx].next.get(i), money);
			}
		}
	}
}
