
import java.util.*;
import java.io.*;

public class MinimizingCoin {
    
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


    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
       // write logic here

       int n = fr.nextInt();
       int x = fr.nextInt();
       int[] coins = new int[n];
       int[] dp = new int[x + 1];
       Arrays.fill(dp, Integer.MAX_VALUE);

       for(int i = 0; i < coins.length; i++){
           coins[i] = fr.nextInt();
           if(coins[i] <= x){
            dp[coins[i]] = 1;
           }
       }


       for(int i = 1; i < dp.length; i++){
           for(int coin: coins){
               if(i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE){
                   dp[i] = Math.min(dp[i], dp[i - coin] + 1);
               }
           }
       }

       pw.println(dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
       pw.close();
    }

}
