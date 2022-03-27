package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class WeirdAlgorithm{

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
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

    public static void main(String[] args){

        FastReader fr = new FastReader();
        long n = fr.nextLong();
        System.out.print(n+" ");
        while(n != 1){
            if((n & 1) == 1){
                n = (n * 3) + 1;
            }else{
                n /= 2;
            }

            System.out.print(n + " ");
        }
    }
}