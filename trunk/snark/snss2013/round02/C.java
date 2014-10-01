import java.io.*;
import java.util.*;

public class C {

    int n;
    double[][] g;
    boolean[] mask;
    int[] p;

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        double t = readDouble();
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; ++i) {
            x[i] = readDouble();
            y[i] = readDouble();
        }
        g = new double[n][n];
        for (int j = 0; j < n; ++j) {
            double x1 = readDouble();
            double y1 = readDouble();
            for (int i = 0; i < n; ++i) {
                g[i][j] = 2.0 * Math.hypot(x[i] - x1, y[i] - y1) +
                        Math.min(Math.min(x[i], 1.0 - x[i]), Math.min(y[i], 1.0 - y[i])) +
                        Math.min(Math.min(x1, 1.0 - x1), Math.min(y1, 1.0 - y1));
            }
        }

        mask = new boolean[n];
        p = new int[n];
        double l = 0;
        double r = 2.0;
        while (Math.abs(l - r) > 1e-8) {
            double m = 0.5 * (l + r);
            Arrays.fill(p, -1);
            boolean flag = true;
            for (int i = 0; i < n && flag; ++i) {
                Arrays.fill(mask, false);
                flag = search(i, m);
            }
            if (flag) {
                r = m;
            } else {
                l = m;
            }
       }

        println(l / t);

        exit();
    }

    boolean search(int i, double m) {
        if (mask[i]) {
            return false;
        }
        mask[i] = true;
        for (int j = 0; j < n; ++j) {
            if (g[i][j] < m && (p[j] == -1 || search(p[j], m))) {
                p[j] = i;
                return true;
            }
        }
        return false;
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
        new C().solve();
    }
}
