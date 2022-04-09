import java.util.*;
import java.io.*;

public class NumberSpiral {
    
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
        PrintWriter pw = new PrintWriter(System.out);
        int t = fr.nextInt();

        while(t > 0){
            long x = fr.nextInt();
            long y = fr.nextInt();
            
            long result;
            if(x > y){
                result = x % 2 == 0 ? (x * x) + 1 - y :  (x - 1) * (x - 1) + y;
            }else{
                result = y % 2 == 0 ? (y - 1) * (y - 1) + x :  (y * y) + 1 - x ;
            }
            pw.println(result);
            t--;
        }
        pw.close();
    }

}
