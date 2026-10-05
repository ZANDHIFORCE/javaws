import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test2New {
	public static int N;
	public static int M=501;
	public static int[][] arr;
	public static int[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
			//500개 짜리 배열 인덱스에는 시작값을 넣고, 값에는 끝값을 넣는다.
		memo = new int[M];
		int maxLastSec  = 0;
		//입력값 파싱
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = e;
			maxLastSec = Math.max(maxLastSec, e);
			//동일한 시작이면 짧은 놈을 채택
			if(memo[s]!=0 && memo[s]<e) {
				continue;
			}
			memo[s] = e;
		}
		M = maxLastSec+1;
		

		int maxVal  = 0;
		//1. 각 시간별 최대 회의수를 기록
		int[] maxCnt = new int[M];
		Arrays.fill(maxCnt, -1);
		
		//pq를 선언, 가진 회의수가 많은 것이 우선순위
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {return -Integer.compare(a[1],b[1]);});
		//시간 0, 회의 수 0 으로 시작
		pq.add(new int[] {0,0});
		
		//2. 메인로직
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int time = temp[0];
			int cnt = temp[1];
			
			//가지치기: 만약 이미 가진회의수보다 크거나 같으면 
			if(maxCnt[time]>=cnt) {
				continue;
			}
			
			//시간별 최대 회의수 업데이트
			for(int i=time; i<M ;i++) {
				if(maxCnt[i]>cnt)
					break;
				maxCnt[i] = cnt;
			}
			
			//다음에 남은 회의를 체크
			int first=-1;
			for(int i=time;i<M;i++) {
				if(memo[i]==0) {
					continue;
				}
				first = time;
				break;
			}
			
			//남은 회의가 없으면 스킵
			if(first==-1) {
				maxVal = Math.max(cnt, maxVal);
				continue;
			}
			
			//남의 회의가 있으면 남은 회의들 전부 queue에 밀어넣기
			for(int i=first;i<M;i++) {
				//memo에 공백값은 스킵
				if(memo[i]==0) {
					continue;
				}
				//남은 모든 가능한 회의 삽입
				pq.add(new int[] {memo[i], cnt+1});
			}
		}
		
		//마지막 종료시간에서 제일 큰 회의 수 출력
		System.out.println(maxCnt[M-1]);
	}

}
