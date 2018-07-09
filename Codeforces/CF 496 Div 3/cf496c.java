import java.util.*;
import java.io.*;

public class cf496c{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf496c.in");
		
		int n = in.nextInt();
		Integer [] arr = new Integer[n];
		int [] twos = new int[30];
		boolean []  visit = new boolean[n];

		twos[0] = 2;
		for(int i = 1;i < twos.length; i++){
			twos[i] = twos[i - 1] << 1;
		}

		int cnt = n;
		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);

		for(int i = 0; i < n; i++){
			for(int j = 0; j < twos.length; j++){
				int index = Arrays.binarySearch(arr, twos[j] - arr[i]);
				if(index >= 0 && index != i){
					cnt -= visit[i]? 0: 1;
					cnt -= visit[index]? 0 : 1;
					visit[i] = visit[index] = true;
					break;
				}
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