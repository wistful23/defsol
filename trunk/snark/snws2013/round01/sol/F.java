import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int k = readInt();
        int[][] c = new int[2][k + 1];
        Arrays.fill(c[0], Integer.MAX_VALUE);
        Arrays.fill(c[1], Integer.MAX_VALUE);
        c[0][k] = 0;
        int p = 0;
        for (int i = 0; i < n; ++i) {
            int a = readInt();
            int b = readInt();
            for (int j = 0; j <= k; ++j) {
                if (c[p][j] < Integer.MAX_VALUE) {
                    c[1 - p][j] = c[p][j] + a;
                    if (j >= b) {
                        if (c[1 - p][j - b] > c[p][j]) {
                            c[1 - p][j - b] = c[p][j];
                        }
                    } else {
                        int v = Math.min(a, b - j);
                        if (c[1 - p][0] > c[p][j] + v) {
                            c[1 - p][0] = c[p][j] + v;
                        }
                    }
                }
            }
            Arrays.fill(c[p], Integer.MAX_VALUE);
            p = 1 - p;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= k; ++j) {
            if (c[p][j] < min) min = c[p][j];
        }
        println(min);

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
        new F().solve();
    }
}
