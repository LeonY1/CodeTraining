import java.util.*;
import java.io.*;

public class cf492d{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cf492d.in");
		
		int n = in.nextInt();
		int [] arr = new int[n * 2];

		for(int i = 0; i < n * 2; i++){
			arr[i] = in.nextInt();
		}

		int res = rec(arr, 0);
		System.out.println(res);
	}

	public static int rec(int [] arr, int id){
		if(id >= arr.length)
			return 0;
		if(arr[id] == arr[id + 1]){
			return rec(arr, id + 2);
		}
		else{
			int id_a = find(arr, id);
			swap(arr, id + 1, id_a);
			int change_a = id_a - (id + 1);
			int a = rec(arr, id + 2);

			rev_swap(arr, id + 1, id_a);


			swap(arr, id, id + 1);
			int id_b = find(arr, id);
			swap(arr, id + 1, id_b);
			int change_b = id_b - (id + 1) + 1;
			int b = rec(arr, id + 2);
			rev_swap(arr, id + 1, id_b);

			return Math.min(change_a + a, change_b + b);
		}

	}
	public static void swap(int [] arr, int a , int b){
		int temp = arr[b];
		for(int i = b; i > a; i--){
			arr[i] = arr[i - 1];
		}
		arr[a] = temp;
	}
	public static void rev_swap(int [] arr, int a, int b){
		int temp = arr[a];
		for(int i = a; i < b; i++){
			arr[i] = arr[i + 1];
		}
		arr[b] = temp;
	}

	public static int find(int [] arr, int id){
		for(int i = id + 2; i < arr.length; i++){
			if(arr[i] == arr[id]){
				return i;
			}
		}
		return -1;
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