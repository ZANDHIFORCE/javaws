import java.util.Arrays;

public class BitMasking {
	public static int[] ori;
	public static int[] arr;
	public static boolean[] visited;
	public static int N;
	public static int R;
	public static void main(String[] args) {
		N=5;
		R=3;
		ori = new int[] {1,2,3,4,5};
		arr = new int[R];
		visited = new boolean[N];
		perm(0, 0);
		
	}
	public static void perm(int level, int flag) {
		if(level == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(( flag&(1<<i) ) != 0) {
				continue;
			}
			
			arr[level] = ori[i];
			perm(level+1, flag|1<<i);
			
			
		}
		
	}
	
}
