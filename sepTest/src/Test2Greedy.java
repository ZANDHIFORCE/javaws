import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2Greedy {
	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		arr= new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort( arr, (a,b)->{ return Integer.compare(a[1], b[1]); } );
		int e=arr[0][1];
		int cnt=1;
		for(int i=1;i<N;i++) {
			if(e<arr[i][0] && e<arr[i][1]) {
				e = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
