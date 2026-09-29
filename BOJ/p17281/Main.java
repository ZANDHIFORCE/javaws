package p17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] p;
	public static int maxScore=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int E = Integer.parseInt(br.readLine());
		int[][] scoreList = new int[E][9];
		for(int e=0;e<E;e++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				scoreList[e][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		p = new int[] {1,2,3,4,5,6,7,8};
			

			//4. 조합 다 돌리면서 최고점수 찾기
			do {
				int score=0;
				int idx = 0;
				//1. 4번 타자는 고정. 그러니까 12356789를 섞어야한다
				int[] sqs = new int[9];
				for(int i=0;i<3;i++) {
					sqs[i] = p[i];
				}
				sqs[3] = 0;
				for(int i=4;i<9;i++) {
					sqs[i] = p[i-1];
				}
				//System.out.println(Arrays.toString(sqs));
				for(int e=0;e<E;e++) {
					//2. 아웃이 세번나오면 끝..!
					int outCount = 0;
					
					//3. 득점시스템을 어떻게 할것인지..?
						//Queue에서 밀어넣고 값올리고 4이상이면 1추가!
					Queue<Integer> sq = new ArrayDeque<>();
					while(outCount<3) {
						int hit = scoreList[e][sqs[idx]];
						int qSize = sq.size();
						//힛 0->out count, 123, 4
						if(hit==4) {
							score++;
						}else if(hit==0){
							outCount++;
							idx = (idx+1)%9;
							continue;
						}else {
							sq.add(hit);
						}
						
						for(int i=0;i<qSize;i++) {
							int runner = sq.poll();
							if(runner+hit>=4){
								score++;
							}else {
								sq.add(runner+hit);
							}
						}
						idx = (idx+1)%9;
					}
					outCount=0;
				}
				maxScore = Math.max(score, maxScore);
			}while(nextPerm());
			System.out.println(maxScore);
		
	}
	public static boolean nextPerm() {
		int N = p.length;
		//1. 뒤에서 떨어지는 놈을 찾는다!
		int i  = N-1;
		while(i>0 && p[i-1]>=p[i]) {
			i--;
		}
		//못찾으면 false
		if(i==0) {
			return false;
		}
		//2. 걔보다 큰놈을 뒤에서 찾는다!
		int j = N-1;
		while(p[j] <= p[i-1]) {
			j--;
		}
		//3. 교환한다
		swap(i-1, j);
		//4. 피벗 다음놈부터 뒤에서부터 싹 교체한다
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	public static void swap(int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}

}
