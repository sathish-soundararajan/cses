// package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class TowerOfHanoi {
    private static PrintWriter pw = new PrintWriter(System.out);
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

    // simple recursive approach, where source, intermediate and target pole changes at each level
    public static void printMoves(int a, int b, int c, int n){
        if(n == 0) return;
        // need to shift all n-1 small disk from a to b
        printMoves(a, c, b, n - 1);
        // print move of large disk from a to c
        pw.println(a + " " + c);
        // remove all disk from b to c
        printMoves(b, a, c, n - 1);
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
       // write logic here

       int n = fr.nextInt();

       // logic: 2 * noOfMoves(n-1) + 1(operation for moving large disk)
       //        which is similar to below equation
       int minMoves = (int)Math.pow(2, n) - 1;
       pw.println(minMoves);

       printMoves(1, 2, 3, n);


       pw.close();
    }

}
