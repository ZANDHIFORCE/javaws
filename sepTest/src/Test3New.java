import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3New {
	//perm
	public static int[] ori;
	public static int[] arr;
	public static boolean[] visited;
	public static int R;
	public static int N;
	
	//내 카드 기록, 상대 카드 기록
	public static int[] op;
	public static int[] me;
	
	//승패 기록
	public static int opC;
	public static int meC;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		R = 9;
		N = 9;
		op = new int[9];
		arr = new int[R];
		for(int test_case = 1;test_case<=T;test_case++) {
			opC=0;
			meC=0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			boolean[] cardVisited = new boolean[19];
			int[] me = new int[9];
			//1. op 상대가 가진 카드 리스트
			for(int i=0;i<9;i++) {
				op[i] = Integer.parseInt(st.nextToken());
				cardVisited[op[i]] = true;
			}
			//2. me 내가 가진 카드 리스트 
			int cardCnt=0;
			for(int i=1;i<=18;i++) {
				if(cardVisited[i]==false) {
					cardVisited[i] = true;
					me[cardCnt++] = i;
				}
				
			}

			//3. 대결 시뮬레이션(제출된 카드의 합을 먹는다)
			ori = me;
			visited = new boolean[R];
			perm(0);
			
			//4. 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(opC).append(" ").append(meC);
			System.out.println(sb);
		}


	}
	public static void perm(int level) {
		//종료조건
		if(level==R) {
			int opS=0;
			int meS=0;
			//라운드 시뮬: 점수 쌓기
			for(int i=0;i<R;i++) {
				//내가 이김
				if(op[i]<arr[i]) {
					meS += (op[i]+arr[i]);
				}//내가 짐
				else {
					opS += (op[i]+arr[i]);
				}
			}
			//내가 승리
			if(meS>opS) {
				meC++;
			}//적이 승리
			else {
				opC++;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] == false) {
				visited[i]=true;
				//int memo = arr[level];
				arr[level] = ori[i];
				perm(level+1);
				//arr[level] = memo;
				visited[i]=false;
			}
		}
		
	}
}
