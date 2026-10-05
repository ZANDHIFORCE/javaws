import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test3NextPerm {
	public static int N = 9;
	public static boolean[] visited;
	public static int[] op;
	public static int[] me;
	public static int[] ori;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		op = new int[N];
		me = new int[N];
		ori= new int[N];
		for(int test_case =1;test_case<=T;test_case++) {
			//ori 초기화
			for(int i=0;i<N;i++) {
				ori[i] =i;
			}
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			visited = new boolean[2*N+1];
			//상대 배열 확인
			for(int i=0;i<N;i++) {
				int cNum = Integer.parseInt(st.nextToken());
				visited[cNum] = true;
				op[i] = cNum;
			}
			//내 배열 확인
			int meCnt=0;
			for(int i=1;i<=2*N;i++) {
				if(visited[i]==false) {
					visited[i] = true;
					me[meCnt++] = i;
				}
			}
			
			int meWin=0;
			int opWin=0;
			do {
				//System.out.println(Arrays.toString(ori));
				int meScore=0;
				int opScore=0;
				for(int i=0;i<N;i++) {
					int opCard = op[i];
					int meCard = me[ori[i]];
					if(opCard<meCard) {
						meScore+=(opCard+meCard);
					}else {
						opScore+=(opCard+meCard);
					}
					
				}
				if(meScore>opScore) {
					meWin++;
				}else {
					opWin++;
				}
			}while(nextPerm());
			StringBuilder sb =new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(opWin).append(" ").append(meWin);
			System.out.println(sb);
			
		}
		
	}
	public static boolean nextPerm() {
		int i = N-1;
		while(i>0 && !(ori[i-1]<ori[i]) ) {
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
		
		swap(pivot, j);
		
		j = N-1;
		while(i<j) {
			swap(i++,j--);
		}
		
		return true;
	}
	public static void swap(int i, int j) {
		int temp = ori[i];
		ori[i] = ori[j];
		ori[j] = temp;
		return;
	}

}
