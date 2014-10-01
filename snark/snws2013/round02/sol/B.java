import java.io.*;
import java.util.*;

public class B {

    final static long M = 1000000007;

    void solve() throws IOException {
        in("__std"); out("__std");

        int x1 = readInt();
        int y1 = readInt();
        int z1 = readInt();
        int x2 = readInt();
        int y2 = readInt();
        int z2 = readInt();
        int xx = Math.abs(x1 - x2) + 1;
        int yy = Math.abs(y1 - y2) + 1;
        int zz = Math.abs(z1 - z2) + 1;
        int a = xx + yy;
        int b = Math.max(yy + 1, zz + 1);
        long[][] d = new long[a][b];
        d[0][1] = 1;
        for (int i = 1; i < a; ++i) {
            for (int j = 1; j < b; ++j) {
                d[i][j] = (d[i - 1][j] + d[i][j - 1]) % M;
            }
        }
        println(d[xx][yy] * d[xx + yy - 1][zz] % M);

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
        new B().solve();
    }
}
