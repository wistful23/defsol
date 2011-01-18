import java.io.*;
import java.util.*;

public class D {

    void solve() throws IOException {
        in("__std"); out("__std");

        int c = readInt();
        int p = readInt();
        int n = c + p + 2;

        boolean[] mask = new boolean[c];
        int[][] g = new int[n][n];
        for (int j = 0; j < p; ++j) {
            int k = readInt();
            while (k-- > 0) {
                int i = readInt();
                g[i][c + j] = 1;
                mask[i] = true;
            }
        }

        int s = n - 2;
        int t = n - 1;
        for (int i = 0; i < c; ++i) {
            g[s][i] = 1;

            if (!mask[i]) {
                println(-1);
                exit();
            }
        }

        int[][] f = new int[n][n];
        int[] v = new int[n];
        int[] l = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();

        for (int m = 1; m <= c; ++m) {

            for (int j = 0; j < p; ++j) {
                g[c + j][t] = m;
            }
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], 0);
            }
            int r = 0;

            while (true) {
                Arrays.fill(v, 0);
                Arrays.fill(l, -1);
                v[s] = Integer.MAX_VALUE;
                q.add(s);
                while (!q.isEmpty()) {
                    int i = q.poll();
                    for (int j = 0; j < n; ++j) {
                        int cv = Math.min(v[i], Math.max(g[i][j] - f[i][j], f[j][i]));
                        if (cv > v[j]) {
                            v[j] = cv;
                            l[j] = i;
                            q.add(j);
                        }
                    }
                }

                if (v[t] == 0) break;
                r += v[t];

                if (r == c) {
                    println(m);
                    exit();
                }

                int j = t;
                while (l[j] != -1) {
                    int i = l[j];
                    if (g[i][j] > 0) {
                        f[i][j] += v[t];
                    } else {
                        f[j][i] -= v[t];
                    }
                    j = i;
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

    double readDouble() throws IOException {
        return Double.parseDouble(readToken());
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

    boolean eof() throws IOException {
        return !in.ready();
    }

    void print(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void print(Object value) {
        out.print(value);
    }

    void println(Object value) {
        out.println(value);
    }

    void println() {
        out.println();
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new D().solve();
    }
}
