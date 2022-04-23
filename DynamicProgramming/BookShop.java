package DynamicProgramming;

import java.util.*;
import java.io.*;


public class BookShop {

    private static PrintWriter pw = new PrintWriter(System.out);
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
        // write logic here

        int n = fr.nextInt();
        int x = fr.nextInt();

        int[] cost = new int[n];
        int[] pages = new int[n];
        for(int i = 0; i < n; i++){
            cost[i] = fr.nextInt();
        }

        for(int i = 0; i < n; i++){
            pages[i] = fr.nextInt();
        }

        // x and i
        int[][] dp = new int[n+1][x+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= x; j++){
                if(j == 0 || i == 0){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], j - cost[i - 1] < 0 ? 0 : dp[i - 1][j - cost[i - 1]] + pages[i-1]);
            }
        }
        pw.println(dp[n][x]);
        pw.close();
    }

}
