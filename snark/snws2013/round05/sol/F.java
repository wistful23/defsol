import java.io.*;
import java.util.*;

public class F {

    char[] s;
    int p;
    boolean flag;

    int walk() {
        ++p;
        if (s[p] == '>') {
            ++p;
            return 0;
        } else {
            int l = walk();
            ++p;
            while (s[p] != ',') ++p;
            ++p;
            int r = walk();
            ++p;
            if (Math.abs(l - r) > 1) flag = false;
            return Math.max(l, r) + 1;
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int t = readInt();
        while (t-- > 0) {
            s = readLine().toCharArray();
            flag = true;
            boolean first = true;
            long prev = 0;
            int i = 0;
            while (i < s.length && flag) {
                if (s[i] == '-' || (s[i] >= '0' && s[i] <= '9')) {
                    long cur = 0;
                    int k = 1;
                    if (s[i] == '-') {
                        k = -1;
                        ++i;
                    }
                    while (s[i] >= '0' && s[i] <= '9') {
                        cur = cur * 10 + s[i] - '0';
                        ++i;
                    }
                    cur = cur * k;
                    if (!first) {
                        if (cur <= prev) flag = false;
                    } else {
                        first = false;
                    }
                    prev = cur;
                }
                ++i;
            }
            if (flag) {
                p = 0;
                walk();
            }
            println(flag ? "Yes" : "No");
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
        new F().solve();
    }
}
