package p3421;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	public static int N;
	public static int M;
	public static boolean[][] banMap;
	public static int[] ori;
	public static int[] arr;
	public static int aCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/p3421/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1;test_case<=T;test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			//초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			banMap = new boolean[N+1][N+1];
			ori = new int[N];
			arr = new int[N];
			aCnt=0;
			
			for (int i = 0; i < ori.length; i++) {
				ori[i] = i+1;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				banMap[s][e] = true;
				banMap[e][s] = true;
			}
			
			for(int i=0;i<=N;i++) {
				combi(0, i, 0, 0);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(aCnt);
			System.out.println(sb);
			
		}
	}

	public static void combi(int cnt, int r, int start, int flag) {
		if(cnt==r) {
//			StringBuilder sb= new StringBuilder();
//			sb.append("[");
//			for(int i=0;i<r;i++) {
//				sb.append(arr[i]);
//			}
//			sb.append("]");
//			System.out.println(sb);
			aCnt++;
			return;
		}
		
		for(int i=start;i<N;i++) {
			if((flag&1<<i)!=0) {
				continue;
			}
			
			int flag2 = flag;
			flag2|=1<<i;
			for(int j=0;j<N;j++) {
				if(i==j) {
					continue;
				}
				if(banMap[ori[i]][ori[j]]==false) {
					continue;
				}
				flag2|=1<<j;
			}
			arr[cnt] = ori[i];
			combi(cnt+1, r, i+1, flag2);
			
		}
	}

}
