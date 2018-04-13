import java.util.*;
import java.io.*;

public class Main{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num % m == 0)
				cnt++;
		}

		System.out.println(cnt);
	}
}
