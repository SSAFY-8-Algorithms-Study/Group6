package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_2304 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new TreeMap<>((o1, o2)->o1.compareTo(o2));
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Integer[] pos = map.keySet().toArray(new Integer[n]);
		Integer[] height = map.values().toArray(new Integer[n]);
		
		int max = 0;
		int index = 0;
		for(int i=0; i<n; i++) {
			if(height[i] > max) {
				max = height[i];
				index = i;
			}
		}

		int area = 0;
		int j=0;
		for(int i=0; i<index; i++) {
			if(height[i] > height[j]) {
				area += (pos[i]-pos[j]) * height[j];
				j = i;
			}
		}
		area += (pos[index]-pos[j]) * height[j];
		area += height[index];
		
		int k=n-1;
		for(int i=n-1; i>index; i--) {
			if(height[i] > height[k]) {
				area += (pos[k]-pos[i]) * height[k];
				k = i;
			}
		}
		
		area += (pos[k]-pos[index]) * height[k];
		
		System.out.println(area);
	}
}
