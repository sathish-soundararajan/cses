import java.util.*;
import java.io.*;

public class CollectingNumber2 {
    
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

    private static class Pair<U, V>
    {
        public final U first;       // the first field of a pair
        public final V second;      // the second field of a pair
     
        // Constructs a new pair with specified values
        private Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }
     
        @Override
        // Checks specified object is "equal to" the current object or not
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
     
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
     
            Pair<?, ?> pair = (Pair<?, ?>) o;
     
            // call `equals()` method of the underlying objects
            // if (!first.equals(pair.first)) {
            //     return false;
            // }
            // return second.equals(pair.second);
            if((first.equals(pair.first) && second.equals(pair.second)) || 
            (first.equals(pair.second) && second.equals(pair.first))){
                return true;
            }
            return false;
        }
     
        @Override
        // Computes hash code for an object to support hash tables
        public int hashCode()
        {
            // use hash codes of the underlying objects
            return 31 * first.hashCode() + second.hashCode();
        }
     
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
     
        // Factory method for creating a typed Pair immutable instance
        public static <U, V> Pair <U, V> of(U a, V b)
        {
            // calls private constructor
            return new Pair<>(a, b);
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
       int m = fr.nextInt();
       
       int[] a = new int[n + 1];
       int[] idx = new int[n  + 2];
       for(int i = 1; i <= n; i++){
           a[i] = fr.nextInt();
           idx[a[i]] = i;
       }
       
       int count  = 1;
       for(int i = 1; i <= n; i++){
        if(idx[i] < idx[i - 1]){
            count++;
        }
       }

       for(int i = 0; i < m; i++){
           int x = fr.nextInt();
           int y = fr.nextInt();

           int r = a[x], s = a[y];
           
           int temp = a[x];
           a[x] = a[y];
           a[y] = temp;

           if (idx[r-1] <= idx[r] && idx[r-1] > y) count++;
           if (idx[r-1] > idx[r] && idx[r-1] <= y) count--;
           if (idx[r] <= idx[r+1] && y > idx[r+1]) count++;
           if (idx[r] > idx[r+1] && y <= idx[r+1]) count--;		
           idx[r] = y;
           if (idx[s-1] <= idx[s] && idx[s-1] > x) count++;
           if (idx[s-1] > idx[s] && idx[s-1] <= x) count--;
           if (idx[s] <= idx[s+1] && x > idx[s+1]) count++;
           if (idx[s] > idx[s+1] && x <= idx[s+1]) count--;	
           idx[s] = x;
           pw.println(count);
       }

       pw.close();
    }

}
