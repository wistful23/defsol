import java.io.*;
import java.util.*;

public class E {

    final static int x = 0;
    final static int y = 1;
    final static int z = 2;

    final static int f = 0;
    final static int l = 1;
    final static int u = 2;

    void solve() throws IOException {
        in("__std"); out("__std");

        int[] a = new int[3];
        for (int i = 0; i < 3; ++i) a[i] = readInt();
        for (int i = 0; i < 3; ++i) a[i] -= readInt();
        int[] b = new int[3];

        int[][] s = new int[3][3];
        s[f][x] = 1;
        s[l][y] = 1;
        s[u][z] = 1;

        int[] v = new int[3];
        int[] w = new int[3];

        double best = 1e23;

        int d, r;
        do {
            d = readInt();
            r = readInt();

            for (int i = 0; i < 3; ++i) {
                v[i] = d * s[f][i];
                b[i] = a[i] + v[i];
                w[i] = -a[i];
            }
            double len = 0;
            int c1 = scalar(v, w);
            int c2 = scalar(v, v);
            if (c1 <= 0) {
                len = dist(a);
            } else if (c2 <= c1) {
                len = dist(b);
            } else {
                for (int i = 0; i < 3; ++i) {
                    double t = 1.0 * c1 / c2 * v[i] + a[i];
                    len += t * t;
                }
                len = Math.sqrt(len);
            }
            if (len < best) best = len;

            a = Arrays.copyOf(b, 3);

            switch (r) {
                case 0:
                    s[f] = rotateRight(s[f], s[u]);
                    s[l] = rotateRight(s[l], s[u]);
                    break;
                case 90:
                    s[f] = rotateRight(s[f], s[l]);
                    s[u] = rotateRight(s[u], s[l]);
                    break;
                case 180:
                    s[f] = rotateLeft(s[f], s[u]);
                    s[l] = rotateLeft(s[l], s[u]);
                    break;
                case 270:
                    s[f] = rotateLeft(s[f], s[l]);
                    s[u] = rotateLeft(s[u], s[l]);
            }
        } while (r != -1);

        println("%.5f", best);

        exit();
    }

    int[] rotateLeft(int[] a, int[] v) {
        int[] r = new int[3];
        r[x] = v[x] * v[x] * a[x] + (v[x] * v[y] - v[z]) * a[y] + (v[x] * v[z] + v[y]) * a[z];
        r[y] = (v[y] * v[x] + v[z]) * a[x] + v[y] * v[y] * a[y] + (v[y] * v[z] - v[x]) * a[z];
        r[z] = (v[z] * v[x] - v[y]) * a[x] + (v[z] * v[y] + v[x]) * a[y] + v[z] * v[z] * a[z];
        return r;
    }

    int[] rotateRight(int[] a, int[] v) {
        int[] r = Arrays.copyOf(a, 3);
        for (int i = 0; i < 3; ++i) {
            r = rotateLeft(r, v);
        }
        return r;
    }

    int scalar(int[] a, int[] b) {
        int r = 0;
        for (int i = 0; i < 3; ++i) {
            r += a[i] * b[i];
        }
        return r;
    }

    double dist(int[] v) {
        int r = 0;
        for (int i = 0; i < 3; ++i) {
            r += v[i] * v[i];
        }
        return Math.sqrt(r);
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
        new E().solve();
    }
}
