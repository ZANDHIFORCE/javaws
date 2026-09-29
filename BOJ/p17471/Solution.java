package p17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	public static int N;
	public static int[] people;
	public static int[][] map;
	public static int minVal = Integer.MAX_VALUE;
	public static int pTotal;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//구역 수
		N = Integer.parseInt(br.readLine());
		//구역에 사람 수
		people = new int[N];
		pTotal=0;
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
			pTotal+=people[i];
		}
		//연결..!
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++) {
				int node = Integer.parseInt(st.nextToken())-1;
				map[i][node] = 1;
			}
		}
		
		//1. 서브셋 뽑기(2. bfs하기)
		subSet(0, new boolean[N], 0);
		
		//3. 정답 출력
		if(minVal==Integer.MAX_VALUE)minVal=-1;
		System.out.println(minVal);
	}
	public static void subSet(int cnt, boolean[] subset, int tot) {
		//종료조건
		if(cnt==N) {
			//예시출력
//			for(int i=0;i<N;i++) {
//				if(visited[i]) {
//					System.out.print(i+" ");
//				}
//			}
//			System.out.println();
			
			//2. bfs로 visited 다 되는지 확인..!
			boolean[] visited = new boolean[N];
			
			Queue<int[]> queue = new ArrayDeque<>();
			//True팀 False팀 선별
			int tIdx=-1;
			int fIdx=-1;
			for(int i=0;i<N;i++) {
				if(subset[i]) {
					tIdx=i;
				}else {
					fIdx=i;
				}
				if(tIdx!=-1&&fIdx!=-1)
					break;
			}
			
			//진형이 하나뿐이면 강종
			if(tIdx==-1 || fIdx==-1)
				return;
			
			queue.add(new int[] {tIdx,1});
			visited[tIdx] = true;
			queue.add(new int[] {fIdx,0});
			visited[fIdx] = true;
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				int node = temp[0];
				int isTrue = temp[1];
				boolean team = isTrue==1?true:false;
				
				
				for(int j=0;j<N;j++) {
					//건너갈대상이 자신이면면 패스
					if(j==node)
						continue;
					//연결 안되어있으면 패스
					if(map[node][j]==0)
						continue;
					//방문했었다면
					if(visited[j])
						continue;
					//같은 팀 아니면 패스
					if(subset[j]!=team)
						continue;
					
					queue.add(new int[] {j,isTrue});
					visited[j]=true;
				}
			}
			
			
			//모두 방문되는지 체크
			int fCount = 0;
			for(boolean v:visited) {
				if(v==false)
					fCount++;
			}
			
			//모두 방문했다면 최솟값 갱신
			if(fCount==0)
				minVal = Math.min(Math.abs(pTotal-2*tot), minVal);
			return;
		}
		//아니면
		subset[cnt]=true;
		subSet(cnt+1, subset, tot+people[cnt]);
		subset[cnt]=false;
		subSet(cnt+1, subset, tot);
		return;
	}

}
