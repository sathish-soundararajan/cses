package Mathematics;

import java.util.*;
import java.io.*;

public class Josephus {
    
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

    public static int solve(int n, int k){
        if(n == 1) return 1; 
        if(k <= (n+1)/2){
            if(k * 2 > n) return (2 * k) % n; // on k == (n+1) / 2
            else return 2 * k; // on k < (n+1) / 2
        }

        int temp = solve(n/2, k - ((n+1)/2));
        if(n%2 == 1) return 2 * temp + 1; // as we divide n / 2 and we left out one odd position
        else return 2 * temp - 1; // otherwise get odd number by subtracting - 1
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
       
        int q = fr.nextInt();

        for(int i = 0; i < q; i++){
            int n = fr.nextInt();
            int k = fr.nextInt();

            pw.println(solve(n, k));
        }
        pw.close();
    }

}
