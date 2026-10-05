package p17490;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
	public static int N;
	public static long[] Stone; 
	public static int B;
	public static long K;
	public static List<Integer>[] bList;
	public static int[] p;
//	public static int[] r;
	public static void main(String[] args) throws Exception{
		//union find
		//combi with 비트마스킹
		
		System.setIn(new FileInputStream("src/p17490/test_input1.txt"));
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		Stone = new long[N];
		B = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		bList = new ArrayList[N];
		p = new int[N];
		for(int i=0;i<N;i++) {
			p[i] = i;
		}
		for (int i = 0; i < bList.length; i++) {
			bList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			Stone[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			bList[s].add(e);
			bList[e].add(s);
		}
		
//		//1. 조합
//		for (int i = 0; i < N; i++) {
//			for (int j = i+1; j < N; j++) {
//				boolean cut = false;
//				for(int b: bList[i]) {
//					if(j==b) {
//						cut=true;
//						break;
//					}
//				}
//				if(cut) {
//					continue;
//				}
//				//2. 유니온
//				union(i,j);
//			}
//		}
		
		for(int i=0;i<N;i++) {
			int ni = (i+1)%N;
			boolean cut = false;
			//잘렸는지 체크
			for(int b: bList[i]) {
				if(b==ni) {
					cut=true;
					break;
				}
			}
			if(cut) {
				continue;
			}
			//안잘렸으면 union
			union(i,ni);
		}
		boolean[] visited = new boolean[N];
		long sCnt=0;
		int cCnt=0;
		for(int i=0;i<N;i++) {
			int head = find(i);
			if(visited[head]) {
				continue;
			}
			cCnt++;
			visited[head] = true;
			sCnt+=Stone[head];
		}
		
		if(cCnt==1) {
			sCnt=0;
		}
		
		if(sCnt>K) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
	}
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) {
			return false;
		}
		
		if(Stone[x]>Stone[y]) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		p[y] = p[x];
		
		return true;
		
	}
	public static int find(int x) {
//		if(p[x]==x) {
//			return p[x]; 
//		}
//		return p[x] = find(p[x]);
		
		int root = x;
		while(p[root]!=root) {
			root = p[root];
		}
		
		while(x!=root) {
			int next = p[x];
			p[x] = root;
			x = next;
		}
		
		return root;
	}
}
