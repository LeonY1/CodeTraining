import java.util.*;
import java.io.*;

public class cf496a{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf496a.in");
		
		int n = in.nextInt();
		ArrayList<Integer> l = new ArrayList<>();
		int prev = 0;

		for(int i = 0; i < n; i++){
			int num = in.nextInt();
			if(prev >= num){
				l.add(prev);
			}
			if(i == n - 1)
				l.add(num);
			prev = num;
		}
		System.out.println(l.size());

		StringBuilder sb = new StringBuilder();
		for(int i: l){
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb);

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