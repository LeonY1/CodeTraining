import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String input_name = "coinflip.in";
		InputReader in = new InputReader(input_name);

		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int g = in.nextInt();
			for (int j = 0; j < g; j++) {
				int face = in.nextInt();
				int coins = in.nextInt();
				int result = in.nextInt();

				int heads = coins / 2;
				int tails = coins / 2;
				if(coins % 2 != 0){
					if(face == 1) tails++;
					else heads++;
				}
				System.out.println(result == 1? heads: tails);
			}
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
