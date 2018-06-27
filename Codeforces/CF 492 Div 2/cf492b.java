import java.util.*;
import java.io.*;

public class cf492b{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf492b.in");
		int n = in.nextInt();
		int [] arr = new int[n];
		Pair min = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
			Pair p = new Pair((arr[i]) % n, i + 1, arr[i] / n);
			if(i == 0)
				min = p;
			else{
				if(p.loop() < min.loop()){
					min = p;
				}
			}
		}
		System.out.println(min.i);
	}
	static class Pair{
		int r, i, m;
		public Pair(int rem, int id, int mult){
			r = rem;
			i = id;
			m = mult;
		}
		public int loop(){
			return m + (r >= i ? 1: 0);
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