package p4485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N=1;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] dist;
	public static int inf = Integer.MAX_VALUE/2;
	public static int[][] dire = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 1;
		while(true) {
			
			if(N==0) {
				return;
			}
			
			//0. 입력
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dist[i][j]=inf;
				}
			}
			
			int si = 0;
			int sj = 0;
			int ei = N-1;
			int ej = N-1;
			
			//(i,j,비용)
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{ return Integer.compare(a[2],b[2]);});
			dist[0][0] = map[si][sj];
			pq.add(new int[] {0,0,map[si][sj]});
			
			
			int answer = -1;
			
			while(!pq.isEmpty()){
				int[] temp = pq.poll();
				int ci = temp[0];
				int cj = temp[1];
				int value = temp[2];
				
				if(dist[ci][cj]<value) {
					continue;
				}
				
				//종료조건
				if(ci==ei && cj==ej) {
					answer = dist[N-1][N-1];
					break;
				}
				
				
				
				//4방탐색
				for(int[] d:dire) {
					int ni = ci+d[0];
					int nj = cj+d[1];
					
					//범위 벗어나면 
					if(ni<0||nj<0||ni>=N||nj>=N) {
						continue;
					}
					
					if(dist[ni][nj]>value+map[ni][nj]) {
						dist[ni][nj] = value+map[ni][nj];
						pq.add(new int[] {ni,nj,value+map[ni][nj]});
					}
				}
				
			}
			
			StringBuilder sb= new StringBuilder();
			sb.append("Problem ").append(test_case).append(": ").append(answer);
			System.out.println(sb);
			test_case++;
		}
		//1. dijkstra, priorityQueue 
	}

}
