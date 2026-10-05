package p7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int M;
	public static int[] p;
	public static int[] r;
	public static boolean[] checkHead;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//0. 입력
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//t 테이스 케이스
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//(1<=N(사람수)<=100) (0 ≤ M(줄수) ≤ N(N-1)/2)
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			for (int i = 0; i < p.length; i++) {
				p[i] = i;
			}
			r = new int[N+1];
			checkHead = new boolean[N+1];
			
			//x y
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				//1. 유니온 파인드
				union(x, y);
			}
			
			int count = 0;
			//2. for문 돌려서 새로운지 아닌지!
			for(int i=1;i<N+1;i++) {
				int head = find(i);
				if(checkHead[head]==false) {
					count++;
					checkHead[head]=true;
				}
			}
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(count);
			System.out.println(sb);
		}
		
		
		
		
		
	}
	private static void union(int x, int y) {
		// TODO Auto-generated method stub
		x = find(x);
		y = find(y);
		
		if(x==y) {
			return;
		}
		
		if(r[y]>r[x]) {
			int temp = x;
			x= y;
			y = temp;
		}
		
		r[x] += r[y];
		p[y] = p[x];
		
		return;
	}
	private static int find(int x) {
		if(p[x] == x) {
			return p[x];
		}
		
		return p[x] = find(p[x]);
	}

}
