import java.util.*;
import java.io.*;

public class Repetitions {

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
//        PrintWriter pw = new PrintWriter(System.out);

        String s = fr.nextLine();
        int maxLength = 1;
        int cnt = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) != s.charAt(i)){
                cnt = 1;
                continue;
            }
            cnt++;
            maxLength = Math.max(maxLength, cnt);
        }

        System.out.println(maxLength);
    }

}
