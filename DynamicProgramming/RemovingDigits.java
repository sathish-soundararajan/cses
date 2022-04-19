package DynamicProgramming;

import java.util.*;
import java.io.*;

public class RemovingDigits {
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


    private static List<Integer> getDigits(int number){
        List<Integer> digits = new LinkedList<>();

        while(number > 0){
            int digit = number % 10;
            if(digit != 0) digits.add(digit);
            number /= 10;
        }

        return digits;
    }


    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        // write logic here
        int n = fr.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            List<Integer> digits = getDigits(i);
            for (int k = 0; k < digits.size(); k++){
                dp[i] = Math.min(dp[i], 1 + dp[i - digits.get(k)]);
            }
        }
        pw.println(dp[n]);
        pw.close();
    }

}
