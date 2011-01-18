import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int p = readInt();

        double[][] f = new double[n][p + 1];

        double[] d = new double[p + 1];
        int[][] c = new int[p + 1][n];
        d[0] = 1.0;

        for (int i = 0; i < n; ++i) {
            double q = readDouble();
            double r = Math.exp(-q);
            f[i][0] = r;
            for (int k = 1; k <= p; ++k) {
                r *= q / k;
                f[i][k] = f[i][k - 1] + r;
            }
            d[0] *= f[i][0];
            c[0][i] = 1;
        }

        int a[] = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt();
        }

        double max = 0;
        for (int v = 0; v <= p; ++v) {
            if (c[v][0] > 0) {
                for (int i = 0; i < n; ++i) {
                    int u = v + a[i];
                    if (u <= p) {
                        double r = 1.0;
                        for (int j = 0; j < n; ++j) {
                            r *= i == j ? f[j][c[v][j]] : f[j][c[v][j] - 1];
                        }
                        if (r > d[u]) {
                            d[u] = r;
                            for (int j = 0; j < n; ++j) {
                                c[u][j] = i == j ? c[v][j] + 1 : c[v][j];
                            }
                        }
                    }
                }
            }
            if (d[v] > max) max = d[v];
        }

        println("%.5f", max);

        exit();
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
        new C().solve();
    }
}
