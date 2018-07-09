import java.util.*;
import java.io.*;

public class cf496b{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf496b.in");
		
		String s = in.next();
		String s2 = in.next();

		int i = 0;
		while (i < s.length() && i < s2.length() && s.charAt(s.length() - i - 1) == s2.charAt(s2.length() - i - 1)){
			i++;
		}

		int total = s.length() + s2.length() - 2 * i;
		System.out.println(total);
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