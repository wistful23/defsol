import java.io.*;
import java.util.*;

public class E {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        while (n > 0) {
            int m = readInt();
            int[] s = new int[n + 1];
            s[0] = -1;
            for (int i = 1; i <= n; ++i) {
                s[i] = readInt();
            }
            Arrays.sort(s);
            double[] log = new double[n + 1];
            for (int l = 1; l <= n; ++l) {
                double p = 1.0 * l / n;
                log[l] = p * Math.log(p) / Math.log(2);
            }
            double[][] e = new double[n + 1][m + 2];
            for (int i = 0; i <= n; ++i) {
                Arrays.fill(e[i], -1);
            }
            e[0][0] = 0;
            double best = 0;
            for (int i = 1; i <= n; ++i) {
                if (i == n || s[i + 1] != s[i]) {
                    for (int k = 1; k <= m + 1; ++k) {
                        double r = 0;
                        for (int j = 0; j < i; ++j) {
                            if (s[j + 1] != s[j] && e[j][k - 1] != -1) {
                                double v = e[j][k - 1] - log[i - j];
                                if (v > r) r = v;
                            }
                        }
                        e[i][k] = r;
                        if (i == n && r > best) best = r;
                    }
                }
            }
            println(best);

            n = readInt();
        }

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

    char readChar() throws IOException {
        return (char) in.read();
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
        out.print(new Formatter(Locale.US).format(format, args));
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
        new E().solve();
    }
}
