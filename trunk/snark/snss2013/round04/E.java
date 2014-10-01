import java.io.*;
import java.util.*;

public class E {

    void solve() throws IOException {
        in("__std"); out("__std");

        int[] p = new int[65536];
        Arrays.fill(p, -1);
        int[] n = new int[1000023];
        int l = 0;
        int s = 0;
        int c = 0;
        int i = 0;
        n[i] = readInt();
        while (n[i] > 0) {
            if (p[n[i]] != -1) {
                if (i - c > l) {
                    l = i - c;
                    s = c;
                }
                if (p[n[i]] + 1 > c) c = p[n[i]] + 1;
            }
            p[n[i]] = i;
            n[++i] = readInt();
        }
        if (l == 0) {
            l = i;
            s = 0;
        }
        for (i = 0; i < l; ++i) {
            println(n[s + i]);
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
        new E().solve();
    }
}
