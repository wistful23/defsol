import java.io.*;
import java.util.*;

public class A {

    void solve() throws IOException {
        in("__std"); out("__std");

        String a = readLine();
        String b = readLine();
        println(conv(a).trim().equals(conv(b).trim()) ? "YES" : "NO");

        exit();
    }

    String conv(String s) {
        int l = 0;
        char[] c = s.toCharArray();
        char[] r = new char[s.length()];
        for (int i = 0; i < c.length; ++i) {
            if (c[i] >= 'A' && c[i] <= 'Z') c[i] = (char) (c[i] - 'A' + 'a');
            if (".,:;!?".contains("" + c[i])) c[i] = ' ';
            if (i == 0 || c[i] != ' ' || c[i - 1] != ' ') r[l++] = c[i];
        }
        return String.valueOf(r, 0, l);
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
        new A().solve();
    }
}
