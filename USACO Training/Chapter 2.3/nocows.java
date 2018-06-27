/*
Things I've learned:
	- DP can be hard to think of recurrence relation but after you find it, it's easy
	- Don't forget simple cases like even numbers
	- When modding make sure to add the mod so it won't be negative
*/
/*
ID: leonyyu1
LANG: JAVA
TASK: nocows
*/
import java.util.*;
import java.io.*;

public class nocows{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("nocows.in"));
		PrintStream out = new PrintStream("nocows.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int nodes = n / 2;
		int lvl = m - 1;
		long [][] dp = new long[101][101];
		dp[0][0] = 1;

		for(int i = 1; i < dp.length; i++){
			for(int j = 0; j < dp[i].length; j++){
				if(j == 0)
					dp[i][j] = 1;
				else{
					for(int k = 0; k < j; k++){
						dp[i][j] += dp[i - 1][k] * dp[i - 1][j - k - 1];
					}
					dp[i][j] %= 9901;
				}
			}
		}
		if(n % 2 == 0)
			out.println(0);
		else
			out.println((dp[lvl][nodes] - dp[lvl - 1][nodes] + 9901) % 9901);
	}
}
