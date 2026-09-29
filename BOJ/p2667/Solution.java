package p2667;
import java.util.*;
import java.io.*;
public class Solution {
	static PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b)->{return Integer.compare(a,b);});
	static int n;
	static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			String line = br.readLine().trim();
			for(int j=0;j<n;j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		int count = 2;
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0 && visited[i][j]==false) {
					int value = 0;
					Queue<Integer> queue = new LinkedList<>();
					queue.add(z(i,j));
					visited[i][j]=true;
					value++;
					
					
					while(!queue.isEmpty()) {
						int temp = queue.poll();
						int ci = temp/n;
						int cj = temp%n;
						
						for(int[] d: directions) {
							int ni = ci + d[0];
							int nj = cj + d[1];
							
							if(ni<0 || nj<0 ||ni>=n || nj>=n)
								continue;
							
							if(map[ni][nj]==0)
								continue;
							
							if(visited[ni][nj] == true)
								continue;
							
							queue.add(z(ni,nj));
							visited[ni][nj] = true;
							value++;

						}
					}
					pq.add(value);
				}
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}
	public static int z(int a, int b) {
		return a*n+b;
	}

}
