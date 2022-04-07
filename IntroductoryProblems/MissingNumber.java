// package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class MissingNumber {
    
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
//         BufferedReader br = new BufferedReader(
//                 new FileReader("test_input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = fr.nextInt();

        boolean[] found = new boolean[n + 1];
        Arrays.fill(found, false);

        for(int i = 0; i < n - 1; i++){
            int v = fr.nextInt();
            found[v] = true;
        }

        int missingNumber = -1;
        for(int i = 1; i <= n; i++){
            if(!found[i]){
                missingNumber = i;
                break;
            }
        }

        System.out.println(missingNumber);
    }

}
