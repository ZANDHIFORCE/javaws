package p2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];
		dfs(0,0,n,n,1,map);
		System.out.println(toString(map));
		
	}
	public static void dfs(int si, int sj, int ei, int ej, int check, int[][] map) {
		if(check==0) {
			for(int i=si;i<ei;i++) {
				for(int j=sj;j<ej;j++) {
					map[i][j] = 0;
				}
			}
		}else {
			int len = (ei-si);
			if(len==1) {
				map[si][sj]=1;
				return;
			}
			
			int mul = len/3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					int ssi = si+i*mul;
					int ssj = sj+j*mul;
					int eei = ssi+mul;
					int eej = ssj+mul;
					int ccheck  = 1;
					if(i==1 && j==1)
						ccheck=0;
					dfs(ssi, ssj, eei, eej, ccheck, map);
				}
			}
		}

	}
	public static String toString(int[][] map) {
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				char temp = 'x';
				switch(map[i][j]) {
				case 0:
					temp=' ';
					break;
				case 1:
					temp='*';
					break;
				}
				sb.append(temp);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
