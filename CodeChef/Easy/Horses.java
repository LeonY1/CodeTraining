import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String input_name = "horses.in";
		InputReader in = new InputReader(input_name);

		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int m = in.nextInt();
			int [] arr = new int[m];
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < m; j++) {
				arr[j] = in.nextInt();
				for (int k = 0; k < j; k++) {
					if(Math.abs(arr[k] - arr[j]) < min)
						min = Math.abs(arr[k] - arr[j]);
				}
			}
			System.out.println(min);
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
