import java.io.*;
import java.util.*;

public class A {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int k = readInt() + 1;
        int[][] a = new int[n / k][k];
        int[] p = new int[n];
        int[] c = new int[n];
        int l = 0;
        int t = 0;
        for (int i = 0; i < n; ++i) {
            char s = readChar();
            c[l] = l > 0 ? c[l - 1] : 0;
            if (s == 'w') ++c[l];
            p[l++] = i;
            if (l >= k) {
                int w = c[l - 1];
                if (l > k) w -= c[l - k - 1];
                if (w == 1) {
                    for (int j = 0; j < k; ++j) {
                        a[t][j] = p[--l] + 1;
                    }
                    ++t;
                }
            }
        }
        for (t = n / k - 1; t >= 0; --t) {
            for (int j = k - 1; j >= 0; --j) {
                out.print(a[t][j] + " ");
            }
            out.println();
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
        new A().solve();
    }
}
