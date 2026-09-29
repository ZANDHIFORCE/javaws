package p1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfsMain{
	public static boolean[][][] VISITED;
	public static int[][] MAP;
	public static int N;
	public static int M;
	public static int K;
	public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int[][] hDirections = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		MAP=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		VISITED = new boolean[K+1][N][M];
		
		//bfs
//		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return Integer.compare(a[3],b[3]);});
		Queue<int []> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0,K,0});
		VISITED[K][0][0]=true;
		//System.out.println(toString(VISITED));
		int answer = -1;
		Loop1:
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int ci = temp[0];
			int cj = temp[1];
			int k =temp[2];	//남은 점프 수
			int cnt = temp[3];	//걸린 시간
			//종료
			if(ci==N-1 && cj==M-1) {
				answer = cnt;
				break Loop1;
			}
			
			//그냥이동
			for(int[] d:directions) {
				int ni = ci+d[0];
				int nj = cj+d[1];
				//범위 벗어나면 스킵
				if(ni<0||nj<0||ni>=N||nj>=M) {
					continue;
				}
				//0이 아니면 스킵
				if(MAP[ni][nj]!=0) {
					continue;
				}
				//방문한 곳이면 스킵
				if(VISITED[k][ni][nj]) {
					continue;
				}
				
				VISITED[k][ni][nj]=true;
				queue.add(new int[] {ni,nj,k,cnt+1});
				//System.out.println(toString(VISITED));
			}
			
			//점프이동
			if(k>=1) {
				int nK = k -1;
				for(int[] hD:hDirections) {
					int ni = ci+hD[0];
					int nj = cj+hD[1];
					
					//범위 벗어나면 스킵
					if(ni<0||nj<0||ni>=N||nj>=M) {
						continue;
					}
					//0이 아니면 스킵
					if(MAP[ni][nj]!=0) {
						continue;
					}
					//방문한 곳이면 스킵
					if(VISITED[nK][ni][nj]) {
						continue;
					}
					
					VISITED[nK][ni][nj]=true;
					queue.add(new int[] {ni,nj,nK,cnt+1});
					//System.out.println(toString(VISITED));
				}
			}
			
			
			
		}
		System.out.println(answer);
	}
	public static String toString(boolean[][][] visited) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int k=0;k<=K;k++) {
				for(int j=0;j<M;j++) {
					if(visited[k][i][j]) {
						sb.append(1).append(" ");
					}else {
						sb.append(0).append(" ");
					}
				}
				sb.append(" | ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
