import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("__std"); out("__std");

        String s = readLine();
        int i = 0;
        while (i < s.length() && s.charAt(i) != '.') ++i;
        if (i < s.length()) {
            long a = Integer.valueOf(s.substring(0, i));
            int j = i + 1;
            long pb = 1;
            while (j < s.length() && s.charAt(j) != '(') {
                ++j;
                pb *= 10;
            }
            long b = pb > 1 ? Integer.valueOf(s.substring(i + 1, j)) : 0;
            int k = j + 1;
            long pc = 1;
            while (k < s.length() && s.charAt(k) != ')') {
                ++k;
                pc *= 10;
            }
            long c = pc > 1 ? Integer.valueOf(s.substring(j + 1, k)) : 0;
            a *= pb;
            a += b;
            if (c != 0) {
                a *= pc - 1;
                a += c;
                pb *= pc - 1;
            }
            long d = gcd(a, pb);
            a /= d;
            pb /= d;
            println(a + " / " + pb);
        } else {
            println(s + " / 1");
        }

        exit();
    }

    long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
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
        out.println(new Formatter(Locale.US).format(format, args));
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
        new C().solve();
    }
}
