package SortingAndSearching;

import java.util.*;
import java.io.*;

public class DistinctNumber {
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

        int n = fr.nextInt();
        int count = 1;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }


        Arrays.sort(arr);
        for(int i = 1; i < n; i++){
            if(arr[i-1]!=arr[i]){
                count++;
            }
        }

        System.out.println(count);
    }
}
