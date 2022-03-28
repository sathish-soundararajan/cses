package StringAlgorithm;

import java.util.*;
import java.io.*;

public class WordCombination {
       
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader(BufferedReader br){
           this.br = br; 
        }

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int[][] tier = new int[1000001][26];
    public static int c = 0;
    public static long MOD = 1000000007;
    public static boolean[] stop = new boolean[1000001];

    public static long[] dp;

    public static void insert(String s){
        int idx = 0;

        for(int i = 0; i < s.length(); i++){
            int ci = s.charAt(i) - 'a';
            if(tier[idx][ci] == 0){
                tier[idx][ci] = ++c;
            }
            idx = tier[idx][ci];
        }
        stop[idx] = true;
    }

    public static long search(String s, int x){
        int node = 0;
        long ans = 0;

        for(int i = x; i < s.length(); i++){
            int ci = s.charAt(i) - 'a';
            if(tier[node][ci] == 0) return ans;

            node = tier[node][ci];
            if(stop[node]){
                ans = (ans + dp[i + 1]) % MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        String s = fr.nextLine();
        int n = fr.nextInt();
        dp = new long[s.length() + 1];
        dp[s.length()] = 1;
        for(int i = 0; i < n; i++){
            String k = fr.nextLine();
            insert(k);
        }

        for(int i = s.length() - 1; i >= 0; i--){
            dp[i] = search(s, i);
        }
        System.out.println(dp[0]);
    }

}
