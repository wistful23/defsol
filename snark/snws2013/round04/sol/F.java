import java.io.*;
import java.util.*;

public class F {

    double calc(double l, double x, double y) {
        double s = l / 3;
        if (s < 1e-8) return 0;
        if (x < s) {
            if (y < s) return calc(s, x, y);
            else if (y < 2 * s) return calc(s, x, y - s);
            else return calc(s, x, y - 2 * s);
        } else if (x < 2 * s) {
            if (y < s) return calc(s, x - s, y);
            else if (y < 2 * s) return Math.min(Math.min(x - s, 2 * s - x), Math.min(y - s, 2 * s - y));
            else return calc(s, x - s, y - 2 * s);
        } else {
            if (y < s) return calc(s, x - 2 * s, y);
            else if (y < 2 * s) return calc(s, x - 2 * s, y - s);
            else return calc(s, x - 2 * s, y - 2 * s);
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int l = readInt();
        while (l > 0) {
            double x = readDouble();
            double y = readDouble();
            println(calc(l, x, y));

            l = readInt();
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
