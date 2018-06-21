import java.util.*;
import java.io.*;

public class cf490d{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf490d.in");
	
		int n = in.nextInt();
		int k = in.nextInt();
		int [] arr = new int[n];
		int [] rem = new int[k];

		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
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