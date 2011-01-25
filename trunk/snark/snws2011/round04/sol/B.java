import java.io.*;
import java.util.*;

public class B {

    int n;
    Box[] m;
    boolean[] mask;
    int[] p;

    boolean can(int i) {
        if (mask[i]) return false;
        mask[i] = true;
        for (int j = 0; j < n; ++j) {
            if (m[i].contains(m[j]) && (p[j] == -1 || can(p[j]))) {
                p[j] = i;
                return true;
            }
        }
        return false;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        m = new Box[n];
        for (int i = 0; i < n; ++i) {
            m[i] = new Box(readInt(), readInt(), readInt());
        }

        p = new int[n];
        Arrays.fill(p, -1);
        mask = new boolean[n];

        int k = 0;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(mask, false);
            if (can(i)) {
                ++k;
            }
        }

        println(n - k);

        exit();
    }

    static class Box {

        int a, b, c;

        Box(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        boolean contains(Box o) {
            return a > o.a && b > o.b && c > o.c;
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
        new B().solve();
    }
}
