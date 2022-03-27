package DynamicProgramming;

import java.util.*;
import java.io.*;

public class DiceCombination {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
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

    public static long MOD = 1000000007;

    public static void main(String[] args){
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0L);
        for(int i = 1; i <= Math.min(n, 6); i++){
            dp[i] = 1;
        }

        for(int i = 2; i <= n; i++){
            long sum = 0L;
            for(int j = 1; j <= 6; j++){
                if(i - j < 1) break;
                sum = (sum + dp[i - j]) % MOD;
            }
            dp[i] += sum;
        }
        
        System.out.println(dp[n]);
    }

}
