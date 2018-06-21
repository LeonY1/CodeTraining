import java.util.*;
import java.io.*;

public class cf489a{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf489a.in");
		
		int n = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < n; i++){
			int m = in.nextInt();
			if(m != 0 && !set.contains(m)){
				set.add(m);
			}
		}	

		System.out.println(set.size());
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
		public String nextLine(){
			try{
				return reader.readLine();
			}
			catch(Exception e){
				throw new RuntimeException(e);
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