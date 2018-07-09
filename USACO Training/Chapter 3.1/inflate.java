/*
Worked First Time!!!!
*/
/*
ID: leonyyu1
LANG: JAVA
TASK: inflate
*/
import java.util.*;
import java.io.*;

public class inflate{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("inflate.in"));
		PrintStream out = new PrintStream("inflate.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int [] val = new int[n];
		int [] wt = new int[n];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			val[i] = Integer.parseInt(st.nextToken());
			wt[i] = Integer.parseInt(st.nextToken());
		}

		int [] dp = new int[w + 1];

		for(int i = 0; i < n; i++){
			for(int j = 0; j <= w; j++){
				if(j >= wt[i] && dp[j - wt[i]] + val[i] > dp[j]){
					dp[j] = dp[j - wt[i]] + val[i];
				}
			}
		}
		out.println(dp[w]);
	}
}