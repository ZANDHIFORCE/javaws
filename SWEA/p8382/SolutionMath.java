package p8382;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionMath {

	public static void main(String args[]) throws Exception
	{

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
            
            int gNum = (ei+ej)/2;
            
            int answer = 2*gNum + Math.abs(ei-gNum) + Math.abs(ej-gNum);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer);
            System.out.println(sb);
		}
	}
}
