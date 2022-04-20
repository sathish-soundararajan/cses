package GraphAlgorithm;

import java.util.*;
import java.io.*;

public class Labyrinth {
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

    public static class Pair<T, R>{
        public T first;
        public R second;

        public static <T, R> Pair<T, R> of(T first, R second){
            return new Pair<>(first, second);
        }

        Pair(T first, R second){
            this.first = first;
            this.second = second;
        }
    }

    public static int[] dir = {0, 1, 0, -1, 0};
    public static char[] dirChar = {'R', 'D', 'L', 'U'};

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();


        // write logic here

        int n = fr.nextInt();
        int m = fr.nextInt();

        char[][] grid = new char[n][m];
        Pair<Integer, Integer>[][] parent = new Pair[n][m];
        boolean[][] visited = new boolean[n][m];
        int startX = 0; int startY = 0;
        int endX = 0; int endY = 0;

        for(int i = 0; i < n; i++){
            String s = fr.nextLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == 'A'){
                    startX = i;
                    startY = j;
                }
                if(s.charAt(j) == 'B'){
                    endX = i;
                    endY = j;
                }
                grid[i][j] = s.charAt(j);
            }
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(Pair.of(startX, startY));
        boolean found = false;
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Pair<Integer, Integer> node = q.poll();

            if(grid[node.first][node.second] == 'B'){
                found = true;
                break;
            }

            for(int k = 0; k < dir.length - 1; k++){
                int nextX = node.first + dir[k];
                int nextY = node.second + dir[k + 1];

                if(nextX < 0 || nextY < 0 || nextY >= m || nextX >= n || grid[nextX][nextY] == '#' ||
                        visited[nextX][nextY]){
                    continue;
                }

                parent[nextX][nextY] = Pair.of(node.first, node.second);
                visited[nextX][nextY] = true;
                q.add(Pair.of(nextX, nextY));
            }

        }
      
        if(!found){
            pw.println("NO");
        }else{
            pw.println("YES");

            StringBuffer strBuffer = new StringBuffer();
            Pair<Integer, Integer> p = parent[endX][endY];
            Pair<Integer, Integer> curr = Pair.of(endX, endY);

            while(true){
                if(curr.second - p.second > 0) strBuffer.append('R');
                else if(curr.second - p.second < 0) strBuffer.append('L');
                else if(curr.first - p.first > 0) strBuffer.append('D');
                else  strBuffer.append('U');
                if(p.first == startX && p.second == startY) break;

                curr = p;
                p = parent[curr.first][curr.second];
            }

            String res = strBuffer.reverse().toString();
            pw.println(res.length());
            pw.println(res);
        }

        pw.close();
    }

}
