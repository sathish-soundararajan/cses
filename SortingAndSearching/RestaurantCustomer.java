package SortingAndSearching;

import java.util.*;
import java.io.*;

class RestaurantCustomer {
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

    public static class Pair{
        public int first;
        public int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        // write logic here
        // coordinate path compression

        int n = fr.nextInt();
        ArrayList<Pair> intervals = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            intervals.add(new Pair(fr.nextInt(), 1));
            intervals.add(new Pair(fr.nextInt(), -1));
        }

        intervals.sort((Pair a, Pair b) -> {
            return a.first - b.first;
        });

        int sum = 0;
        int res = 0;

        for(Pair i :intervals){
            sum += i.second;
            res = Math.max(res, sum);
        }
        pw.println(res);
        pw.close();
    }

}
