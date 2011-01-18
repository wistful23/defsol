import java.io.*;
import java.util.*;

public class D {

    final static int MAX_LEN = 123;
    final static int MAX_STEP = 50000;

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        long p = readInt();
        long pp = p;

        int[][] c = new int[n][n];
        int[] r = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                c[i][j] = readInt();
            }
            r[i] = readInt();
        }

        long[][] v = new long[2][n];
        int k = 0;
        v[k][0] = 1;
        long[] w = new long[MAX_LEN + 1];
        long d = 0;
        while (p > 0 && d < MAX_STEP) {
            Arrays.fill(v[1 - k], 0);
            long t = 0;
            for (int i = 0; i < n; ++i) {
                t += v[k][i] * r[i];
                for (int j = 0; j < n; ++j) {
                    v[1 - k][j] += v[k][i] * c[i][j];
                }
            }
            p -= t;
            k = 1 - k;
            if (d <= MAX_LEN) {
                w[(int) d] = t;
            }
            ++d;
        }

        if (d == MAX_STEP) {
            d = -1;
            boolean flag = false;
            for (int l = 1; l <= MAX_LEN / 2 && !flag; ++l) {
                for (int s = 0; s <= MAX_LEN / 2 && !flag; ++s) {
                    flag = false;
                    for (int s2 = s + l; s2 <= MAX_LEN - l + 1; s2 += l) {
                        flag = true;
                        for (int i = 0; i < l && flag; ++i) {
                            flag = w[s + i] == w[s2 + i];
                        }
                        if (!flag) break;
                    }
                    if (flag) {
                        int b = 0;
                        for (int i = 0; i < l; ++i) {
                            b += w[s + i];
                        }
                        if (b > 0) {
                            int a = 0;
                            for (int i = 0; i < s; ++i) {
                                a += w[i];
                            }
                            d = s;
                            pp -= a;
                            d += (pp / b) * l;
                            pp = pp % b;
                            for (int i = 0; pp > 0; ++i) {
                                pp -= w[s + i];
                                ++d;
                            }
                        }
                    }
                }
            }
        }

        println(d);

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
        new D().solve();
    }
}
