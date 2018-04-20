import java.util.*;
import java.io.*;

public class unionfind{
	public static void main(String [] args) throws Exception{
		Union test = new Union(5);
		System.out.println(test);

		test.unionSet(0,1);
		System.out.println(test);

		test.unionSet(2,3);
		System.out.println(test);

		test.unionSet(4,3);
		System.out.println(test);

		test.unionSet(0,3);
		System.out.println(test);

		test.findSet(0);
		System.out.println(test);

		System.out.println(test.sizeOfSet(0));
	}
}
class Union{
	int [] parent, rank, card;
	int numOfSets;
	public Union(int n){
		parent = new int[n];
		rank = new int[n];
		card = new int[n];
		numOfSets = n;

		for(int i = 0; i < n; i++){
			parent[i] = i;
			rank[i] = 0;
			card[i] = 1;
		}

	}
	public void unionSet(int i, int j){
		if(!isSameSet(i, j)){
			int set1 = findSet(i);
			int set2 = findSet(j);
			if(rank[set1] > rank[set2]){
					parent[set2] = set1;
					card[set1] += card[set2];
					card[set2] = 0;
			}
			else{
				parent[set1] = set2;
				if(rank[set1] == rank[set2]) rank[set2]++;
				card[set2] += card[set1];
				card[set1] = 0;
			}
			numOfSets--;
		}
	}
	public int findSet(int n){
		parent[n] = (parent[n] == n) ? n: findSet(parent[n]);
		return parent[n];
	}
	public boolean isSameSet(int i, int j){
		return findSet(i) == findSet(j);
	}
	public int numDisjointSets(){
		return numOfSets;
	}
	public int sizeOfSet(int i){
		return card[findSet(i)];
	}
	public String toString(){
		String res = "";
		for(int i = 0; i < parent.length; i++){
			res += i + " " + parent[i] + " " + rank[i]+ " " + card[i] +"\n";
		}
		res += numOfSets + "\n";
		return res;
	}
}
