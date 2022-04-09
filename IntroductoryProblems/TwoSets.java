
import java.util.*;
import java.io.*;

public class TwoSets {
    
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
        int n = fr.nextInt();
        long total = ((long)n * (long)(n + 1)) / 2;

        if((total & 1) == 1){
            pw.println("NO");
        }else{
            long required = total / 2;
            Set<Integer> s = new HashSet<>();
            long sum = 0;

            for(int i = n; i >= 1; i--){
                if(sum + i > required){
                    continue;
                }
                s.add(i);
                sum += i;
            }

            if(sum != required){
                pw.println("NO");
            }else{
                pw.println("YES");
                pw.println(s.size());
                for(int i = 1; i <= n; i++){
                    if(!s.contains(i)) continue;
                    pw.print(i + " ");
                }
                pw.println("\n" + (n - s.size()));
                for(int i = 1; i <= n; i++){
                    if(s.contains(i)) continue;
                    pw.print(i + " ");
                }
            }
        }

        pw.close();
    }

}
