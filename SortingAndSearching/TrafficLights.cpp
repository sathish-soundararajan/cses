// import java.util.*;
// import java.io.*;

// public class TrafficLights {
    
//     static class FastReader {
//         BufferedReader br;
//         StringTokenizer st;
//         public FastReader(BufferedReader br){
//            this.br = br; 
//         }

//         public FastReader()
//         {
//             br = new BufferedReader(
//                 new InputStreamReader(System.in));
//         }
 
//         String next()
//         {
//             while (st == null || !st.hasMoreElements()) {
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 }
//                 catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }
 
//         int nextInt() { return Integer.parseInt(next()); }
 
//         long nextLong() { return Long.parseLong(next()); }
 
//         double nextDouble()
//         {
//             return Double.parseDouble(next());
//         }
 
//         String nextLine()
//         {
//             String str = "";
//             try {
//                 str = br.readLine();
//             }
//             catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return str;
//         }
//     }


//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(
//                 new FileReader("input.txt"));
//         PrintWriter pw=new PrintWriter(new
//                 BufferedWriter(new FileWriter("output.txt")));
//         FastReader fr = new FastReader(br);
//         // FastReader fr = new FastReader();
//         // PrintWriter pw = new PrintWriter(System.out);

//         TreeSet<Integer> lights = new TreeSet<>();
//         TreeMap<Integer, Integer> lengths = new TreeMap<>();
        
//         int l = fr.nextInt();
//         int x = fr.nextInt();

//         for(int i = 0; i < x; i++){
//             int pos = fr.nextInt();

//             Integer high = lights.higher(pos);
//             Integer low  = lights.lower(pos);

//             if(high == null){
//                 high = l;
//             }
//             if(low == null){
//                 low = 0;
//             }

//             int diff = high - low;
//             if(lengths.containsKey(diff)){
//                 if(lengths.get(diff) == 1){
//                     lengths.remove(diff);
//                 }
//                 else{
//                     lengths.put(diff, lengths.get(diff) - 1);
//                 }
//             }

//             lengths.put(pos - low, lengths.getOrDefault(pos - low, 0) + 1);
//             lengths.put(high - pos, lengths.getOrDefault(high - pos, 0) + 1);
//             lights.add(pos);
//             pw.print(lengths.lastKey() + " ");
//         }
//        // write logic here
//        pw.close();
//     }

// }


#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int street_len;
	int light_num;
	cin >> street_len >> light_num;

	set<int> lights{0, street_len};
	multiset<int> dist{street_len};
	for (int l = 0; l < light_num; l++) {
		int pos;
		cin >> pos;

		auto it1 = lights.upper_bound(pos);
		auto it2 = it1;
		--it2;
		
		dist.erase(dist.find(*it1 - *it2));
		dist.insert(pos - *it2);
		dist.insert(*it1 - pos);
		lights.insert(pos);
		
		auto ans = dist.end();
		--ans;
		cout << *ans << " ";
	}
}