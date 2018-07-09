/*
Finished on 2nd try:
	- Don't neglect reading the problem saying how test data can go to the next line
*/
/*
ID: leonyyu1
LANG: JAVA
TASK: agrinet
*/
import java.util.*;
import java.io.*;

public class agrinet{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("agrinet.in"));
		PrintStream out = new PrintStream("agrinet.out");

		int n = Integer.parseInt(in.readLine());
		int [][] weight = new int[n][n];
		int [] dist = new int[n];
		int [] intree = new int[n];
		int [] source = new int[n];
		int treesz = 0;
		int treecost = 0;
		
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++){
				try{
					weight[i][j] = Integer.parseInt(st.nextToken());
				}catch(Exception e){
					st = new StringTokenizer(in.readLine());
					weight[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist[i] = 1 << 27;
			intree[i] = 0;
			source[i] = -1;
		}

		treesz = 1;
		intree[0] = 1;
		for(int i = 0; i < n; i++){
			if(weight[0][i] > 0){
				dist[i] = weight[0][i];
				source[i] = 0;
			}
		}

		while(treesz < n){
			int id = -1;
			for(int i = 0; i < n; i++){
				if(intree[i] == 0 && (id == -1 || dist[i] < dist[id])){
					id = i;
				}
			}
			intree[id] = 1;
			treecost += dist[id];
			for(int i = 0; i < n; i++){
				if(intree[i] == 0 && weight[id][i] < dist[i]){
					dist[i] = weight[id][i];
				}
			}
			treesz++;
		}
		out.println(treecost);
	}
}