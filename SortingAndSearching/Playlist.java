import java.util.*;
import java.io.*;

public class Playlist {
    
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

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }

        int i = 0;
        int j = 0;
        Map<Integer, Integer> ref = new HashMap<>();
        int res = 0;
        while(j < n){
            if(ref.containsKey(arr[j])){
                int idx = ref.get(arr[j]);
                while(i <= idx){
                    ref.remove(arr[i]);
                    i++;
                }
            }

            ref.put(arr[j], j);
            j++;
            res = Math.max(res, ref.keySet().size());
        }

        pw.println(res);
        pw.close();
    }

}
