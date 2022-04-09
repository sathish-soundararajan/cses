import java.util.*;
import java.io.*;

public class TwoKnights {
    
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

        // total way to place two knights - (no of ways two knights attack each other)
        // two knights attack each other when it is placed inside 2 * 3 or 3 * 2 area
        // which is (n - 1)(n - 2) + (n-2)(n-1)
        // and 2 placement for attacking each other, then 4(n-1)(n-2)
        // so, finally the no of ways is n^2(n^2 - 1)/2 - 4(n-1)(n-2)

        int n = fr.nextInt();

        for(long k = 1L; k <= n; k++){
            long totalWays = (( k * k ) * (( k * k)  - 1)) / 2;
            long attackEachOther = 4 * ( k - 1) * (k - 2);
            pw.println(totalWays - attackEachOther);
        }
       pw.close();
    }

}
