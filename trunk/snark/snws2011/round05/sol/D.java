import java.io.*;
import java.util.*;

public class D {

    void solve() throws IOException {
        in("__std"); out("__std");

        char[] l = readLine().toCharArray();
        int[] c = new int['Z' - 'A' + 1];
        for (int i = 0; i < l.length; ++i) {
            ++c[l[i] - 'A'];
        }
        int n = readInt();
        while (n-- > 0) {
            char[] p = readLine().toCharArray();
            int[] cc = Arrays.copyOf(c, c.length);
            boolean flag = true;
            for (int i = 0; i < p.length && flag; ++i) {
                flag = cc[p[i] - 'A']-- > 0;
            }
            println(flag ? "YES" : "NO");
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
        new D().solve();
    }
}
