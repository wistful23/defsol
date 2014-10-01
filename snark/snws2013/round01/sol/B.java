import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        int t = readInt();
        while (t-- > 0) {
            int n = readInt();
            int w = readInt();
            int h = readInt();
            int s = n * w * h;

            int r = Integer.MAX_VALUE;

            for (int i = 1; i <= n; ++i) {
                int a = w * i;
                if (s % a == 0) {
                    int b = s / a;
                    if (b % h == 0) {
                        if (2 * (a + b) < r) {
                            r = 2 * (a + b);
                        }
                    }
                }
            }

            for (int i = 1; i < n; ++i) {
                for (int j = 1; j <= n - i; ++j) {
                    int a = w * i + h * j;
                    if (s % a == 0) {
                        int b = s / a;
                        if (b % w == 0 && b % h == 0) {
                            if (2 * (a + b) < r) {
                                r = 2 * (a + b);
                            }
                        }
                    }
                }
            }

            println(r);
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
