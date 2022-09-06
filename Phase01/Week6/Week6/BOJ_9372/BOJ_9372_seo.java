package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372_seo {
	
	// 구해야 하는 정답이 비행기를 타는 최소 횟수나 최단 거리였다면? bfs. MST등..
	// 비행기의 종류는? (국가의 수)-1
	// 노드 N개가 있으면 노드끼리 모두 연결되기 위해 최소 N-1개의 간선이 필요하다!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for (int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine()); 
			}
			sb.append((N-1)+"\n");
		}
		System.out.println(sb);
	}

}
