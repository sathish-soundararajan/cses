package SortingAndSearching;


import java.util.*;
import java.io.*;

public class FerrisWheel {
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
        int capacity = fr.nextInt();

        Integer[] weights = new Integer[n];

        for(int i = 0; i < n; i++){
            weights[i] = fr.nextInt();
        }

        Arrays.sort(weights);
        int gondals = 0;
        int i = 0; int j = weights.length - 1;

        while(i <= j){
            if(i == j || weights[i]  + weights[j] <= capacity){
                gondals++;
                i++; j--;
                continue;
            }

            gondals++;
            j--;
        }
        pw.println(gondals);
        pw.close();
    }

}
