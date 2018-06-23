/*
Things I've learned:
	- Check corner cases
	- In this case, the case where the center is less than either one of the sides
*/

import java.util.*;
import java.io.*;

public class cf491a{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf491a.in");
		
		int a = in.nextInt();	
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();

		if(d - (a + b - c) >= 1){
			if(c <= b && c <= a)
				System.out.println(d - (a + b - c));
			else
				System.out.println(-1);
		}
		else{
			System.out.println(-1);
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(String s) {
			try{
				reader = new BufferedReader(new FileReader(s), 32768);
			}
			catch (Exception e){		
				reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			}
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}