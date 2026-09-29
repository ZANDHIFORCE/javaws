package jung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
	public static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int si = 0;
		int sj = 0;
		int count = 1;
		int d = 0;
		while(count<=n*m) {
			map[si][sj]=count;
			int ni = si+directions[d%4][0];
			int nj = sj+directions[d%4][1];
			//범위를 벗어나거나, 빈공간이 아닐때
			if((ni<0||nj<0||ni>=n||nj>=m) || map[ni][nj]!=0) {
				d++;
				ni = si+directions[d%4][0];
				nj = sj+directions[d%4][1];
			}
			//아니면 진행
			si = ni;
			sj = nj;
			//카운트 증가
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
