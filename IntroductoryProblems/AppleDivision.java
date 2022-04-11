// package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class AppleDivision {
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

       long sum = 0;
       long[] arr = new long[n];
       for(int i = 0; i < n; i++){
        arr[i] = fr.nextLong();
        sum += arr[i];
       }

       long min = divideTwoSet(arr, 0, sum, 0);
       pw.println(min);
       pw.close();
    }

    // try out all possiblities as input constraint is small, O(2 ^ n)
    private static long divideTwoSet(long[] arr, long sum, long totalSum, int i) {

        if(i == arr.length){
            long a = totalSum - sum;
            long b = totalSum - a;
            return Math.abs(a - b);
        }

        return Math.min(divideTwoSet(arr, sum + arr[i], totalSum, i + 1),
            divideTwoSet(arr, sum, totalSum, i + 1));
    }

}
