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
        
        ArrayList<Point> point; // 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
        
        int t = Integer.parseInt(br.readLine()); // test case
        for (int tc=0; tc<t; tc++) {
        	n = Integer.parseInt(br.readLine()); // 편의점 개수
        	point = new ArrayList<>();
        	
        	// 0번 집, 1~n번 편의점, n+1번 락페스티벌
        	for (int i = 0; i < n+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point.add(new Point(x, y)); 
            }
        	
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());  // 그래프 초기화
            }
            for (int i = 0; i < n + 2; i++) { 
                for (int j = i + 1; j < n + 2; j++) {
                    if (Math.abs(point.get(i).x - point.get(j).x) 
                    		+ Math.abs(point.get(i).y - point.get(j).y) <= 1000) { // 맨해튼 거리
                        graph.get(i).add(j);
                        graph.get(j).add(i); // 양방향 그래프
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
 
            if (now == n+1) return "happy"; // 페스티벌 도착
 
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }
		return "sad"; // 페스티벌 실패
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
