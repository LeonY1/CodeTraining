/*
Things I've learned:
	- Even though it may not look it, some things can still be graph theory
	- Don't forget simple cases like no duplicates of itself and owning itself
	- Line ordering matters
*/
/*
ID: leonyyu1
LANG: JAVA
TASK: concom
*/
import java.util.*;
import java.io.*;

public class concom{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("concom.in"));
		PrintStream out = new PrintStream("concom.out");

		int n = Integer.parseInt(in.readLine());

		int [][] mat = new int[101][101];
		HashSet<Integer> [] children = new HashSet[101];
		for(int i = 1; i <= 100; i++){
			children[i] = new HashSet<Integer>();
		}

		for(int i = 1; i <= n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int owner = Integer.parseInt(st.nextToken());
			int cp = Integer.parseInt(st.nextToken());
			int per = Integer.parseInt(st.nextToken());

			mat[owner][cp] += per;
			if(mat[owner][cp] > 50){
				children[owner].add(cp);
			}
		}

		for(int i = 1; i <= 100; i++){
			ArrayList<Integer> l;
			HashSet<Integer> set = children[i];
			HashSet<Integer> newadj = children[i];
			while(!newadj.isEmpty()){
				HashSet<Integer> newadj2 = new HashSet<Integer>();
				for(int j: newadj){
					for(int k = 1; k <= 100; k++){
						mat[i][k] = mat[i][k] > 100 ? 100: mat[i][k] + mat[j][k];
						if(mat[i][k] > 50 && !set.contains(k)  && i != k){
							newadj2.add(k);
						}
					}
				}
				newadj = newadj2;
				set.addAll(newadj);
			}
			l = new ArrayList<Integer>(set);
			Collections.sort(l);
			for(int j: l){
				if(i != j)
					out.println(i + " "+j);
			}
		}
	}
}