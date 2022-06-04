package DynamicProgramming;
import java.util.*;
import java.io.*;

public class ArrayDescription {
    private static final int mod = 1000000007;
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
        int m = fr.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }

        int[][] dp = new int[100001][101];

        if(arr[0] == 0){
            Arrays.fill(dp[0], 1);
        }else{
            dp[0][arr[0]] = 1;
        }

        for(int i = 1; i < n; i++){
            if(arr[i] == 0){
                for(int j = 1; j <= m; j++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % mod;
                    if(j - 1 > 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % mod;
                    if(j + 1 <= m) dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % mod;
                }
            }else{
                dp[i][arr[i]] = (dp[i][arr[i]]  + dp[i - 1][arr[i]]) % mod;
                if(arr[i] - 1 > 0) dp[i][arr[i]] = (dp[i][arr[i]]  + dp[i - 1][arr[i] - 1]) % mod;
                if(arr[i] + 1 <= m) dp[i][arr[i]] = (dp[i][arr[i]]  + dp[i - 1][arr[i] + 1]) % mod;
            }

//            pw.println(Arrays.toString(dp[i]));
        }

        int ans = 0;
        for(int i = 1; i <= m; i++){
            ans += dp[n-1][i];
            ans %= mod;
        }

        pw.println(ans);
        pw.close();
    }

}
