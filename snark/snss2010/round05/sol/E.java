import java.io.*;
import java.util.*;

public class E {

    final static int MAX_VAL = 123;

    void solve() throws IOException {
        in("__std"); out("__std");

        int k = readInt();
        int m = readInt();

        double[][] p = new double[k + 1][MAX_VAL + 1];
        p[0][0] = 1.0;
        double s = 0;
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j <= MAX_VAL; ++j) {
                p[i][j] = 0.7 * p[i - 1][j];
                if (j > 0) {
                    p[i][j] += 0.2 * p[i - 1][j - 1] + 0.1 * p[i][j - 1];
                }
                if (i == k && j >= m) {
                    s += p[i][j];
                }
            }
        }

        println("%.6f", s);

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
        new E().solve();
    }
}
