/*
Things I've learned:
	- Make sure you stop where you want to
		- If that means putting a break in where it is necessary vs. when it shouldn't be
*/


import java.util.*;
import java.io.*;

public class cf491b{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf491b.in");
		
		int n = in.nextInt();
		int [] freq = new int[6];
		int [] mult = {0, 0, 3, 2, 1, 0};
		int sum = 0;
		for(int i = 0; i < n; i++){
			int num = in.nextInt();
			freq[num]++;
			sum += num;
		}

		double min = 4.5 * n;
		int tot = 0;

		if(sum < min){
			for(int i = 2; i < 5; i++){
				if(freq[i] > 0 && sum + mult[i] * freq[i] >= min){
					int ss = (int) (Math.ceil((min - sum) / mult[i]));
					tot += ss;
					sum += ss * mult[i];
					break;
				}
				else if(freq[i] > 0 && sum + mult[i] * freq[i] < min){
					tot += freq[i];
					sum += freq[i] * mult[i];
				}
			}
			System.out.println(tot);
		}else{
			System.out.println(0);
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