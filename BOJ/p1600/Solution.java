package p1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int M;
	public static int K;
	public static int minVal=Integer.MAX_VALUE;
	public static int[][] map;
	public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int[][] hDirections = {{-2,-1},{-2,1},{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1}};
	
	public static void main(String[] args) throws IOException {
		//DFS로 푼다 BFS로는 안풀림
		//0. 입력
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N= Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//DFS
		for(int k=K;k>=0;k--) {
			dfs(0,0,K,0,new boolean[N][M]);
		}
		if(minVal==Integer.MAX_VALUE)
			minVal=-1;
		System.out.println(minVal);
	}
	public static void dfs(int ci, int cj, int k, int count, boolean[][] visited) {
		if(ci==N-1 && cj == M-1) {
			minVal = Math.min(minVal, count);
			return;
		}
		//말 이동
		if(k>=1) {
			for(int[] hD:hDirections) {
				int ni = ci+hD[0];
				int nj = cj+hD[1];
				if(ni<0||nj<0||ni>=N||nj>=M)
					continue;
				if(visited[ni][nj])
					continue;
				if(map[ni][nj]==1)
					continue;
				visited[ni][nj]=true;
				dfs(ni,nj,k-1,count+1,visited);
				visited[ni][nj]=false;
			}
		}
		//한칸 전진!
		for(int[] d:directions) {
			int ni = ci+d[0];
			int nj = cj+d[1];
			if(ni<0||nj<0||ni>=N||nj>=M)
				continue;
			if(visited[ni][nj])
				continue;
			if(map[ni][nj]==1)
				continue;
			visited[ni][nj]=true;
			dfs(ni,nj,k,count+1,visited);
			visited[ni][nj]=false;
		}

	}

}
