//package TreeAlgorithm;

import java.util.*;
import java.io.*;

public class TreeDiameter {
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

    public static int level = 0;
    public static int bfs(ArrayList<Integer>[] adj, int node, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int res = node;
        while (!q.isEmpty()) {
            level++;
            Queue<Integer> nxt = new LinkedList<>();
            while (!q.isEmpty()) {
                int v = q.poll();
                res = v;
                if(adj[v] == null) continue;
                for (int nx : adj[v]) {
                    if (visited[nx]) continue;

                    visited[nx] = true;
                    nxt.add(nx);
                }
            }
            q = nxt;
        }
        return res;
    }

    public static void solve(ArrayList<Integer>[] adj, int n){

        int endNode = bfs(adj, 1, n);
        level = 0;
        bfs(adj, endNode, n);
        pw.println(level - 1);
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(
        //         new FileReader("input.txt"));
        // PrintWriter pw=new PrintWriter(new
        //         BufferedWriter(new FileWriter("output.txt")));
        FastReader fr = new FastReader();
        // write logic here
        int n = fr.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for(int i = 0; i < n - 1; i++){
            int u = fr.nextInt();
            int v = fr.nextInt();

            if(adj[u] == null) adj[u] = new ArrayList<>();
            if(adj[v] == null) adj[v] = new ArrayList<>();
            adj[u].add(v);
            adj[v].add(u);
        }
        solve(adj, n);
        pw.close();
    }

}


