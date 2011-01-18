import java.io.*;
import java.util.*;

public class C {

    final static int MAX_TIME = 10100;

    class Point {
        int b, r;

        Point(int b, int r) {
            this.b = b;
            this.r = r;
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int[] v = new int[MAX_TIME + 1];
        List<Point>[] s = new List[MAX_TIME + 1];
        int n = readInt();
        while (n-- > 0) {
            int b = readInt();
            int l = readInt();
            int e = b + l;

            if (s[e] == null) {
                s[e] = new ArrayList<Point>();
            }
            s[e].add(new Point(b, readInt()));
        }

        for (int e = 1; e <= MAX_TIME; ++e) {
            v[e] = v[e - 1];
            if (s[e] != null) {
                for (Point p : s[e]) {
                     if (v[p.b] + p.r > v[e]) {
                         v[e] = v[p.b] + p.r;
                     }
                }
            }
        }

        println(v[MAX_TIME]);

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
        new C().solve();
    }
}
