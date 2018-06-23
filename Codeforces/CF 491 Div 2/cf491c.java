/*
Things I've learned:
	- Can use binary search to find where the most applicable solution is

Things did correctly the first time:
	- Switching from high = mid - 1 to high = mid

Things I did incorrectly:
	- Using math.ceil when it was far easier and accurate to multiply
*/
import java.util.*;
import java.io.*;

public class cf491c{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf491c.in");
		
		long n = Long.parseLong(in.next());

		long low = 1;
		long high = n;

		while(low <= high){
			if(low == high)
				break;
			long mid = (low + high) / 2;
			if(valid(mid, n)){
				high = mid;
			}
			else
				low = mid + 1;
		}
		System.out.println(low);
	}

	public static boolean valid(long k, long n){
		long v = 0;
		long tot = n;
		while(n > 0){
			v += Math.min(n, k);
			n -= k;
			n -= n / 10;
		}
		if(v * 2 >= tot){
				return true;
		}
		return false;
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