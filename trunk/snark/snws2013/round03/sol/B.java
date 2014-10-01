import java.io.*;
import java.util.*;

public class B {

    final static double EPS = 1e-8;

    void solve() throws IOException {
        in("__std"); out("__std");

        int t = readInt();
        while (t-- > 0) {
            int n = readInt();
            int a = readInt() - 1;
            int b = readInt() - 1;
            int[][] x = new int[n][];
            int[][] y = new int[n][];
            for (int i = 0; i < n; ++i) {
                int k = readInt();
                x[i] = new int[k];
                y[i] = new int[k];
                for (int j = 0; j < k; ++j) {
                    x[i][j] = readInt();
                    y[i][j] = readInt();
                }
            }
            double[][] d = new double[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    d[i][j] = d[j][i] = dist(x[i], y[i], x[j], y[j]);
                }
            }
            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (d[i][k] + d[k][j] < d[i][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }
            println(d[a][b]);
        }

        exit();
    }

    double dist(int[] x1, int[] y1, int[] x2, int[] y2) {
        double d = 1e23;
        for (int i = 0; i < x1.length; ++i) {
            for (int j = 0; j < x2.length; ++j) {
                d = Math.min(d, dist(x1[i], y1[i], x2[j], y2[j]));
                int k = j + 1 < x2.length ? j + 1 : 0;
                d = Math.min(d, dist(x1[i], y1[i], x2[j], y2[j], x2[k], y2[k]));
                k = i + 1 < x1.length ? i + 1 : 0;
                d = Math.min(d, dist(x2[j], y2[j], x1[i], y1[i], x1[k], y1[k]));
            }
        }
        return d;
    }

    double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    double dist(int x, int y, int x1, int y1, int x2, int y2) {
        double a = y2 - y1;
        double b = -(x2 - x1);
        double l = Math.sqrt(a * a + b * b);
        a /= l;
        b /= l;
        double c = a * x1 + b * y1;
        double d = a * x + b * y - c;
        double xc = -a * d + x;
        double yc = -b * d + y;
        if (xc > Math.min(x1, x2) - EPS && xc < Math.max(x1, x2) + EPS &&
            yc > Math.min(y1, y2) - EPS && yc < Math.max(y1, y2) + EPS) {
            return Math.abs(d);
        }
        return 1e23;
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
        new B().solve();
    }
}
