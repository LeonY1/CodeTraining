/*
ID: leonyyu1
LANG: JAVA
TASK: ttwo
*/
import java.util.*;
import java.io.*;

public class ttwo{
	public static int [] dirx = {-1, 0, 1, 0};
	public static int [] diry = {0, 1, 0, -1};
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("ttwo.in"));
		PrintStream out = new PrintStream("ttwo.out");

		char [][] mat = new char[10][];
		int F_x = -1;
		int F_y = -1;
		int C_x = -1;
		int C_y = -1;

		for(int i = 0; i < mat.length; i++){
			mat[i] = in.readLine().toCharArray();
			for(int j = 0;j < mat[i].length; j++){
				if(mat[i][j] == 'F'){
					F_x = i;
					F_y = j;
				}
				if(mat[i][j] == 'C'){
					C_x = i;
					C_y = j;
				}
			}
		}

		Pair f = new Pair(F_x, F_y, 0);
		Pair c = new Pair(C_x, C_y, 0);
		int cnt = 0;
		while(cnt < 10000){
			if(f.x == c.x && f.y == c.y)
				break;
			int nfx = f.x + dirx[f.d]; 
			int nfy = f.y + diry[f.d];
			int ncx = c.x + dirx[c.d];
			int ncy = c.y + diry[c.d];
			if(v(nfx, nfy) && mat[nfx][nfy] != '*'){
				f.x = nfx;
				f.y = nfy;
			}
			else{
				f.d++;
				f.d %= 4;
			}
			if(v(ncx, ncy) && mat[ncx][ncy] != '*'){
				c.x = ncx;
				c.y = ncy;
			}
			else{
				c.d++;
				c.d %= 4;
			}
			cnt++;			
		}
		if(cnt == 10000)
			out.println(0);
		else
			out.println(cnt);
	}
	public static boolean v(int x, int y){
		return -1 < x && x < 10 && -1 < y && y < 10;
	}
	static class Pair{
		public int x, y, d;
		public Pair(int r, int c, int dir){
			x = r;
			y = c;
			d = dir;
		}
	}
}