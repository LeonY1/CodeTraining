/*
ID: leonyyu1
LANG: JAVA
TASK: contact
*/
import java.util.*;
import java.io.*;

public class contact{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("contact.in"));
		PrintStream out = new PrintStream("contact.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		Pair [][] freq = new Pair[b - a + 1][];

		for(int i = 0; i <= b - a; i++){
			freq[i] = new Pair[1 << a + i];
		}
		StringBuilder sb = new StringBuilder();
		while(in.ready()){
			sb.append(in.readLine());
		}

		int max = 0;
		for(int i = 0; i <= sb.length(); i++){
			for(int j = a; j <= b; j++){
				if(i >= j){
					int index = Integer.parseInt(sb.substring(i - j, i), 2);
					if(freq[j - a][index] == null)
						freq[j - a][index] = new Pair(sb.substring(i - j, i));
					freq[j - a][index].freq++;
					if(freq[j - a][index].freq > max)
						max = freq[j - a][index].freq;
				}
			}
		}

		Freq [] res = new Freq[max + 1];
		for(int i = 0; i < freq.length; i++){
			for(int j = 0; j < freq[i].length; j++){
				if(freq[i][j] != null && res[freq[i][j].freq] == null)
					res[freq[i][j].freq] = new Freq(freq[i][j].s);
				else if (freq[i][j]!= null)
					res[freq[i][j].freq].add(freq[i][j].s);
			}
		}
		int i = res.length - 1;
		while(n > 0 && i > 0){
			if(res[i] == null){
				i--;
				continue;
			}else{
				out.println(i);
				out.println(res[i].s.toString());
				i--; n--;
			}
		}
	}
	static class Pair{
		public int freq;
		public String s;
		public Pair(String ss){
			freq = 0;
			s = ss;			
		}
		public String toString(){
			return freq + " " + s;
		}
	}
	static class Freq{
		public int amt;
		public StringBuilder s;
		public Freq(String ss){
			s = new StringBuilder();
			s.append(ss);
			amt++;
		}
		public void add(String ss){
			if(amt % 6 == 0)
				s.append("\n");
			else
				s.append(" ");
			s.append(ss);
			amt++;
		}
	}
}