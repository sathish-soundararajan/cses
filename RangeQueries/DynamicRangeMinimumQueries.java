

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class DynamicRangeMinimumQueries {

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

    public static class SegmentTree{
        int[] tree;
        int n;

        public SegmentTree(int[] arr){
            n = arr.length;
            tree = new int[2*n];
            for(int i = 0; i < n; i++) tree[i + n] = arr[i];
            buildTree();
        }

        public void buildTree(){
            for (int i = n-1; i > 0; --i) tree[i] = Math.min(tree[i<<1], tree[i<<1|1]);
        }
//        0 1 2 3 4 5 6
//        0 1 2 3

        public void print(){
            System.out.println(Arrays.toString(tree));
        }

        void modify(int p, int value){
            p = p + n + 1;
            tree[p] = value;
            for(; p > 1; p >>= 1) tree[p >> 1] = Math.min(tree[p], tree[p ^ 1]);
        }

        int query(int l, int r) {  // sum on interval [l, r)
            int res = Integer.MAX_VALUE;
            for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
                if ((l&1) > 0) res = Math.min(res, tree[l++]);
                if ((r&1) > 0) res = Math.min(res, tree[--r]);
            }
            return res;
        }

    }

    public static class SegmentTreeLazy{

        int[] tree;
        int[] delayedUpdate;
        int n;
        int height;

        public SegmentTreeLazy(int[] arr){
            n = arr.length;
            tree = new int[2 * n];
            delayedUpdate = new int[n];
            // get highest significant bit
            height = Integer.bitCount(Integer.MAX_VALUE) + 1 - Integer.numberOfLeadingZeros(n);
            for(int i = 0; i < n; i++) tree[i + n] = arr[i];
            buildTree();
        }
        
        public void buildTree(){
            for (int i = n-1; i > 0; --i) tree[i] = Math.min(tree[i<<1], tree[i<<1|1]);
        }
        
        void set(int left, int right, int value){
            left = left + n;
            right = right + n;

            int left0 = left; int right0 = right;
            for(;left < right; left >>= 1, right >>= 1){
                if((left & 1) > 0) apply(left++, value);
                if((right & 1) > 0) apply(--right, value);
            }
            build(left0);
            build(right0 - 1);
        }

        int query(int left, int right){
            left += n; right += n;
            push(left);
            push(right - 1);

            int ans = Integer.MAX_VALUE;
            for(;left < right; left >>= 1, right >>= 1){
                if((left & 1) > 0) ans = Math.min(ans, tree[left--]);
                if((right & 1) > 0) ans = Math.min(ans, tree[--right]);
            }
            return ans;
        }

        // helpers
        void build(int node){
            while(node > 1){
                node >>= 1;
                if(delayedUpdate[node] == 0){
                    tree[node] = Math.min(tree[node << 1], tree[(node << 1) | 1]);
                }else{
                    tree[node] = delayedUpdate[node];
                }
            }
        }

        void push(int node){
            for(int h = height; h > 0; h--){
                int n = node >> h;
                if(delayedUpdate[n] != 0){
                    apply(n >> 1, delayedUpdate[n]);
                    apply((n >> 1)|1, delayedUpdate[n]);
                    delayedUpdate[n] = 0;
                }
            }
        }

        void apply(int node, int value){
            tree[node] = value;
            if(node < n) delayedUpdate[node] = value;
        }
        
        void print(){
            System.out.println(Arrays.toString(tree));
        }
    }

    public static void main(String[] args){

        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = fr.nextInt();
        int q = fr.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }

        SegmentTreeLazy st = new SegmentTreeLazy(arr);

        // st.print();
        for(int i = 0; i < q; i++){
            int operationType = fr.nextInt();
            int l = fr.nextInt();
            int r = fr.nextInt();
            
            if(operationType == 2){
                pw.println(st.query(l-1, r));
            }else{
                st.set(l-1, l+1, r);
            }
            
        }
        pw.close();
    }
}

