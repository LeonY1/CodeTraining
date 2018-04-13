import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String input_name = "";
		InputReader in = new InputReader(input_name);

		int n = in.nextInt();
		int m = in.nextInt();

		int diff = n - m;
		if((diff + 1) % 10 == 0)
			System.out.println(diff - 1);
		else
			System.out.println(diff + 1);
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
