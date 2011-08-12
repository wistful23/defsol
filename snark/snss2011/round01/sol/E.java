import java.io.*;
import java.util.*;

public class E {

    int n;

    void solve() throws IOException {
        in("oil.in"); out("oil.out");

        String s = readLine();
        n = readInt();
        Tree t = build(s);
        solve(t);
        println(t.d[n]);

        exit();
    }

    Tree build(String s) {
        if (s.charAt(0) == '(') {
            int k = 1;
            int c = 0;
            while (c > 0 || s.charAt(k) != ' ') {
                if (s.charAt(k) == '(') ++c;
                if (s.charAt(k) == ')') --c;
                ++k;
            }
            return new Tree(build(s.substring(1, k)), build(s.substring(k + 1, s.length() - 1)));
        } else {
            return new Tree(Integer.valueOf(s));
        }
    }

    void solve(Tree t) {
        if (t.v != 0) {
            for (int v = 0; v <= n; ++v) {
                t.d[v] = t.v + v;
            }
        } else {
            solve(t.l);
            solve(t.r);
            int[] ld = calc(t.l);
            int[] rd = calc(t.r);
            for (int l = 0; l <= n; ++l) {
                for (int r = 0; l + r <= n; ++r) {
                    int c = ld[l] + rd[r];
                    if (c > t.d[l + r]) {
                        t.d[l + r] = c;
                    }
                }
            }
        }
    }

    int[] calc(Tree t) {
        int[] m = new int[n + 1];
        for (int p = 0; p <= n; ++p) {
            for (int v = 0; v + p <= n; ++v) {
                int c = Math.min((1 + p) * (1 + p), t.d[v]);
                if (c > m[v + p]) {
                    m[v + p] = c;
                }
            }
        }
        return m;
    }

    class Tree {
        Tree l, r;
        int v;
        int[] d = new int[n];

        Tree(Tree l, Tree r) {
            this.l = l;
            this.r = r;
        }

        Tree(int v) {
            this.v = v;
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

    String readLine() throws IOException {
        st = null;
        return in.readLine();
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
        new E().solve();
    }
}
