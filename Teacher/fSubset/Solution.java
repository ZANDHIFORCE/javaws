package fSubset;

public class Solution {
	static int[] p = {1,2,3,4,5};
	static int N;
	static int flag;
	static int count;
	
	public static void main(String[] args) {
		N = p.length;
		flag = 0;
		perm(0);
	}
	static void perm(int cnt) {
		//1. 종료조건
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				if((flag&1<<i)!=0) {
					System.out.print(p[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		//2. 선택했다
		flag|=1<<cnt;
		perm(cnt+1);
		//3. 안선택했다.
		flag&=~(1<<cnt);
		perm(cnt+1);
	}
}