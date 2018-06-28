import java.util.*;
import java.io.*;

public class cfedu46b{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cfedu46b.in");
		int n = in.nextInt();
		int m = in.nextInt();

		HashSet<Pair> set = new HashSet<Pair>(); 
		int [] arr = new int[n];
		Pair [] p = new Pair[n - 1];
		for(int i = 0; i < arr.length; i++){
			arr[i] = in.nextInt();
			if(i > 0)
				p[i - 1] = new Pair(arr[i - 1], arr[i], 0);
		}
		if(p.length > 1)
			set.add(p[0]);
		if(arr[0] == 1 && arr.length > 1 && arr[1] != 2){
			set.add(new Pair(arr[0], arr[1], 1));
		}
		else if(arr[0] != 1){
			set.add(new Pair(arr[0] - 1, arr[0], 1));
		}

		while(!set.isEmpty()){
			HashSet<Pair>
		}
	}
	static class Pair{
		public int x, y;
		public int s;
		public Pair(int x, int y, int i){
			this.x = x;
			this.y = y;
			s = i;
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