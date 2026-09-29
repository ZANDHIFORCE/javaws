package p8382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());
            int ej = Integer.parseInt(st.nextToken());
            
            ei = Math.abs(ei-si);
            ej = Math.abs(ej-sj);
            si = 0;
            sj = 0;
            
            int N = Math.max(ei, ej)+1;
            boolean[][][] visited = new boolean[N][N][2];
            
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(null);
            
            
            
            
		}
	}

}
