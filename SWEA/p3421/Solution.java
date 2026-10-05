package p3421;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static boolean[][] banMap;
	public static int[] ori;
	public static int[] arr;
	public static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/p3421/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1;test_case<=T;test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			//초기화
			banMap= new boolean[N+1][N+1];
			ori = new int[N+1];
			arr = new int[N+1];
			cnt = 0;
			for(int i=1;i<=N;i++) {
				ori[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				banMap[s][e] = true;
				banMap[e][s] = true;
			}
			
			for(int i=0;i<=N;i++) {
				combi(1, 1, 0, i);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(cnt);
			System.out.println(sb);
			
		}


	}
	public static void combi(int dept, int start, int flag, int R) {
		int N = arr.length-1;
		
		if(dept==R+1) {
			//1에서 R까지 검사링
			//System.out.println(Arrays.toString(arr));
			cnt++;
			return;
		}
		for(int i=start;i<=N;i++) {
			//visited[i] == true; -> skip
			if((flag&1<<i)!=0) {
				continue;
			}
			
			int flag2 = flag;
			flag2|=(1<<i);
			for(int j=1;j<=N;j++) {
				if(i==j) {
					continue;
				}
				if(banMap[i][j]==false) {
					continue;
				}
				flag2|=(1<<j);
			}
			//넣기
			arr[dept] = i;
			//visited[i] = true;
//			flag|=(1<<i);
			//dfs
			combi(dept+1, i+1, flag2, R);
			//visited[i] = false;
//			flag&=~(1<<i);
			//빼기
//			arr[dept] = 0;
			
		}
	}

}
