// package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.StringTokenizer;

public class SumOf2Values {
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
        int t = fr.nextInt();

        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(fr.nextInt(), i);
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                // Intentional: Reverse order for this demo
                return o1.first - o2.first;
            }
        });

        int i = 0;
        for(; i < n; i++){
            int rem = t - arr[i].first;
            if (rem < 0) {
                pw.println("IMPOSSIBLE");
                break;
            } else{
                if(rem == arr[i].first){
                    if(i + 1 < n && arr[i + 1].first == rem){
                        pw.println((arr[i].second + 1) + " " + (arr[i + 1].second + 1));
                        break;
                    }
                    pw.println("IMPOSSIBLE");
                    break;
                }
                int idx = binarySearch(arr, rem);
                if(idx == -1) continue;
                pw.println((arr[i].second +1 ) + " " + (arr[idx].second + 1));
                break;
            }
        }

        if(i == n)                 pw.println("IMPOSSIBLE");
        pw.close();
    }

    public static int binarySearch(Pair[] arr, int target){
        int l = 0; int r = arr.length - 1;

        while(l <= r){
            int mid =  l + ((r - l) / 2);

            if(arr[mid].first == target) return mid;
            if(arr[mid].first < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}
