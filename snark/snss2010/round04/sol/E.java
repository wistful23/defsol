import java.io.*;
import java.util.*;

public class E {

    void solve() throws IOException {
        in("__std"); out("__std");

        char[] a = readLine().toCharArray();
        char[] b = readLine().toCharArray();
        char[] t = new char['Z' + 1];
        for (int i = 0; i < a.length; ++i) {
            t[a[i]] = b[i];
        }
        int cnt = 0;
        while (cnt != -1 && !String.valueOf(a).equals(String.valueOf(b))) {
            ++cnt;
            for (int i = 0; i < b.length; ++i) {
                b[i] = t[b[i]];
                if (b[i] == 0) {
                    cnt = -1;
                    break;
                }
            }
        }
        println(cnt);

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
        new E().solve();
    }
}
