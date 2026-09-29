package p1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int[][] map;
	public static List<Node> cList;
	public static int[][] dire = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int maxCore;
	public static int minLine;
	public static class Node{
		int ci;
		int cj;
		boolean visited;
		public Node() {
			
		}
		public Node(int ci, int cj) {
			this.ci = ci;
			this.cj = cj;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			cList = new ArrayList<Node>();
			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			int hiddenCore = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						//잠복되어있는 코어
						if(i==0 || i==N-1 || j==0 || j==N-1) {
							hiddenCore++;
						}//진짜 코어
						else {
							//1. 모서리 아닌 코어를 리스트에 넣기
							cList.add(new Node(i, j));
						}
					}
				}
			}
			
			dfs(0,0,0);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(minLine);
			System.out.println(sb);
			
		}
		
		

	}
	public static void dfs(int dep, int sumCore, int sumLine) {
		//System.out.println(sumLine);
		//System.out.println(toString(map));
		//종료조건
		if(dep==cList.size()) {
			if(maxCore<sumCore) {
				maxCore = sumCore;
				minLine = sumLine;
			}else if(maxCore==sumCore) {
				minLine = Math.min(minLine, sumLine);
			}
			return;
		}
		
		//2. 가지치기 전략
		//2-1. 가능한 최대 코어가 맥스보다 작으면 자르기
		int remainCore = cList.size()-dep;
		if(sumCore+remainCore<maxCore) {
			return;
		}
		
		//3. dep번째 core를 넣거나(4방) 안넣거나
		//3.1 넣음
		//3.1.2 4방 체크
		int ci = cList.get(dep).ci;
		int cj = cList.get(dep).cj;
		
		for(int[] d:dire) {
			int ni=ci+d[0];
			int nj=cj+d[1];
			
			//공간 끝까지 갈 수 있니?
			boolean checkEnd = false;
			while(true) {
				//공간 끝까지 왔으면
				if(ni<0||nj<0||ni>=N||nj>=N) {
					//클리어
					checkEnd = true;
					break;
				}
				
				//전선은 0아니면 못간다
				if(map[ni][nj]!=0) {
					checkEnd = false;
					break;
				}
				
				ni+=d[0];
				nj+=d[1];
			}
			int ei = ni;
			int ej = nj;
			ni = ci+d[0];
			nj = cj+d[1];
			//갈수있어
			//3.1.2 4방 되면 2변환
			int line = 0;
			if(checkEnd) {
				while(!(ni==ei && nj==ej)) {
					map[ni][nj] = 2;
					line++;
					ni+=d[0];
					nj+=d[1];
				}
				dfs(dep+1, sumCore+1, sumLine+line);
				
				ni = ci+d[0];
				nj = cj+d[1];
				while(!(ni==ei && nj==ej)) {
					map[ni][nj] = 0;
					line--;
					ni+=d[0];
					nj+=d[1];
				}
			}
			
		}
		//3.2 안넣음
		dfs(dep+1, sumCore, sumLine);
	}
	public static String toString(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
