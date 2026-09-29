package p15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static int n;
	public static int m;
	//치킨집 갯수
	public static int c;
	//조합 수
	public static int cb;
	
	public static List<int[]> combi;
	public static void main(String[] args) throws IOException{
		//0. 입력!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		//1_1 치킨좌표리스트
		List<Integer> cList = new ArrayList<>();
		//1_2 일반집좌표리스트
		List<Integer> hList = new ArrayList<>();

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					hList.add(i*n+j);
				}
				if(map[i][j]==2) {
					cList.add(i*n+j);
				}
			}
		}
		c=cList.size();
		
		//2.5 기록
		int[][] record = new int[cList.size()][hList.size()];
		for(int i=0;i<cList.size();i++) {
			for(int j=0;j<hList.size();j++) {
				int cCoord = cList.get(i);
				int ci = cCoord/n;
				int cj = cCoord%n;
				int hCoord = hList.get(j);
				int hi = hCoord/n;
				int hj = hCoord%n;
				record[i][j] = Math.abs(hi-ci)+Math.abs(hj-cj);
			}
		}
		
		
		//2. 조합(dfs)
		combi = new ArrayList<>();
		boolean[] visted = new boolean[c];
		//조합 생성
		dfs(0,0,new int[m]);
		
		//3. 최단거리 탐색(유클리드 거리)
//		int sumMin = Integer.MAX_VALUE;
//		for(int[] combiArr:combi) {
//			int hSum = 0;
//			for(int hCoord: hList) {
//				int hi = hCoord/n;
//				int hj = hCoord%n;
//				int hToCMin = Integer.MAX_VALUE;
//				for(int cNum:combiArr) {
//					int cCoord = cList.get(cNum);
//					int ci = cCoord/n;
//					int cj = cCoord%n;
//					int cLen = Math.abs(hi-ci)+Math.abs(hj-cj);
//					hToCMin = Math.min(hToCMin, cLen);
//				}
//				hSum+=hToCMin;
//			}
//			sumMin = Math.min(hSum, sumMin);
//		}
		
		int answer = Integer.MAX_VALUE;
		for(int[] combiArr:combi) {
			int sum=0;
			for(int j=0;j<hList.size();j++) {
				int hToCMin = Integer.MAX_VALUE;
				for(int i:combiArr) {
					int cLen = record[i][j];
					hToCMin = Math.min(hToCMin, cLen);
				}
				sum+=hToCMin;
			}
			answer = Math.min(answer, sum);
		}
		
		System.out.println(answer);
		
	}
	public static void dfs(int start, int level,  int[] nums) {
		if(level==m) {
			combi.add(Arrays.copyOf(nums, m));
			return;
		}
		for(int i=start;i<c;i++) {
			nums[level]=i;
			dfs(i+1, level+1, nums);
		}
	}
	

}
