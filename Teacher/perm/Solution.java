package perm;

import java.util.Arrays;

public class Solution {
	static int[] p = {1,2,3,4,5};
	static int N, R;
	static int[] num;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		N=p.length;
		R=3;
		num = new int[R];
		visited=new boolean[N];
		count = 0;
		perm(0);
		System.out.println(count);
	}
	static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(num));
			count++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i])continue;
			visited[i] =true;
			num[cnt]=p[i];
			perm(cnt+1);
			num[cnt]=0;
			visited[i]=false;
		}
	}
}
