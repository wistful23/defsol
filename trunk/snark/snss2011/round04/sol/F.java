import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in("__std"); out("__std");

        double a0 = readInt();
        double b0 = readInt();
        if (a0 > b0) {
            double t = a0; a0 = b0; b0 = t;
        }
        double c0 = Math.hypot(a0, b0);
        double s = 0;
        double l = 1e23;
        while (l > 1e-10) {
            double h = b0 * a0 / c0;
            double c1 = c0 - Math.sqrt(a0 * a0 - h * h);
            double a1 = c1 * a0 / c0;
            double b1 = c1 * b0 / c0;
            l = h + a1;
            s += l;
            a0 = a1; b0 = b1; c0 = c1;
        }
        println("%.8f", s);
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
        new F().solve();
    }
}
