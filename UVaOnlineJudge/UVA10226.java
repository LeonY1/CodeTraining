import java.util.*;
import java.io.*;

public class UVA10226{
	public static void main(String [] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		in.readLine();

		for(int i = 0;i < n; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<String> list = new ArrayList<String>();
			String s = "";
			int total = 0;
			while(!(s = in.readLine()).equals("")){
				if(map.get(s) == null){
					map.put(s, 1);
					list.add(s);
				}
				else
					map.put(s, map.get(s) + 1);
				total++;
			}
			Collections.sort(list);
			for(String s1: list){
				System.out.printf("%s %.4f\n", s1, map.get(s1) * 1.0  / total); 
			}

		}
	}
}
