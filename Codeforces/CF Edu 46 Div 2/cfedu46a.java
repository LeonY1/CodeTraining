import java.util.*;
import java.io.*;

public class cfedu46a{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cfedu46a.in");
		
		int [] arr = new int[9];
		int [] arr2 = new int[9];
		int [] size = {4, 3, 2, 1, 1, 1, 2, 3, 4};
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			String s = in.next();
			switch(s.length()){
				case 1: 
					if(s.charAt(0) == 'S')
						arr[3]++;
					if(s.charAt(0) == 'M')
						arr[4]++;
					if(s.charAt(0) == 'L')
						arr[5]++;
					break;
				default:
					if(s.charAt(s.length() - 1) == 'S'){
						arr[3 - (s.length() - 1)]++;
					}
					if(s.charAt(s.length() - 1) == 'L'){
						arr[5 + (s.length() - 1)]++;
					}

			}
		}
		for(int i = 0; i < n; i++){
			String s = in.next();
			switch(s.length()){
				case 1: 
					if(s.charAt(0) == 'S')
						arr2[3]++;
					if(s.charAt(0) == 'M')
						arr2[4]++;
					if(s.charAt(0) == 'L')
						arr2[5]++;
					break;
				default:
					if(s.charAt(s.length() - 1) == 'S'){
						arr2[3 - (s.length() - 1)]++;
					}
					if(s.charAt(s.length() - 1) == 'L'){
						arr2[5 + (s.length() - 1)]++;
					}

			}
		}
		int cnt = 0;
		for(int i = 0; i < 9; i++){
			if(arr[i] == arr2[i])
				continue;
			else{
				cnt += (arr2[i] - arr[i] > 0? arr2[i] - arr[i]: 0);
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