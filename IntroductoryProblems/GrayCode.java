import java.util.*;
import java.io.*;

public class GrayCode {
    
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
       // write logic here

        int n = fr.nextInt();

        for(int i = 0; i < Math.pow(2, n); i++){
            // logic:
            // approach 1: generate binary possible of length 1 and have another list with reverse order
            //             append zero and ones to the respective list and do it recursively
            // approach 2: there is beautiful property, as stated by below expression
            //             i ^ (i >> 1), MSB remains same as the number and remaining bits are obtained by
            //             xor operation of right shifted number
            int bit = i ^ (i >> 1);
            String bitstring =  "00000000000000000000000000000000" + Integer.toBinaryString(bit);
            pw.println(bitstring.substring(bitstring.length() - n));
        }
       pw.close();
    }

}
