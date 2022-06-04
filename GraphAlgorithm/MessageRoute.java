package GraphAlgorithm;
import java.util.*;
import java.io.*;

public class MessageRoute {

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

    public static int[] parent;
    public static boolean[] visited;
    public static void bfs(ArrayList<List<Integer>> adj, int node, int target){

        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int n = q.poll();

            for(int k: adj.get(n)){
                if(visited[k]) continue;

                visited[k] = true;
                parent[k] = n;
                q.add(k);
            }

            if(visited[target]) break;
        }
    }

    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(
                 new FileReader("test_input.txt"));
         PrintWriter pw=new PrintWriter(new
                 BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader(br);
        // write logic here
        int n = fr.nextInt();
        int m = fr.nextInt();

        parent = new int[n + 1];
        visited = new boolean[n + 1];

        ArrayList<List<Integer>> adj = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++){
            adj.add(new LinkedList<>());
        }
        for(int i = 0; i < m; i++){
            int a = fr.nextInt();
            int b = fr.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs(adj, 1, n);
        if(!visited[n]){
            pw.println("IMPOSSIBLE");
        }else{
            List<Integer> path = new LinkedList<>();
            int k = n;
            while(k != 1){
                path.add(k);
                k = parent[k];
            }
            path.add(1);

            pw.println(path.size());
            for(int i = path.size() - 1; i >= 0; i--){
                pw.print(path.get(i) + " ");
            }
        }

        pw.close();
    }
}
