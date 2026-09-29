package nextPerm;

import java.util.Arrays;

public class SudoMain {
	public static int[] p = {1,2,3,4,5};
	public static int N = 5;
	
	public static void main(String[] args) {
		// 1. pivot 찾기 N-2 -> 0 없으면 종료
		int pivot = N-2;
		System.out.println(Arrays.toString(p));
		Loop2:
		while(pivot>=0) {
			if(p[pivot]<p[pivot+1]) {
				// 2. 오른쪽 포인터가 최소로 큰놈 찾기 -> 없으면 무시
				int right = N-1;
				Loop1:
				while(right>pivot) {
					if(p[pivot]<p[right]) {
						// 3. pivot과 오른쪽 포인터 교체
						swap(pivot, right);
						break Loop1;
					}
					right--;
				}
				// 4. pivot 오른쪽을 left 오른쪽 포인터를 right로 교체작업
				int leftP = pivot +1;
				int rightP = N-1;
				while(leftP<rightP) {
					swap(leftP,rightP);
					leftP++;
					rightP--;
				}
				System.out.println(Arrays.toString(p));
				pivot = N-1;
			}
			pivot--;
		}
		
		
		// 4. pivot 오른쪽을 left 오른쪽 포인터를 right로 교체작업
	}
	public static void swap(int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}

}
