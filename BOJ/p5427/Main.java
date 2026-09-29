package p5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[][] map;
	public static int[][] drts = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			int si=-1;
			int sj=-1;
			List<Integer> fireList = new ArrayList<>();
			for(int i=0;i<N;i++) {
				String line = br.readLine().trim();
				for(int j=0;j<M;j++) {
					char c = line.charAt(j);
					int num = -1;
					switch(c) {
						case '.':	//빈공간
							num = 0;
							break;
						case '#':	//벽
							num = 1;
							break;
						case '@':	//상근이 위치
							si=i;
							sj=j;
							num=3;
							break;
						case '*':	//불
							fireList.add(i*M+j);
							num=2;
							break;
					}
					map[i][j] = num;
				}
			}
			//printMap(map);
			//1.while
			Queue<Integer> sq = new ArrayDeque<>();
			sq.add(si*M+sj);
			Queue<Integer> fq = new ArrayDeque<>();
			for(int coord:fireList) {
				fq.add(coord);
			}
			//시간기록
			int time = 0;
			//탈출기록
			boolean exit = false;
			//상근이 큐 size가 비면 종료
			Loop:
			while(!sq.isEmpty()) {
				int fSize = fq.size();
				int sSize = sq.size();
				//1-1. 상근이 BFS
				for(int i=0;i<sSize;i++) {
					int temp = sq.poll();
					int ci = temp/M;
					int cj = temp%M;
					//불은 상근이를 삼킨다.
					if(map[ci][cj]==2) {
						continue;
					}
					for(int[] d:drts) {
						
						int ni = ci+d[0];
						int nj = cj+d[1];
						//범위밖으로 나가면 승리다 승리
						if(ni<0||nj<0||ni>=N||nj>=M) {
							exit=true;
							time++;
							break Loop;
						}
						//상근이는 .을 갈수있고 
						if(map[ni][nj]!=0) {
							continue;
						}
						
						map[ni][nj] = 3;
						sq.add(ni*M+nj);
					}
				}
				
				//1-2. 불 BFS
				for(int i=0;i<fSize;i++) {
					int temp = fq.poll();
					int fi = temp/M;
					int fj = temp%M;
					for(int[] d:drts) {
						//불은 .과 상근이를 삼킨다.
						int ni = fi+d[0];
						int nj = fj+d[1];
						if(ni<0||nj<0||ni>=N||nj>=M) {
							continue;
						}
						//불은 #을 지나가지 못한다
						if(map[ni][nj]==1) {
							continue;
						}
						map[ni][nj] = 2;
						fq.add(ni*M+nj);
					}
				}
				//printMap(map);
				time++;
			}
			//2. 정답 출력
			if(exit) {
				System.out.println(time);
			}else {
				System.out.println("IMPOSSIBLE");
			}
		}


	}
	public static void printMap(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
