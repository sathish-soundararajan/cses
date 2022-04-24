import java.util.*;
import java.io.*;

public class DigitQueries {
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


    public static char solve(long n){
        int c = 1;
        for (long p = 9;; n -= p, c++, p = 9*(long)Math.pow(10, c-1)*c) {
            if (n - p <= 0) break;
        }
        n--;
        long x = n/c;
        long y = n%c;
        long ans = (long)Math.pow(10, c-1) + x;
        return String.valueOf(ans).charAt((int)y);
    }


    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
       // write logic here

       int q = fr.nextInt();

       for(int i = 0; i < q; i++){
           long k = fr.nextLong();
           pw.println(solve(k));
       }
       pw.close();
    }

}
