import java.util.*;
import java.io.*;

public class CollectingNumber {
    
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
       ArrayList<Integer> arr1 = new ArrayList<>(n + 1);
       for(int i = 0; i < n; i++){
           arr.add(fr.nextInt());
           arr1.add(0);
       }
       arr1.add(0);

       for(int i = 0; i < n; i++){
           arr1.set(arr.get(i), i);
       }

       int count  = 1;
       for(int i = 2; i <= n; i++){
        if(arr1.get(i) < arr1.get(i - 1)){
            count++;
        }
       }

       pw.println(count);
       pw.close();
    }

}
