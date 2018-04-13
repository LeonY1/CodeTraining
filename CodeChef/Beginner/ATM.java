import java.io.*;
import java.util.*;

public class Main{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		double m = Double.parseDouble(st.nextToken());
		
		if(n % 5 != 0 || n + .5> m){
			System.out.printf("%.2f\n", m);
		}else{
			m -= n;
			m -= .5;
			System.out.printf("%.2f\n", m);
		}
	}
	
}
