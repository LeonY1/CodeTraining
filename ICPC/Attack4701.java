/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Attack4701
{
	public static void main (String[] args) throws Exception
	{
		// your code goes here
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for(int i = 0;i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int target = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			String [] arr = s.split("[+-]");
			
			int [] prob = new int[1];
			prob[0] = 1;
			int min = 0, max = 0, total = 1, sum = 0;

			for(int j = 0; j < arr.length; j++){
			    
				if(arr[j].indexOf("d") == -1){
					if(op(s, arr[j]) == '+'){
						target -= parse(arr[j]);
					}
					else{
					    target += parse(arr[j]);
					}
				}
				else{
					int faces = parse(end(arr[j]));
					int dices = parse(beg(arr[j]));
					
					if(op(s, arr[j]) == '+'){
                        for (int k = 1; k <= dices; k++){
                            int newmax = max + faces, newmin = min + 1;
                            int [] new_prob = new int[newmax - newmin + 1];
                            
                            for(int l = newmin; l <= newmax; l++){
                                for(int m = 1; m <= faces; m++){
                                    if(l - m >= min && l - m <= max){
                                        new_prob[l - newmin] += prob[l - m - min];
                                    }
                                }
                            }
                            prob = new_prob;
                            max = newmax;
                            min = newmin;
                            total *= faces;
                        }
    				}
    				else{
    				   for(int k = 1; k <= dices; k++) {
                            int newmax = max - 1, newmin = min - faces;
                            int [] new_prob = new int[newmax - newmin + 1];
    				       
                            for(int l = newmin; l <= newmax; l++){
    				           for(int m = 1; m <= faces; m++){
    				               if(l + m >= min&&l + m <= max){
    				                   new_prob[l - newmin] += prob[l + m - min];
    				               }
    				           }
    				       }
    				       prob = new_prob;
    				       max = newmax;
    				       min = newmin;
    				       total *= faces;
    				   }
    				}
				}
				s = s.substring(arr[j].length());
			}
			
			for(int j = target;j <= max; j++){
			    sum += prob[j - min];
			}
			
			if(sum == total) System.out.println("1");
			else if(sum == 0) System.out.println("0");
			else{
			    int gcd = gcd(total, sum);
			    System.out.println(sum/gcd + "/" + total/gcd);
			}
		}
	}
	public static int gcd(int x, int y){
	    if(x % y == 0)
	        return y;
	    return gcd(y, x % y);
	}
	public static char op(String s, String s2){
	    if(s.indexOf(s2) == 0)
	        return '+';
	    return s.charAt(s.indexOf(s2) - 1);
	}
	public static String end(String s){
	    return s.substring(s.indexOf("d") + 1);
	}
	public static String beg(String s){
	    return s.substring(0, s.indexOf("d"));
	}
	public static int parse(String s){
	    return Integer.parseInt(s);
	}
}
