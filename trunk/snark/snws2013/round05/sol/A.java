import java.io.*;
import java.util.*;

public class A {

    int n, k;
    int[] a, b;
    int[] p;

    int ans;

    void go(int i) {
        if (i == n) {
            boolean flag = true;
            for (int j = 0; j < k && flag; ++j) {
                flag = p[a[j]] < p[b[j]];
            }
            if (flag) ++ans;
        } else {
            for (int v = 0; v < n; ++v) {
                if (p[v] == 0) {
                    p[v] = i + 1;
                    go(i + 1);
                    p[v] = 0;
                }
            }
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        k = readInt();
        a = new int[k];
        b = new int[k];
        for (int i = 0; i < k; ++i) {
            a[i] = readInt() - 1;
            b[i] = readInt() - 1;
        }

        p = new int[n];
        go(0);

        println(ans);

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
