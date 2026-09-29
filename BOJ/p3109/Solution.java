package p3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int n;
	public static int m;
	public static int[][] directions = {{-1,1},{0,1},{1,1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력
		n = Integer.parseInt(st.nextToken());
		m =  Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<m;j++) {
				switch(line.charAt(j)) {
					case '.':
						map[i][j]=0;
						break;
					case 'x':
						map[i][j]=1;
						break;
				}
			}
		}
		
		//테스트 출력
		System.out.println(toString(map));
		
		int color = 2;
		for(int i=0;i<n;i++) {
			map[i][0] = color;
			if(dfs(i,0,0,color,map)) {
				color++;
			}else {
				map[i][0]=0;
			}
		}
		
		System.out.println(color-2);

	}
	public static boolean dfs(int ci, int cj, int level, int color, int[][] map) {
		//도착
		if(level==m-1) {
			return true;
		}
		boolean arrive=false;
		for(int[] d: directions) {
			int ni = ci+d[0];
			int nj = cj+d[1];
			if(ni<0 || nj <0 || ni>=n || nj >=m)
				continue;
			if(map[ni][nj]!=0)
				continue;
			
			map[ni][nj] = color;
			if(dfs(ni,nj,level+1,color,map))
				return true;
			map[ni][nj] = 0;
		}
		return false;

	}
	public static String toString(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
