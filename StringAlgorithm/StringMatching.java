package StringAlgorithm;

import java.util.*;
import java.io.*;

public class StringMatching {
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

    public static int[] createTable(String s){
        int i = 0;
        int[] table = new int[s.length()];

        for(int j = 1; j < s.length(); j++){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                table[j] = i;
            }else{
                if(i > 0){
                    i = table[i-1];
                }else{
                    table[j] = i;
                    i++;
                }
            }
        }

        return table;
    }

    public static int kmp(String pattern, String text){
        // implement kmp algorithm
        int[] table = createTable(pattern);
        int n = text.length();
        int m = pattern.length();
        int j = 0;int cnt = 0;
        for(int i = 0; i < n; i++){
            if(text.charAt(i) == pattern.charAt(j)){
                j++;
            }else if (pattern.charAt(j) != text.charAt(i)){
                if(j > 0){
                    j = table[j - 1];
                    i--;
                }
            }

            if(j == m){
                cnt++;
                j = table[j - 1];
            }

        }
        return cnt;

    }
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        // write logic here

        // robin karp implementation

        String text = fr.nextLine();
        String pattern = fr.nextLine();
        pw.println(kmp(pattern, text));
//        int sLength = s.length();
//        int targetLength = target.length();
//
//        if (sLength < targetLength || targetLength == 0) {
//            pw.println(0);
//            return;
//        }
//
//        long targetHash = 0;
//        long sHash = 0;
//        long targetHash1 = 0;
//        long sHash1 = 0;
//        long x = 26;
//        long nx = 1;
//        long x1 = 256;
//        long nx1 = 1;
//        long MOD = 1000000007;
//        int res = 0;
//
//        for(int i = targetLength - 1; i >= 0; i--){
//            if(i != targetLength - 1){
//                nx = (nx * x) % MOD;
//                nx1 = (nx1 * x1) % MOD;
//            }
//            targetHash = ((targetHash +  ((int)target.charAt(i) * nx) % MOD) + MOD) % MOD;
//            sHash = ((sHash +  ((int)s.charAt(i) * nx) % MOD) + MOD) % MOD;
//            targetHash1 = ((targetHash1 +  ((int)target.charAt(i) * nx1) % MOD) + MOD) % MOD;
//            sHash1 = ((sHash1 +  ((int)s.charAt(i) * nx1) % MOD) + MOD) % MOD;
//        }
//
//        for(int i = 0; i <= sLength - targetLength; i++){
//            if(i > 0) {
//                sHash = ((x * (sHash - (((int)s.charAt(i-1) * nx) % MOD) + MOD)) % MOD) + s.charAt(i + targetLength - 1);
//                sHash1 = ((x1 * (sHash1 - (((int)s.charAt(i-1) * nx1) % MOD) + MOD)) % MOD) + s.charAt(i + targetLength - 1);
//            }
//            if(targetHash == sHash && targetHash1 == sHash1){
//                if(target.equals(s.substring(i, i + targetLength))){
//                    res++;
//                }
//            }
//        }

//        ppippuakapppias
//                pp

//        hash = cx2+bx+a
//                (x(hash - cx2) + code(i))
//


//        pw.println(res);
        pw.close();
    }

}
