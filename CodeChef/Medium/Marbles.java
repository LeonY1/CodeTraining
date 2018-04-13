import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String input_name = "marbles.in";
		InputReader in = new InputReader(input_name);

		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int r = in.nextInt();
			long total = 1;

			if(n < r)
				total = 0;
			n -= r;
			if(n != 0){
				if(n > r - 1){
					for(int j = n + r - 1; j > n; j--){
						total *= j;
						total /= n + r - j;
					}
				}else{
					for(int j = n + r - 1; j > r - 1; j--){
						total *= j;
						total /= n + r - j;
					}
				}
			}
			System.out.println(total);
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(String s) {
			try{
				reader = new BufferedReader(new FileReader(s), 32768);
				tokenizer = null;
			}
			catch (Exception e){		
				reader = new BufferedReader(new InputStreamReader(System.in), 32768);
				tokenizer = null;
			}
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
