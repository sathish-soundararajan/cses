package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class BitsString {
    
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

    private static long MOD = 1000000007;

    private static long powMod(int v, int x){
        if(x == 0){
            return 1;
        }

        if((x & 1) == 1){
            return (v * powMod(v, x - 1)) % MOD;
        }

        int half = x / 2;
        long val = powMod(v, half);
        return (val * val) % MOD;
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
       
        int n = fr.nextInt();

        pw.println(powMod(2, n));
        pw.close();
    }

}
