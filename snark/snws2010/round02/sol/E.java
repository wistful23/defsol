import java.io.*;
import java.util.*;

public class E {

    int n;
    double[][] d;

    int[] a;
    boolean[] mask;

    double ans = 1e23;

    void go(int i) {
        if (i == n) {
            double l = d[a[0]][a[n - 1]];
            for (int j = 1; j < n; ++j) {
                l += d[a[j]][a[j - 1]];
            }
            if (l < ans) ans = l;
        } else {
            for (int j = 0; j < n; ++j) {
                if (!mask[j]) {
                    mask[j] = true;
                    a[i] = j;
                    go(i + 1);
                    mask[j] = false;
                }
            }
        }
    }

    void solve() throws IOException {               
        in("earth.in"); out("earth.out");

        n = readInt();
        d = new double[n][n];
        double[] t = new double[n];
        double[] p = new double[n];
        for (int i = 0; i < n; ++i) {
            t[i] = Math.PI * readInt() / 180;
            p[i] = Math.PI * readInt() / 180;
            for (int j = 0; j < i; ++j) {
                d[i][j] = d[j][i] =
                    Math.acos(Math.sin(t[i]) * Math.sin(t[j]) +
                              Math.cos(t[i]) * Math.cos(t[j]) * Math.cos(p[i] - p[j]));
            }
        }

        a = new int[n];
        mask = new boolean[n];
        go(0);

        println("%.3f", ans * 6400);

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
            if (!in.ready()) return "";
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
        new E().solve();
    }
}
