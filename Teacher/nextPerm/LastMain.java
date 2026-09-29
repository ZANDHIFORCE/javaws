package nextPerm;

import java.util.Arrays;

public class LastMain {

	public static void main(String[] args) {
		int[] p = {1,2,3,4,5};
		do {
			System.out.println(Arrays.toString(p));
		}while(nextPerm(p));

	}
	public static boolean nextPerm(int[] p) {
		int N = p.length;
		//1. pivot 전 찾기(못찾으면 false)
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) {
			i--;
		}
		if(i==0) {
			return false;
		}
		//2. right에서 큰놈 찾기 (pivot+1 까지)
		int j = N-1;
//		while(i<=j) {
//			if(p[i-1]<p[j]) {
//				//3. swap
//				swap(p,i-1,j);
//				break;
//			}
//			j--;
//		}
		while(p[i-1]>=p[j]) {
			j--;
		}
		swap(p,i-1,j);
		
		//4. pivot+1부터 마지막까지 swap
		int k = N-1;
		while(i<k) {
			swap(p,i++,k--);
		}
		
		return true;
	}
	public static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
}
