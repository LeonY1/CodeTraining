/*
ID: leonyyu1
LANG: JAVA
TASK: fracdec
*/
import java.util.*;
import java.io.*;

public class fracdec{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("fracdec.in"));
		PrintStream out = new PrintStream("fracdec.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int [] rem = new int[100000];
		Arrays.fill(rem, -1);
		
		StringBuilder tempsb = new StringBuilder();
		tempsb.append(n/d +".");
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		n = n % d * 10;

		while(true){
			int r = n % d;
			// System.out.println(r + " " + n + " " + d + " " + n / d + " " + rem[r]);
			if(r == 0){
				sb.append(n/d);
				break;
			}

			int tempr = n % d * 10 % d;
			if (rem[r] != - 1 && n / d == rem[r]){
				sb2.append(rem[r]);
				while(r != tempr){
					sb2.append(rem[tempr]);
					tempr = tempr % d * 10 % d;
				}
				break;
			}
			
			rem[r] =  n / d;
			sb.append(rem[r]);
			n = n % d * 10;
		}
		tempsb.append(sb.substring(0, sb.length() - sb2.length()));
		if(sb2.length() > 0){
			tempsb.append("(");
			tempsb.append(sb2.toString());
			tempsb.append(")");
		}

		for(int i = 0; i < tempsb.length(); i+=76){
			if(tempsb.length() - i < 76)
				out.println(tempsb.substring(i));
			else
				out.println(tempsb.substring(i, i + 76));
		}
	}
}