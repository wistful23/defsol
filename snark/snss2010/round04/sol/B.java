import java.io.*;
import java.util.*;

public class B {

    Map<String, Integer> d = new HashMap<String, Integer>();
    Queue<String> q = new LinkedList<String>();

    void swap(char[] p, int i, int j) {
        char t = p[i];
        p[i] = p[j];
        p[j] = t;
    }

    void check(char[] p, int i, int j, int v) {
        swap(p, i, j);
        String s = String.valueOf(p);
        if (!d.containsKey(s) || d.get(s) > v) {
            d.put(s, v);
            q.add(s);
        }
        swap(p, i, j);
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        String s = "";
        for (int i = 0; i < 3; ++i) {
            s += readLine();
        }

        d.put(s, 0);
        q.add(s);
        while (!q.isEmpty()) {
            s = q.poll();
            char[] p = s.toCharArray();
            int v = d.get(s) + 1;
            int i = 0;
            while (p[i] != '#') ++i;

            if (i % 3 != 0) {
                check(p, i - 1, i, v);
            }
            if (i % 3 != 2) {
                check(p, i + 1, i, v);
            }
            if (i > 2) {
                check(p, i - 3, i, v);
            }
            if (i < 6) {
                check(p, i + 3, i, v);
            }
        }

        s = "12345678#";
        if (d.containsKey(s)) {
            println(d.get(s));
        } else {
            println("impossible");
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
