import java.util.*;
import java.io.*;

public class MaximumSubArraySum {
    
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
       ArrayList<Integer> arr = new ArrayList<>(n);

       for(int i = 0; i < n; i++){
           arr.add(fr.nextInt());
       }

       long max = arr.get(0);
       long sum = 0;

       for(int i  = 0; i < n; i++){
            sum += arr.get(i);

            if(sum <= 0){
                max = Math.max(max, arr.get(i));
                sum = 0;
            }else{
                max = Math.max(max, sum);
            }

            
       }
       pw.println(max);
       pw.close();
    }

}
