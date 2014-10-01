import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        int t = readInt();
        while (t-- > 0) {
            int n = readInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; ++i) {
                x[i] = readInt();
                y[i] = readInt();
            }
            boolean[] mask = new boolean[n];
            int cnt = 0;
            int m = readInt();
            while (m-- > 0) {
                int xc = readInt();
                int yc = readInt();
                for (int i = 0; i < n; ++i) {
                    if (!mask[i] && x[i] >= xc - 50 && x[i] <= xc + 50 && y[i] >= yc - 50 && y[i] <= yc + 50) {
                        mask[i] = true;
                        ++cnt;
                    }
                }

            }
            println(cnt);
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
        new B().solve();
    }
}
