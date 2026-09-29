package fPerm;

import java.util.Arrays;

//5P3
public class Main {
	public static int N;
	public static int R;
	public static int[] p;
	public static int[] nums;
	public static void main(String[] args) {
		N = 5;
		R = 3;
		p = new int[]{1,2,3,4,5};
		nums = new int[R];
		perm(0,0);
	}
	public static void perm(int cnt, int flag) {
		if(cnt==R) {
			System.out.println("flag: "+ new StringBuilder(Integer.toBinaryString(flag)).reverse());
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i=0;i<N;i++) {
			//방문이면 스킵
			if((flag&1<<i)!=0) {
				continue;
			}
			//방문처리
			flag |= 1<<i;
			nums[cnt] = p[i];
			//재귀
			perm(cnt+1, flag);
			//백트래킹
			nums[cnt] = 0;
			flag &= ~(1<<i);
		}
	}
}
