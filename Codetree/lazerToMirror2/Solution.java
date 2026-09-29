package lazerToMirror2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int[][] directions = {{1,0},{0,-1},{-1,0},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 0.입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			String line = br.readLine().trim();
			for(int j=0;j<N;j++) {
				int temp = -1;
				switch(line.charAt(j)) {
				case'\\':
					temp=0;
					break;
				case'/':
					temp=1;
					break;
				}
				map[i][j]=temp;
			}
		}
		int start = Integer.parseInt(br.readLine())-1;
		int line = start/N;
		int point = start%N;
		
		//시작좌표
		int d = line;
		int si = -1;
		int sj = -1;
		switch(line) {
		case 0:
			si=0;
			sj=point;
			break;
		case 1:
			si=point;
			sj=N-1;
			break;
		case 2:
			si=N-1;
			sj=(N-1)-point;
			break;
		case 3:
			si=(N-1)-point;
			sj=0;
			break;
		}
		
		int ci = si;
		int cj = sj;
		int cnt = 1;
		while(true) {
			switch(map[ci][cj]) {
			case 0:
				d=(3)-d;
				break;
			case 1:
				d=((3)-d+2)%4;
				break;
			}
			int ni = ci+directions[d][0];
			int nj = cj+directions[d][1];
			if(ni<0||nj<0||ni>=N||nj>=N) {
				break;
			}
			ci = ni;
			cj = nj;
			cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
