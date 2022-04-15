//package SortingAndSearching;

import java.util.*;
import java.io.*;

public class MovieFestival {
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
        ArrayList<Pair> showTimes = new ArrayList<>();

        for(int i = 0; i < n; i++ ){
            showTimes.add(new Pair(fr.nextInt(), fr.nextInt()));
        }

        showTimes.sort((Pair a, Pair b) -> a.second - b.second);

        int res = 1;
        Pair last = showTimes.get(0);
        for(int i = 1; i < n; i++){
            if(last.second <= showTimes.get(i).first){
                last = showTimes.get(i);
                res++;
            }
        }

        pw.println(res);
        pw.close();
    }

}
