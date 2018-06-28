/*
Tries Taken: 2
Error with First Try:
	- Forgot Base Case: Set my max to 0 but wouldn't go anywhere in the maze
*/
/*
ID: leonyyu1
LANG: JAVA
TASK: maze1
*/
import java.util.*;
import java.io.*;

public class maze1{
	public static int r;
	public static int c;
	public static int [] dirx = {-1, 0, 1, 0};
	public static int [] diry = {0, -1, 0, 1};

	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("maze1.in"));
		PrintStream out = new PrintStream("maze1.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int [][] mat = new int[r][c];
		char [][] mat2 = new char[2 * r + 1][2 * c + 1];

		HashSet<Pair> set = new HashSet<Pair>();

		for(int i = 0; i < mat2.length; i++){
			mat2[i] = in.readLine().toCharArray();
			if(i == 0 || i == mat2.length - 1){
				for(int j = 1;j < mat2[i].length; j += 2){
					if(mat2[i][j] == ' '){
						set.add(new Pair((i-1) / 2, (j-1) / 2));
					}
				}
			}
			if(i % 2 == 1 && mat2[i][0] == ' ')
				set.add(new Pair((i-1) / 2, 0));
			if(i % 2 == 1 && mat2[i][2 * c] == ' ')
				set.add(new Pair((i-1) / 2, c - 1));
		}
		for(Pair p: set){
			mat[p.x][p.y] = 1;
		}
		int max = 1;

		while(!set.isEmpty()){
			HashSet<Pair> set2 = new HashSet<Pair>();
			for(Pair p: set){
				for(int i = 0; i < dirx.length; i++){
					int nr = p.x + dirx[i];
					int nc = p.y + diry[i];
					char mid = mat2[2*p.x + 1 + dirx[i]][2*p.y + 1 + diry[i]];
					if(v(nr, nc) &&  mat[nr][nc] == 0 && (mid != '|' && mid != '-')){
						set2.add(new Pair(nr, nc));
						mat[nr][nc] = mat[p.x][p.y] + 1;
						if(mat[nr][nc] > max)
							max = mat[nr][nc];
					}
				}
			}
			set = set2;
		}
		out.println(max);

	}
	public static boolean v(int x, int y){
		return -1 < x && x < r && -1 < y && y < c;
	}
	static class Pair{
		public int x, y;
		public Pair(int r, int c){
			x = r;
			y = c;
		}
	}
}