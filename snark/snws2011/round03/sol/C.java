import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int m = readInt();
        double[][] p = new double[n][m];
        boolean[][] mask = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                p[i][j] = readDouble();
            }
        }
        double r = 0;
        for (int k = 0; k < n; ++k) {
            double v = 1.0;
            for (int j = 0; j < m; ++j) {
                int t = -1;
                for (int i = 0; i < n; ++i) {
                    if (!mask[i][j]) {
                        if (t == -1 || p[i][j] > p[t][j]) {
                            t = i;
                        }
                    }
                }
                v *= p[t][j];
                mask[t][j] = true;
            }
            r += v;
        }

        println("%.5f", r);

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
