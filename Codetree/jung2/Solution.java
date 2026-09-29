package jung2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int si = (n-1)/2;
		int sj = (n-1)/2;
		int count = 1;
		int d = 0;
		while(count<=n*n) {
			map[si][sj] = count;
			//다음이 0일때 무브
			int ni = si+directions[d%4][0];
			int nj = sj+directions[d%4][1];
			//0이 아니면 방향 반대로 세팅하고 다음세팅해!
			if(map[ni][nj]!=0) {
				d--;
				ni = si+directions[d%4][0];
				nj = sj+directions[d%4][1];
			}
			
			si = ni;
			sj = nj;
			d++;
			count++;
		}
		System.out.println(toString(map));
	}
	public static String toString(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				sb.append(map[i][j]).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
