import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        String s = n > 0 ? readToken() : "";
        int[] p = new int[10];
        for (int i = 0; i < 10; ++i) {
            p[i] = i + 1;
        }
        for (int k = 0; k < n; ++k) {
            int r = s.charAt(k) == 'W' ? 1 : 0;
            int t = p[r];
            for (int i = r; i < 9; ++i) {
                p[i] = p[i + 1];
            }
            p[9] = t;
        }
        for (int i = 0; i < 10; ++i) {
            print(p[i] + " ");
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
        new F().solve();
    }
}
