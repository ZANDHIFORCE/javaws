package p5251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static int V;
	public static int E;
	//자료저장 -> List[V]<int[endV, weight]>
	public static List<int[]>[] lMap;
	public static int inf = Integer.MAX_VALUE/3;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/p5251/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case<=T; test_case++) {
			//초기화
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			V = Integer.parseInt(st.nextToken())+1;
			E = Integer.parseInt(st.nextToken());
			lMap = new ArrayList[V];
			for (int i = 0; i < lMap.length; i++) {
				lMap[i] = new ArrayList<>();
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				lMap[s].add(new int[] {e,w});
			}
			
			//프림 알고리즘 pq<int[v, w]> //dist
			int[] dist = new int[V+1];
			Arrays.fill(dist, inf);
			dist[0] = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return Integer.compare(a[1], b[1]);});
			pq.add(new int[] {0,0});
			while(!pq.isEmpty()) {
				int[] temp = pq.poll();
				int v = temp[0];
				int w = temp[1];
				
				if(v==V-1) {
					dist[V-1] = w;
					break;
				}
				
				//가지치기1
				if(dist[v]<w) {
					continue;
				}
				
				for(int[] data : lMap[v]) {
					int nv = data[0];
					int nw = w+data[1];
					//가지치기
					if(dist[nv]>nw) {
						dist[nv]=nw;
						pq.add(new int[] {nv,nw});
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(dist[V-1]);
			System.out.println(sb);
		}
	}

}
