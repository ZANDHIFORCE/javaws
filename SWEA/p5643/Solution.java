package p5643;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static int cn[][];	//커넥션
	public static int N;
	public static int M;
	public static int INF = Integer.MAX_VALUE/3;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//0. 입력
		System.setIn(new FileInputStream("src/p5643/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test = 1; test<=T;test++) {

			//1      	// 전체 테스트케이스 개수
			//6     	// 첫 번째 TC의 N
			//6      	// 첫 번째 TC의 M
			//1 5    	// a b 비교
			//3 4    
			//5 4
			//4 2
			//4 6
			//5 2	
			
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			cn = new int[N][N];
			for (int i = 0; i < cn.length; i++) {
				Arrays.fill(cn[i], INF);
			}
			
			for(int m = 0; m<M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				cn[s][e] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				cn[i][i] = 0;
			}
			
			//1. 3차원 배열 플로이드 워셜 2개!
			
			//워셜1
			int[][] distA = new int[N][N];
			for(int i=0;i<N;i++) {
				distA[i] = Arrays.copyOf(cn[i], N);
			}
			
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						distA[i][j]=Math.min(distA[i][j],distA[i][k]+distA[k][j]);
					}
				}
			}
			
//			printArr(distA);
			
			//워셜2
			int[][] distB = new int[N][N];
			for(int i=0;i<N;i++) {
				for (int j = 0; j < N; j++) {
					distB[i][j] = cn[j][i];
				}
			}
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						distB[i][j]=Math.min(distB[i][j],distB[i][k]+distB[k][j]);
					}
				}
			}
			
//			printArr(distB);
			
//			for (int ni = 0; ni < distA.length; ni++) {
//				for (int nj = 0; nj < distA.length; nj++) {
//					if(distB[ni][nj]==INF) {
//						System.out.print("*"+" ");
//					}else {
//						System.out.print(distB[ni][nj]+" ");
//					}
//				}
//				System.out.println();
//			}
			
			
			//양방향 완성
			
			int answer = 0;
			for(int node=0;node<N;node++) {
				int count = 0;
				boolean[] check = new boolean[N];
				for(int next=0;next<N;next++) {
					if(distA[node][next]!=INF) {
						check[next]=true;
						count++;
					}
				}
				
				for(int remain = 0;remain<N;remain++) {
					if(check[remain]) {
						continue;
					}
					if(distB[node][remain]!=INF) {
						check[remain]=true;
						count++;
					}
				}
				
				if(count==N) {
					answer++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("#").append(test).append(" ").append(answer);
			System.out.println(sb);
			
		}
		
	}
	public static void printArr(int[][] distA) {
		System.out.println();
		for (int ni = 0; ni < distA.length; ni++) {
			for (int nj = 0; nj < distA.length; nj++) {
				if(distA[ni][nj]==INF) {
					System.out.print("*"+" ");
				}else {
					System.out.print(distA[ni][nj]+" ");
				}
			}
			System.out.println();
		}
	}

}
