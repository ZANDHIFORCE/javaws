import java.util.Arrays;

public class nextPerm {
	public static char[] cArr;
	public static int[] ori;
	public static int N;
	public static void main(String[] args) {
		cArr = new char[] {'a', 'b', 'c', 'd'};
		N = cArr.length;
		ori = new int[N];
		
		for(int i=0;i<N;i++) {
			ori[i] = i;
		}
		
		do {
			//System.out.println(Arrays.toString(ori));
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) {
				sb.append(cArr[ori[i]]).append(" ");
			}
			System.out.println(sb);
		}while(nextPerm());

	}
	private static boolean nextPerm() {
		int i=N-1;
		while( !(i<=0 || ori[i-1]<ori[i]) ) {
			i--;
		}
		if(i==0) {
			return false;
		}
		
		int pivot = i-1;
		
		int j = N-1;
		while(!(ori[pivot]<ori[j])) {
			j--;
		}
		swap(pivot,j);
		
		int k = N-1;
		while(i<k) {
			swap(i,k);
			i++;
			k--;
		}
		
		return true;
	}
	private static void swap(int a, int b) {
		int temp = ori[a];
		ori[a] = ori[b];
		ori[b] = temp;
	}

}
