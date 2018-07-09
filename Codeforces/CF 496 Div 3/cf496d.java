import java.util.*;
import java.io.*;

public class cf496d{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf496d.in");
		
		String s = in.next();
		int [][] arr = new int[s.length() + 1][3];

		for(int i = 0; i < s.length(); i++){
			int num = s.charAt(i) - 48;

			int modded = (arr[i][1] + 2 * arr[i][2]) % 3;

			arr[i + 1][0] +=  arr[i][0];
			if(num % 3 == 0){
				arr[i + 1][0]++;
				continue;
			}
			else{
				if((modded + num) % 3 == 0)
					arr[i + 1][0]++;
				else if(arr[i][3 - num % 3] > 0)
					arr[i + 1][0]++;
				else{
					if(modded != 0)
						arr[i + 1][modded]++;
					arr[i + 1][num % 3]++;
				}
			}
		}
		System.out.println(arr[s.length()][0]);	
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