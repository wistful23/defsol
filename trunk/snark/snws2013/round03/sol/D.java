import java.io.*;
import java.util.*;

public class D {

    boolean kmp(String a, String b) {
        String c = a + "$" + b;
        int[] z = new int[c.length()];
        int l = 0;
        int r = 0;
        for (int i = 1; i < c.length(); ++i) {
            if (i > r) {
                int j = 0;
                while (i + j < c.length() && c.charAt(j) == c.charAt(i + j)) {
                    ++j;
                }
                z[i] = j;
                l = i;
                r = i + j - 1;
            } else {
                if (z[i - l] < r - i + 1) {
                    z[i] = z[i - l];
                } else {
                    int j = 1;
                    while (r + j < c.length() && c.charAt(r + j) == c.charAt(r - i + j)) ++j;
                    z[i] = r + j - i;
                    l = i;
                    r += j - 1;
                }
            }
            if (z[i] == a.length()) {
                return true;
            }
        }
        return false;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int t = readInt();
        while (t-- > 0) {
            String a = in.readLine();
            String b = in.readLine();
            String c = (new StringBuffer(b)).reverse().toString();

            if (a.length() == b.length() && (kmp(b, a + a) || kmp(c, a + a))) {
                println("YES");
            } else {
                println("NO");
            }
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
        new D().solve();
    }
}
