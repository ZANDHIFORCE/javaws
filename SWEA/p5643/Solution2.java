package p5643;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	public static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//0. 입력
		System.setIn(new FileInputStream("src/p5643/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test = 1; test<=T;test++) {

			//1      	// 전체 테스트케이스 개수
			//6     	// 첫 번째 TC의 N
			//6      	// 첫 번째 TC의 M
			//1 5    	// a b 비교
			//3 4    
			//5 4
			//4 2
			//4 6
			//5 2	
			
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			boolean[][] cn = new boolean[N][N];
			
			for(int m = 0; m<M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				cn[s][e] = true;
			}
			
			for (int i = 0; i < cn.length; i++) {
				cn[i][i] = true;
			}
			
			//워셜
			for (int k = 0; k < cn.length; k++) {
				for (int i = 0; i < cn.length; i++) {
					//i-k 없으면 패스
					if(cn[i][k]==false) {
						continue;
					}
					
					for (int j = 0; j < cn.length; j++) {
						cn[i][j] |= cn[k][j];
					}
				}
			}
			
			//cn[now][next]!=INF 나보다 next가 크다
			//cn[next][now]!=INF 나보다 next가 작다
			
			int answer = 0;
			for (int i = 0; i < cn.length; i++) {
				int count  = 0;
				for (int j = 0; j < cn.length; j++) {
					if(cn[i][j] || cn[j][i]) {
						count++;
					}
				}
				if(count==N) {
					answer++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append(" ").append(answer);
			System.out.println(sb);
			
		}
		
	}

}
