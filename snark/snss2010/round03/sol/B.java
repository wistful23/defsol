import java.io.*;
import java.util.*;

public class B {

    class Tree {
        Tree[] c = new Tree['z' - 'a' + 1];
        int cnt;
    }

    void add(Tree t, char[] s, int i) {
        ++t.cnt;
        if (i < s.length) {
            int p = s[i] - 'a';
            if (t.c[p] == null) {
                t.c[p] = new Tree();
            }
            add(t.c[p], s, i + 1);
        }
    }

    int find(Tree t, char[] s, int i) {
        if (i < s.length) {
            int p = s[i] - 'a';
            return t.c[p] != null ? find(t.c[p], s, i + 1) : 0;
        } else {
            return t.cnt;
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int m = readInt();

        Tree t = new Tree();
        while (n-- > 0) {
            add(t, readLine().toCharArray(), 0);
        }

        while (m-- > 0) {
            println(find(t, readLine().toCharArray(), 0));
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
