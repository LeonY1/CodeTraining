/*
ID: leonyyu1
LANG: JAVA
TASK: stamps
*/
import java.util.*;
import java.io.*;

public class stamps{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("stamps.in"));
		PrintStream out = new PrintStream("stamps.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		int max = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int [] stamps = new int[n];
		int maxstamp = 0;
		for(int i = 0; i < n; i++){
			try{
				stamps[i] = Integer.parseInt(st.nextToken());
			}catch(Exception e){
				st = new StringTokenizer(in.readLine());
				stamps[i] = Integer.parseInt(st.nextToken());
			}
			if(stamps[i] > maxstamp)
				maxstamp = stamps[i];
		}

		int [] dp = new int[maxstamp * max + 1];
		int i;
		for(i = 1; i < dp.length; i++){
			for(int j: stamps){
				if(i >= j && dp[i - j] < max){
					if(dp[i] == 0)
						dp[i] = dp[i - j] + 1;
					else
						dp[i] = Math.min(dp[i], dp[i - j] + 1);
				}
			}
			if(dp[i] == 0)
				break;
		}
		out.println(i - 1);
	}
}