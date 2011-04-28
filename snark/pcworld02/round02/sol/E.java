import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("cube.in"));
        out = new PrintWriter("cube.out");

        int n = Integer.parseInt(in.readLine());
        int k = 1 << n;
        int c[] = new int[k];
        for(int i = 0; i < k; ++i) {
            c[i] = Integer.parseInt(in.readLine());
        }

        int d[] = new int[k];
        d[0] = c[0];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()) {
            int v = q.poll();

            for(int j = 0; j < n; ++j) {
                if((v & (1 << j)) == 0) {
                    int w = v | (1 << j);
                    if(d[w] < d[v] + c[w]) {
                        d[w] = d[v] + c[w];
                        q.add(w);
                    }
                }
            }
        }

        out.println(d[k - 1]);        

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
