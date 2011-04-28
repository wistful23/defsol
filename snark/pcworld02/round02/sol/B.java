import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("walk.in"));
        out = new PrintWriter("walk.out");

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        a = new int[m];
        b = new int[m];
        l = new int[m];
        for(int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            a[i] = Integer.parseInt(st.nextToken()) - 1;
            b[i] = Integer.parseInt(st.nextToken()) - 1;
            l[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;

        mask = new boolean[n];

        go(0, 0);
        
        out.println(ans);

        out.close();
    }

    void go(int i, int ct) {
        if(i == 0 && mask[i]) {
            if(ct >= t && ct <= T) {
                ++ans;
            }
            return;
        }
        if(mask[i]) {
            return;
        }
        mask[i] = true;
        for(int k = 0; k < m; ++k) {
            if(a[k] == i) {
                go(b[k], ct + l[k]);
            }
            if(b[k] == i) {
                go(a[k], ct + l[k]);
            }
        }
       mask[i] = false;
    }

    int ans;

    boolean[] mask;

    int a[], b[], l[];
    int n, m, t, T;

    BufferedReader in;
    PrintWriter out;
}
