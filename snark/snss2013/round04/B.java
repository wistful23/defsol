import java.io.*;
import java.util.*;

public class B {

    final static int MOD = 1000000007;

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        if (n < 4) {
            println(0);
        } else {
            int[][] d = new int[n + 1][16];
            d[0][0] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int p = 0; p < 16; ++p) {
                    // 1 - 0
                    if (i > 1 && (p & 2) == 0) d[i][p | 1] = (d[i][p | 1] + d[i - 1][p]) % MOD;
                    // 2 - 3
                    d[i][p | 2] = (d[i][p | 2] + d[i - 1][p]) % MOD;
                    // 4 - 6
                    if ((p & 8) == 0) d[i][p | 4] = (d[i][p | 4] + d[i - 1][p]) % MOD;
                    // 8 - 9
                    d[i][p | 8] = (d[i][p | 8] + d[i - 1][p]) % MOD;
                }
            }
            println(d[n][15]);
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
        new B().solve();
    }
}
