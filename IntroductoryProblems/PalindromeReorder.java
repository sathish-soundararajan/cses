// package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class PalindromeReorder {
    
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

    public static String repeat(char c, int times){
        String s = "";
        for(int i = 0; i < times; i++){
            s += c;
        }

        return s;
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
       // write logic here

       String s = fr.nextLine();
       int[] freq = new int[26];
       Arrays.fill(freq, 0);

       for(int i = 0; i < s.length(); i++){
           freq[s.charAt(i) - 'A']++;
       }

       int cnt = 0;
       char oddChar = 'A';
       int times = 0;

       for(int i = 0; i < 26; i++){
        if(freq[i] % 2 == 0){
            continue;
        }
        
        oddChar = (char)('A' + i);
        cnt++;
        times = freq[i];
        freq[i] = 0;
        if(cnt > 1){
            pw.println("NO SOLUTION");
            pw.close();
            return;
        }
       }

       for(int i = 0; i < 26; i++){
           if(freq[i] == 0) continue;
           char c = (char)('A' + i);
           for(int j = 0; j < freq[i] / 2; j++){
               pw.print(c);
           }
       }

       for(int i = 0; i < times; i++){
           pw.print(oddChar);
       }

       for(int i = 25; i >= 0; i--){
            if(freq[i] == 0) continue;
            char c = (char)('A' + i);
            for(int j = 0; j < freq[i] / 2; j++){
                pw.print(c);
            }
        }
       pw.close();
    }

}
