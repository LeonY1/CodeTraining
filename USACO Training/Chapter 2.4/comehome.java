/*
Finished on the 2nd Try:
	- For graph questions make sure to check if it is a undirected or directed graph
*/
/*
ID: leonyyu1
LANG: JAVA
TASK: comehome
*/
import java.util.*;
import java.io.*;

public class comehome{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("comehome.in"));
		PrintStream out = new PrintStream("comehome.out");

		int n = Integer.parseInt(in.readLine());
		Node [] g = new Node[52];
		int [] vi = new int[52];
		int [] parent = new int[52];
		HashSet<Pair> set = new HashSet<Pair>();

		for(int i = 0; i < 52; i++){
			g[i] = new Node();
			vi[i] = -1;
			parent[i] = i;
		}

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			char c1 = st.nextToken().charAt(0);
			char c2 = st.nextToken().charAt(0);
			int cost = Integer.parseInt(st.nextToken());
			int id1 = c1 >= 97? 26 + (c1 - 97): (c1 - 65);
			int id2 = c2 >= 97? 26 + (c2 - 97): (c2 - 65);

			g[id1].add(id2, cost);
			g[id2].add(id1, cost);
			
			if(id1 < 25){
				set.add(new Pair(id1, 0));
				vi[id1] = 0;
			}
			if(id2 < 25){
				set.add(new Pair(id2, 0));
				vi[id2] = 0;
			}
		}

		while(!set.isEmpty()){
			HashSet<Pair> set2 = new HashSet<Pair>();
			for(Pair p: set){
				ArrayList<Integer> adj = g[p.id].adj;
				ArrayList<Integer> cost = g[p.id].cost;
				for(int i = 0; i < adj.size(); i++){
					int id = adj.get(i);
					if(vi[id] == -1 || p.c + cost.get(i) < vi[id]){
						set2.add(new Pair(id, p.c + cost.get(i)));
						vi[id] = p.c + cost.get(i);
						parent[id] = p.id;
					}
				}
			}
			set = set2;
		}
		int num = parent[25];
		while(parent[num] != num){
			num = parent[num];
		}

		out.println((char)(num > 25? 97 + (num - 26): 65 + num) + " " + vi[25]);
	}
	static class Pair{
		int id, c;
		public Pair(int i, int cost){
			id = i;
			c = cost;
		}
	}
	static class Node{
		ArrayList<Integer> adj;
		ArrayList<Integer> cost;
		public Node(){
			adj = new ArrayList<Integer>();
			cost = new ArrayList<Integer>();
		}
		public void add(int node, int c){
			cost.add(c);
			adj.add(node);
		}
	}
}