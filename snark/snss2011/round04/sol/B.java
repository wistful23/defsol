import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        int m = readInt();
        Area[] areas = new Area[m];
        for (int i = 0; i < m; ++i) {
            Area a = new Area(readInt());
            for (int j = 0; j < a.n; ++j) {
                a.v[j] = readInt();
            }
            a.v[a.n] = a.v[0];
            for (int j = 0; j < a.n; ++j) {
                a.c[j] = readInt();
            }
            areas[i] = a;
        }
        int c[][] = new int[m + 1][m + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i != j) {
                    c[i][j] = areas[i].cross(areas[j]);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            c[i][m] = c[m][i] = areas[i].outer();
        }
        println(Math.min(mst(c, m), mst(c, m + 1)));

        exit();
    }

    int mst(int[][] c, int m) {
        int r = 0;
        boolean[] mask = new boolean[m];
        mask[0] = true;
        for (int k = 0; k < m - 1; ++k) {
            int best = Integer.MAX_VALUE;
            int jj = -1;
            for (int i = 0; i < m; ++i) {
                if (mask[i]) {
                    for (int j = 0; j < m; ++j) {
                        if (!mask[j] && c[i][j] < best) {
                            best = c[i][j];
                            jj = j;
                        }
                    }
                }
            }
            if (jj == -1) {
                return Integer.MAX_VALUE;
            }
            mask[jj] = true;
            r += best;
        }
        return r;
    }

    class Area {
        int n;
        int[] v;
        int[] c;
        boolean[] mask;

        Area(int n) {
            this.n = n;
            v = new int[n + 1];
            c = new int[n];
            mask = new boolean[n];
        }

        int cross(Area a) {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < a.n; ++j) {
                    if ((v[i] == a.v[j] && v[i + 1] == a.v[j + 1]) ||
                        (v[i] == a.v[j + 1] && v[i + 1] == a.v[j])) {
                        mask[i] = true;
                        if (c[i] < best) {
                            best = c[i];
                        }
                    }
                }
            }
            return best;
        }

        int outer() {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if (!mask[i] && c[i] < best) {
                    best = c[i];
                }
            }
            return best;
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

    long readLong() throws IOException {
        return Long.parseLong(readToken());
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
        out.println(new Formatter(Locale.US).format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter(Locale.US).format(format, args));
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
        new B().solve();
    }
}
