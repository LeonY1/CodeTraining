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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for(int i = 0;i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int target = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			String [] arr = s.split("[+-]");
			
			int [] prob = new int[1];
			prob[0] = 1;
			int min = 0, max = 0;

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
                            int [] new_prob = new int[faces + prob.length];
                            max += faces;
                            min ++;
                            
                            for(int l = 0; l < new_prob.length; l++){
                                for(int m = 1; m <= faces; m++){
                                    if(l - m - min >= 0 && l - m < max){
                                        new_prob[l] += prob[l - m];
                                    }
                                }
                            }
                            prob = new_prob;
                        }
    				}
    				else{
    				   for(int k = 1; k <= dices; k++) {
    				       int [] new_prob = new int[prob.length + faces];
    				       min -= faces;
    				       max--;
    				       
    				       for(int l = 0; l < new_prob.length; l++){
    				           for(int m = 1; m <= faces; m++){
    				               if(l + m < max){
    				                   new_prob[l] += prob[l + m];
    				               }
    				           }
    				       }
    				       prob = new_prob;
    				   }
    				}
				}
				
				s = s.substring(arr[j].length());
			}
			System.out.println(Arrays.toString(prob));
			System.out.println(target);
		}
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
