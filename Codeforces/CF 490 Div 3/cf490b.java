import java.util.*;
import java.io.*;

public class cf490b{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf490b.in");
		
		int n = in.nextInt();
		String s = in.next();

		for(int i = 1; i <= n; i++){
			if(n % i == 0){
				StringBuilder sb = new StringBuilder(s.substring(0, i));
				sb.reverse();
				sb.append(s.substring(i));
				s = sb.toString();
			}
		}

		System.out.println(s);

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