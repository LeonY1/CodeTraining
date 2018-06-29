/*
Finished in 2nd try:
	- Make sure to read the problem for minor details like "the smallest possible diameter of any possible pair of connected pastures"
	- Make sure to set the matrix to infinity for Floyd Warshall
	- Make sure to set distance between i and i is 0

Could've improved the typing amount to be a lot less
*/	
/*
ID: leonyyu1
LANG: JAVA
TASK: cowtour
*/
import java.util.*;
import java.io.*;

public class cowtour{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("cowtour.in"));
		PrintStream out = new PrintStream("cowtour.out");

		int n = Integer.parseInt(in.readLine());
		Pair [] arr = new Pair[n];
		double [][] dist = new double[n][n];
		int [][] adj = new int[n][n];

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Arrays.fill(dist[i], Double.MAX_VALUE);
		}

		for(int i = 0; i < n; i++){
			adj[i] = conv(in.readLine());
			for(int j = 0; j < n; j++){
				if(adj[i][j] == 1)
					dist[i][j] = Math.hypot(Math.abs(arr[i].x - arr[j].x), Math.abs(arr[i].y - arr[j].y));
			}
			dist[i][i] = 0;
		}

		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0;j < n; j++){
					if(dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		double [] max = new double[n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(dist[i][j] != Double.MAX_VALUE && dist[i][j] > max[i])
					max[i] = dist[i][j];
			}
		}

		double ans = Double.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(dist[i][j] != Double.MAX_VALUE)
					continue;

				double max1 = max[i];
				double max2 = max[j];
				double total = max1 + max2 + Math.hypot(Math.abs(arr[i].x - arr[j].x), Math.abs(arr[i].y - arr[j].y));


				if(total < ans)
					ans = total;
			}
		}

		for(int i = 0; i < n; i++){
			if(max[i] > ans)
				ans = max[i];
		}

		out.printf("%.6f\n", ans);
	}

	public static int [] conv(String s){
		int [] arr = new int[s.length()];
		for(int i = 0; i < s.length(); i++){
			arr[i] = s.charAt(i) - 48;
		}
		return arr;
	}
	static class Pair{
		int x, y;
		public Pair(int r, int c){
			x = r;
			y = c;
		}
	}
}