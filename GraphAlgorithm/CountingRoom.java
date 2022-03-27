package GraphAlgorithm; 

import java.util.*;
import java.io.*;

public class CountingRoom {
    
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

    public static int[] dir = {0, 1, 0, -1, 0};
    public static Boolean[][] visited;
    public static long count = 0;
    

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = fr.nextInt();
        int m = fr.nextInt();

        char[][] map = new char[n][m];
        
        visited = new Boolean[n][m];
        for(int i = 0; i < n; i++){
            String s = fr.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                visited[i][j] = false;
            }
        }

       
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '.' && !visited[i][j]){
                    count++;

                    Queue<List<Integer>> queue = new LinkedList<>();
                    queue.add(List.of(i, j));
                    while(!queue.isEmpty()){
                        List<Integer> coord = queue.poll();
                        int row = coord.get(0);
                        int col = coord.get(1);

                        visited[row][col] = true;
                        map[row][col] = '#';
                        for(int k = 0; k < 4; k++){
                            int nxtRow = row + dir[k];
                            int nxtCol = col + dir[k+1];
                
                            if(nxtRow >= n || nxtRow < 0 || nxtCol < 0 || nxtCol >= m  || visited[nxtRow][nxtCol] || map[nxtRow][nxtCol] == '#'){
                                continue;
                            }
     
                            visited[nxtRow][nxtCol] = true;
                            queue.add(List.of(nxtRow, nxtCol));
                        }
                    }
                }
            }
        }

        pw.println(count);
        pw.close();
    }

}
