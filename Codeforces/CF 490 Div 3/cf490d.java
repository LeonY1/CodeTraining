import java.util.*;
import java.io.*;

public class cf490d{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf490d.in");
	
		int n = in.nextInt();
		int k = in.nextInt();
		int cnt = 0;
		int [] arr = new int[n];
		int [] rem = new int[k];

		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
			if(rem[arr[i] % k] == n/k){
				int j = 1;
				while(rem[(arr[i] + j) % k] == n/k){
					j++;
				}
				cnt += j;
				arr[i] += j;
				rem[arr[i] % k]++;
			}
			else{
				rem[arr[i] % k]++;
			}
		}

		System.out.println(cnt);
		for(int i = 0; i < arr.length; i++){
			if(i < arr.length - 1)
				System.out.print(arr[i] + " ");
			else
				System.out.println(arr[i]);
		}
	}

	static class Pair implements Comparable<Pair>{
		int rem, id;
		public Pair(int x, int y){
			rem = x;
			id = y;
		}
		public int compareTo(Pair p){
			return p.rem - rem;
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