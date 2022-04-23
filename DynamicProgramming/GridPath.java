package DynamicProgramming;

import java.util.*;
import java.io.*;

public class GridPath {
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

    public static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        // write logic here
        int n = fr.nextInt();

        char[][] grid = new char[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            String s = fr.nextLine();
            for(int j = 0; j < n; j++){
                grid[i][j] = s.charAt(j);
            }
        }

        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]  == '*'){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) continue;
                if(i == 0){
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }

                if(j == 0){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        pw.println(dp[n - 1][n - 1]);
        pw.close();
    }

}
