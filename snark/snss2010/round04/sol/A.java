import java.io.*;
import java.util.*;

public class A {

    int f(int n) {
        int r = 0;
        while (n > 0) {
            int d = n % 10;
            r += d * d;
            n /= 10;
        }
        return r;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        boolean[] mask = new boolean[1000];
        int x = n;
        while (true) {
            x = f(x);
            if (x == 1) {
                println(n + ":1");
                exit();
            }
            if (mask[x]) {
                println(n + ":LOOP");
                exit();
            }
            mask[x] = true;
        }
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
        new A().solve();
    }
}
