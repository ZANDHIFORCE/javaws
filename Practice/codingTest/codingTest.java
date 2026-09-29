package codingTest;

import java.io.*;
import java.util.*;

public class codingTest {
	static int T,N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int[] dpList;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		for(int testCase=1;testCase<=T;testCase++) {
			init();
			System.out.println("#" + testCase + " " + bfs());
		}
	}
	
	public static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dpList = new int[1<<N];
		for (int i = 0; i < dpList.length; i++) {
		    dpList[i] = Integer.MAX_VALUE;
		}
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static int bfs() {
		Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
		queue.add(new int[] {0,0,0});
		
		while(true) {
			int[] temp = queue.poll();
			int depth = temp[0];
			int visited = temp[1];
			int sum = temp[2];
			
			if(depth == N) return sum;
			if(dpList[visited]<sum) continue;
			
			for(int x=0;x<N;x++) {
				if((visited & (1<<x))!=0) continue;
				int nextSum = sum+map[depth][x];
				int nextVisited = visited | (1<<x) ;
				
				if(dpList[nextVisited]<nextSum) continue;
				
				queue.add(new int[] {depth + 1, nextVisited,nextSum});
				dpList[nextVisited] = nextSum;
			}
		}
	}
}
