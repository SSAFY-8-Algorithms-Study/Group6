package Week4.BOJ_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_seo {
	
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        ArrayList<Point> point; // ����̳� ��, ������, ��Ÿ��Ʈ �� �佺Ƽ�� ��ǥ
        
        int t = Integer.parseInt(br.readLine()); // test case
        for (int tc=0; tc<t; tc++) {
        	n = Integer.parseInt(br.readLine()); // ������ ����
        	point = new ArrayList<>();
        	
        	// 0�� ��, 1~n�� ������, n+1�� ���佺Ƽ��
        	for (int i = 0; i < n+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point.add(new Point(x, y)); 
            }
        	
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());  // �׷��� �ʱ�ȭ
            }
            for (int i = 0; i < n + 2; i++) { 
                for (int j = i + 1; j < n + 2; j++) {
                    if (Math.abs(point.get(i).x - point.get(j).x) 
                    		+ Math.abs(point.get(i).y - point.get(j).y) <= 1000) { // ����ư �Ÿ�
                        graph.get(i).add(j);
                        graph.get(j).add(i); // ����� �׷���
                    }
                }
            }
            
            sb.append(bfs()+"\n");
        }
        
        System.out.println(sb);
	}
	
	// bfs
	private static String bfs() {
		Queue<Integer> que = new LinkedList<>();
        que.offer(0);
 
        boolean[] visited = new boolean[n+2];
        visited[0] = true;
 
        while (!que.isEmpty()) {
            int now = que.poll();
 
            if (now == n+1) return "happy"; // �佺Ƽ�� ����
 
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }
		return "sad"; // �佺Ƽ�� ����
	}

	static class Point {
	    int x;
	    int y;
	 
	    Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
}
