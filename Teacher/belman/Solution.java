package belman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static class Edge {
		int s;
		int e;
		int v;
		public Edge(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/belman/bellman-ford-input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		//입력
		for(int test=1;test<=T;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Edge[] eList = new Edge[M];
			int inf = Integer.MAX_VALUE/3;
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				eList[m] = new Edge(s,e,v);
			}
			
			//벨만포드
			int[] dist = new int[N];
			Arrays.fill(dist, inf);
			dist[0] = 0;
			int rV = 0;
			outer:
			for(int t=1;t<=N;t++) {
				//엣지 반복
				boolean ch = false;
				for(int ed = 0; ed<M; ed++) {
					int s = eList[ed].s;
					int e = eList[ed].e;
					int v = eList[ed].v;
					
					if(dist[s]==inf) {
						continue;
					}
					
					int nv = dist[s]+v;
					if(dist[e] > nv) {
						ch=true;
						dist[e] = nv;
					}
				}
				
				//변한게 없으면 아예 종료
				if(ch==false) {
					rV=-1;
					break outer;
				}
				
				//마지막번째인데 변하면 음수 사이클
				if(t==N) {
					rV=-2;
					break outer;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append("\n");
			
			//음수사이클 발생
			if(rV==-2) {
				sb.append("-1");
				sb.append("\n");
			}else {
				//음수사이클 발생안함
				for(int no=1;no<N;no++) {
					if(dist[no]==inf) {
						sb.append("INF");
					}else {
						sb.append(dist[no]);
					}
					sb.append("\n");
				}
			}
			System.out.print(sb);
		}
	}

}
