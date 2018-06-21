import java.util.*;
import java.io.*;

public class cf490a{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf490a.in");
		
		int n = in.nextInt();
		int k = in.nextInt();
		int [] arr = new int[n];
		int cnt = 0;

		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
		}

		for(int i = 0; i < n; i++){
			if(arr[i] > k){
				cnt = i;
				for(int j = n - 1; j >= 0; j--){
					if(arr[j] > k){
						cnt += n - 1 - j;
						break;
					}
				}
				break;
			}
			if(i == n - 1){
				cnt = n;
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