import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String input_name = "lepermut.in";
		InputReader in = new InputReader(input_name);

		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			int local = 0;
			int inv = 0;

			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
				if(j >= 1){
					for(int k = 0; k < j; k++){
						if(arr[k] > arr[j]){
							if(k == j - 1)	local++;
							inv++;
						}
					}
				}
			}

			System.out.println(inv==local? "YES": "NO");
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
