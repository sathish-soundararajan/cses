import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Towers {
    
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
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt  = 0;
        
        for(int i = 0; i < n; i++){
            int v = fr.nextInt();

            Entry<Integer, Integer> entry = map.higherEntry(v);
            if(entry == null){
                map.put(v, map.getOrDefault(v, 0) + 1);
                cnt++;
            }else{
                if(map.get(entry.getKey()) == 1){
                    map.remove(entry.getKey());
                }else{
                    map.put(entry.getKey(), map.get(entry.getKey()) - 1);
                }
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }

        pw.println(cnt);
        pw.close();
    }

}
