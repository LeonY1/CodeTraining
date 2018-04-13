/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws Exception
	{
		// your code goes here
		int n;
		StringTokenizer st1, st2;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st1 = new StringTokenizer(in.readLine());
		st2 = new StringTokenizer(in.readLine());
		int min_auth, min_trans, min;
		min_auth = min_trans = min = 1 << 24;
		
		for(int i = 0; i < n; i++){
			int t = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st1.nextToken());
			
			if(t == 1){
				if(c < min_auth){
					min_auth = c;
					if(min_auth + min_trans < min)
						min = min_auth + min_trans;
				}
			}
			else if(t == 2){
				if(c < min_trans){
					min_trans = c;
					if(min_auth + min_trans < min)
						min = min_auth + min_trans;
				}
			}
			else{
				if(c < min){
					min = c;
				}
			}
		}
		System.out.println(min);
	}
}
