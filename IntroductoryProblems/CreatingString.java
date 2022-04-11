// package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class CreatingString {
    
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


    private static int[] freq = new int[26];
    private static PrintWriter pw = new PrintWriter(System.out);

    public static int fact(int n){
        if(n == 1) return 1;
        return n * fact(n - 1);
    }

    private static void findAllPermutation(int length, String s){

        if(length == s.length()){
            pw.println(s);
            return;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                freq[i]--;
                findAllPermutation(length, s + (char)('a' + i));
                freq[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        
       // write logic here

       String s = fr.nextLine();
       Arrays.fill(freq, 0);
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }


        int totalPermutation = fact(s.length());
        for(int i = 0; i < 26; i++){
            if(freq[i] > 1){
                // divide out permutation in repeative chars
                totalPermutation /= fact(freq[i]);
            }
        }

        pw.println(totalPermutation);
        // generate all permutation
        findAllPermutation(s.length(), "");
        pw.close();
    }

}
