package returning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int si = 0;
		int sj = 0;
		int d = 0;
		int time = 0;
		for(char l: line.toCharArray()) {
//			System.out.println(si+", "+sj);
			if(si == 0 && sj == 0 && time!=0) {
				System.out.println(time);
				return;
			}
			switch(l){
				case 'F':
					si += directions[d][0];
					sj += directions[d][1];
					break;
				case 'L':
					d = ((d-1)+4)%4;
					break;
				case 'R':
					d = (d+1)%4;
					break;
			}
			time++;
		}
		
	}

}
