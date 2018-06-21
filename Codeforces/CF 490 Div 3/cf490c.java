/*
Things I've learned:
 - Don't reconstruct the string every single time
 - Instead, eliminate all things to be eliminated and then construct it
*/
import java.util.*;
import java.io.*;

public class cf490c{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf490c.in");
		
		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();

		int [] arr = new int[26];
		for(int i = 0; i < n; i++){
			arr[s.charAt(i) - (int)('a')]++;
		}

		int i;
		for(i = 0; i < 26; i++){
			if(arr[i] > k){
				break;
			}			
			k -= arr[i];
		}

		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < n; j++){
			if(s.charAt(j) > i + 97)
				sb.append(s.charAt(j));
			else if(s.charAt(j) == i + 97){
				if(k > 0){
					k--;
				}else{
					sb.append(s.charAt(j));
				}
			}
		}
		System.out.println(sb.toString());
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