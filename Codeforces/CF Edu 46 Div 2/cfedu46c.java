import java.util.*;
import java.io.*;

public class cfedu46c{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cfedu46c.in");
		
		int n = in.nextInt();
		Long [] arr = new Long[2 * n];
		for(int i = 0; i < n; i++){
			arr[2 * i] = Long.parseLong(in.next()) * 2;
			arr[2 * i  + 1] = Long.parseLong(in.next()) * 2 + 1;
		}

		Arrays.sort(arr);

		int [] ans = new int[n];
		int id = 0;
		for(int i = 0; i < 2 * n - 1; i++){
			if(arr[i] % 2 == 0) cnt++;
			else cnt--;
			ans[cnt] += (arr[i + 1] / 2) - (arr[i] / 2);
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