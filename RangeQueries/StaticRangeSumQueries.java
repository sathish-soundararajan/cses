package RangeQueries;

import java.util.*;
import java.io.*;

public class StaticRangeSumQueries {
    
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
        
        int n = fr.nextInt();
        int q = fr.nextInt();

        long[] arr = new long[n + 1];
        long[] prefix = new long[n+1];
        prefix[0] = 0L;

        for(int i = 1; i <= n; i++){
            arr[i] = fr.nextLong();
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0; i < q; i++){
            int l = fr.nextInt();
            int r = fr.nextInt();

            pw.println(prefix[r] - prefix[l-1]);
        }
        pw.close();
    }

}
