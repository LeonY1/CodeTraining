import java.util.*;
import java.io.*;

public class cf492a{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf492a.in");
		
		int n = in.nextInt();
		int cnt = 0;

		while(n > 0){
			if(n >= 100){
				cnt += n / 100;
				n -= n / 100 * 100;
			}
			else if(n >= 20){
				cnt += n / 20;
				n -= n / 20 * 20;
			}
			else if(n >= 10){
				cnt += n / 10;
				n -= n / 10 * 10;
			}
			else if(n >= 5){
				cnt += n / 5;
				n -= n / 5 * 5;
			}
			else if(n >= 1){
				cnt += n;
				n = 0;
			}

		}
		System.out.println(cnt);	
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