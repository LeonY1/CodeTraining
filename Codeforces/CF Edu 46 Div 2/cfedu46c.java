import java.util.*;
import java.io.*;

public class cfedu46c{
	public static void main(String [] args) throws IOException{
		InputReader in = new InputReader("cfedu46c.in");
		
		int n = in.nextInt();
		ArrayList<xEvent> nodes = new ArrayList<xEvent>();
		long [] cnt = new long[n + 1];

		for(int i = 0;i < n; i++){
			xEvent e = new xEvent(Long.parseLong(in.next()), Long.parseLong(in.next()), 1);
			ArrayList<xEvent> nodes2 = new ArrayList<xEvent>();
			boolean added = false;
			for(int j = 0; j < nodes.size(); j++){
				xEvent ne = nodes.get(j);
				if(e.s > ne.e || e.e < ne.s)
					continue;
				if(e.s >= ne.s && e.s <= ne.e || e.e >= ne.s && e.e <= ne.e){
					added = true;
					nodes.remove(j--);
					if(e.s >= ne.s && e.e <= ne.e){
						if(ne.e - e.e > 0)
							nodes2.add(new xEvent(e.e + 1, ne.e, ne.cnt));
						if(e.s - ne.s > 0)
							nodes2.add(new xEvent(ne.s, e.s - 1, ne.cnt));

						nodes2.add(new xEvent(e.s, e.e, ne.cnt + e.cnt));
					}
					else if(e.s >=  ne.s && e.s <= ne.e){
						nodes2.add(new xEvent(e.s, ne.e, ne.cnt + e.cnt));
						nodes2.add(new xEvent(ne.e + 1, e.e, e.cnt));
						if(e.s != ne.s)
							nodes2.add(new xEvent(ne.s, e.s - 1, ne.cnt));

					}
					else if(e.e >= ne.s && e.e <= ne.e){
						nodes2.add(new xEvent(ne.s, e.e, ne.cnt + e.cnt));
						nodes2.add(new xEvent(e.s, ne.s - 1, e.cnt));
						if(e.e != ne.e)
							nodes2.add(new xEvent(e.e + 1, ne.e, ne.cnt));
					}

				}
			}
			if(added == false)
				nodes.add(e);
			nodes.addAll(nodes2);

		}
		for(xEvent e: nodes){
			cnt[e.cnt] += e.e - e.s + 1;
		}
		for(int i = 1; i <= n; i++){
			if(i != n)
				System.out.print(cnt[i] + " ");
			else
				System.out.print(cnt[i]);
		}
	}
	static class xEvent{
		long s, e;
		int cnt;
		public xEvent(long l, long r, int cnt){
			s = l;
			e = r;
			this.cnt = cnt;
		}
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