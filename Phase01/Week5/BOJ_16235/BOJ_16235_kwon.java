package study_group_06.week05;

import java.io.*;
import java.util.*;

/**
 * 나무 재테크 해당 문제는 시뮬레이션 문제 봄, 여름, 가을, 겨울의 기능을 각각 구현할 것
 */

public class Problem_16235 {
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static int N, M, K;
	static int[][] map;
	static int[][] s2d2;

	static LinkedList<Tree> Qtree;
	static LinkedList<Tree> Qdead;

	static class Tree {
		int x, y;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		s2d2 = new int[N][N];

		Qtree = new LinkedList<>();
		Qdead = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				s2d2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x, y, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());

			Qtree.addLast(new Tree(x, y, z));
		}

		for (int i = 1; i <= K; i++) {

			// 나이순으로 정렬
			if (!Qtree.isEmpty()) {
				Qtree.sort(new Comparator<Tree>() {
					@Override
					public int compare(Tree o1, Tree o2) {
						if (o1.age > o2.age)
							return 1;
						else if (o1.age < o2.age)
							return -1;
						else
							return 0;
					}
				});
			}

			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(Qtree.size());

		br.close();
	}

	// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
	// 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
	// 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
	// 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
	static void spring() {
		Tree tree;
		int qSize = Qtree.size();

		for (int i = 0; i < qSize; i++) {
			tree = Qtree.pollFirst();
			if (map[tree.x][tree.y] >= tree.age) {
				map[tree.x][tree.y] -= tree.age;
				tree.age++;
				Qtree.addLast(tree);
			} else {
				Qdead.addLast(tree);
			}
		}
	}

	// 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
	// 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
	// 소수점 아래는 버린다.
	static void summer() {
		Tree tree;
		int qSize = Qdead.size();

		for (int i = 0; i < qSize; i++) {
			tree = Qdead.pollFirst();
			map[tree.x][tree.y] += tree.age / 2;
		}
	}

	// 가을에는 나무가 번식한다.
	// 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
	// 어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1),
	// (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
	// 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
	static void fall() {
		Tree tree;
		int qSize = Qtree.size();

		int nx, ny;

		for (int i = 0; i < qSize; i++) {
			tree = Qtree.pollFirst();
			if (tree.age % 5 == 0) {
				for (int d = 0; d < dx.length; d++) {
					nx = tree.x + dx[d];
					ny = tree.y + dy[d];

					if (nx < 0 || N <= nx || ny < 0 || N <= ny)
						continue;

					Qtree.addLast(new Tree(nx, ny, 1));
				}
			}
			Qtree.addLast(tree);
		}
	}

	// 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
	// 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += s2d2[i][j];
			}
		}
	}
}
