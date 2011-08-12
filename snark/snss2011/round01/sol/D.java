import java.io.*;
import java.util.*;

public class D {

    boolean[] p;

    int n, ans;
    int[] v;
    boolean[] mask;
    int[] m;

    void solve() throws IOException {
        in("numcir.in"); out("numcir.out");

        p = new boolean[1024];
        p[0] = p[1] = true;
        for (int i = 2; i < p.length; ++i) {
            if (!p[i]) {
                int j = 2 * i;
                while (j < p.length) {
                    p[j] = true;
                    j += i;
                }
            }
        }

        int t = readInt();
        while (t-- > 0) {
            n = readInt();
            v = new int[n];
            for (int i = 0; i < n; ++i) {
                v[i] = readInt();
            }
            Arrays.sort(v, n, 0);
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (v[i] < v[j]) {
                        int x = v[i]; v[i] = v[j]; v[j] = x;
                    }
                }
            }
            m = new int[n];
            mask = new boolean[n];
            ans = Integer.MAX_VALUE;
            go(0, 0);
            println(ans < Integer.MAX_VALUE ? ans : "impossible");
        }

        exit();
    }

    void go(int i, int a) {
        int b = a;
        int k = i;
        for (int j = 0; j < n; ++j) {
            if (!mask[j]) {
                b += v[j] * ++k;
            }
        }
        if (b >= ans) {
            return;
        }
        if (i == n) {
            if (!p[v[m[0]] + v[m[n - 1]] + v[m[n - 2]]] && !p[v[m[0]] + v[m[1]] + v[m[n - 1]]]) {
                if (a < ans) ans = a;
            }
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (!mask[j]) {
                if (i < 2 || !p[v[m[i - 2]] + v[m[i - 1]] + v[j]]) {
                    m[i] = j;
                    mask[j] = true;
                    go(i + 1, a + v[j] * (i + 1));
                    mask[j] = false;
                }
            }
        }
    }

    void in(String name) throws IOException {
        if (name.equals("__std")) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(name));
        }
    }

    void out(String name) throws IOException {
        if (name.equals("__std")) {
            out = new PrintWriter(System.out);
        } else {
            out = new PrintWriter(name);
        }
    }

    void exit() {
        out.close();
        System.exit(0);
    }

    int readInt() throws IOException {
        return Integer.parseInt(readToken());
    }

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    void println(Object value) {
        out.println(value);
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new D().solve();
    }
}
