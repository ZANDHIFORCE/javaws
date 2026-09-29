package relaxedOnTheGrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int ci = Integer.parseInt(st.nextToken())-1;
			int cj = Integer.parseInt(st.nextToken())-1;
			map[ci][cj] = 1;
			int count = 0;
			for(int[] d :directions) {
				int ni = ci+d[0];
				int nj = cj+d[1];
				if(ni<0||nj<0||ni>=N||nj>=N)
					continue;
				if(map[ni][nj]!=0) {
					count++;
				}
			}
			if(count==3) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			
		}
	}

}
