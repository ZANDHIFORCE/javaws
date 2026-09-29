package p2636;
import java.util.*;
import java.io.*;
public class Solution {
	static int n;
	static int m;
	static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int countCheeze = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<m;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num==1)
					countCheeze++;
			}
		}
		int count = 0;
//		System.out.println("Map");
//		System.out.println(toString(map));

		int pastCheeze = 0;
		while(countCheeze!=0) {
			//유독성 체크..! 유독성은 2로 하자! 0,0에서 시작!!
			boolean[][] visteidDanger = new boolean[n][m];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(z(0,0));
			visteidDanger[0][0] = true;
			
			while(!queue.isEmpty()) {
				int temp = queue.poll();
				int ci = temp/m;
				int cj = temp%m;
				
				for(int[] d:directions) {
					int ni = ci+d[0];
					int nj = cj+d[1];
					
					//범위 밖 제거
					if(ni<0||nj<0||ni>=n||nj>=m)
						continue;
					
					//방문 제외
					if(visteidDanger[ni][nj]==true)
						continue;
					
					//치즈면 패스!
					if(map[ni][nj]==1)
						continue;
					
					//빈공간이야..? 
					if(map[ni][nj]==0)
						map[ni][nj]=2;

					
					//빈공간이면 바꾸고 맹독성이면 그냥 집어넣어~
					queue.add(z(ni,nj));
					visteidDanger[ni][nj] = true;
				}
				
				
			}
			
			
			pastCheeze = countCheeze;
			boolean[][] visited = new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==1 && visited[i][j]==false) {
						//bfs
						queue = new LinkedList<>();
						queue.add(z(i,j));
						visited[i][j] = true;
						
						while(!queue.isEmpty()) {
							int temp = queue.poll();
							int ci = temp/m;
							int cj = temp%m;
							
							for(int[] d:directions) {
								int ni = ci+d[0];
								int nj = cj+d[1];
								
								//범위 밖 제거
								if(ni<0||nj<0||ni>=n||nj>=m)
									continue;
								
								//방문 제외
								if(visited[ni][nj]==true)
									continue;
								
								//독성없는 공기면! 스킵
								if(map[ni][nj]==0)
									continue;

								//빈공간이면 처리
								if(map[ni][nj]==2) {
									if(map[ci][cj]==1) {
										map[ci][cj]=0;
										countCheeze--;
									}
									continue;
								}
								
								//방문하지 않은 치즈!
								queue.add(z(ni,nj));
								visited[ni][nj] = true;
							}
							
							
						}
						
						
					}
				}
			}
//			System.out.println("TF");
//			System.out.println(toString2(visited));
//			System.out.println("Map");
//			System.out.println(toString(map));
			count++;
		}
		System.out.println(count);
		System.out.println(pastCheeze);
		
	}
	public static int z(int a, int b) {
		return a*m+b;
	}
	
	public static String toString(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static String toString2(boolean[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==false) {
					sb.append(0);
				}else {
					sb.append(1);
				}
				
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
