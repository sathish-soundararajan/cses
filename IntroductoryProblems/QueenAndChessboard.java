import java.util.*;
import java.io.*;

public class QueenAndChessboard {
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

    private static char[][] board = new char[8][8];

    // sets the row of the col on which piece is placed
    private static boolean[] col = new boolean[8];
    // sets diagonals
    private static boolean[] dia1 = new boolean[16];
    private static boolean[] dia2 = new boolean[16];

    private static long count = 0;

    public static void backtrack(int j){
        if(j == 8){
            count++;
            return;
        }

        for(int i = 0; i < 8; i++){
            if(board[i][j] == '*') continue;

            if(col[i] == false && dia1[i + j] == false && dia2[i - j + 7] == false){
                col[i] =  dia1[i + j] = dia2[i - j + 7] = true;
                backtrack(j + 1);
                col[i] =  dia1[i + j] = dia2[i - j + 7] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
       // write logic here
        
        

       for(int i = 0; i < 8; i++){
           String s = fr.nextLine();
           for(int j = 0; j < 8; j++){
            board[i][j] = s.charAt(j);
           }
       }


       backtrack(0);
       pw.println(count);
       pw.close();
    }

}
