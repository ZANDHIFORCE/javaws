package nextPerm;

import java.util.Arrays;

public class StdMain {
	public static void main(String[] args) {
		int[] p = {1,2,3,4,5};
		
		do {
			System.out.println(Arrays.toString(p));
		}while(nPerm(p));

	}
	public static boolean nPerm(int[] p) {
		int N = p.length;
		
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) {
			i--;
		}
		
		if(i==0) {
			return false;
		}
		
		int j = N-1;
		while(p[i-1]>=p[j]) {
			j--;
		}
		
		swap(p, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(p,i++,k--);
		}
		
		return true;
	}
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
