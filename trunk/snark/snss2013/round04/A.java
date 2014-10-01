import java.io.*;
import java.util.*;

public class A {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int m = readInt();
        int k = readInt();

        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        int[] b = new int[n + 1];
        int[] e = new int[n + 1];
        double[] d = new double[n + 1];
        boolean[] mask = new boolean[n + 1];

        int s = 0;
        x[s] = readInt();
        y[s] = readInt();
        b[s] = m;
        e[s] = m;
        d[s] = 1e23;
        for (int i = 1; i < n + 1; ++i) {
            x[i] = readInt();
            y[i] = readInt();
            b[i] = readInt();
            e[i] = readInt();
            d[i] = 1e23;
            if (x[s] == x[i] && y[s] == y[i] &&
               ((e[s] >= b[i] && e[s] < e[i]) || (e[s] > e[i] && e[s] <= b[i]))) {
                s = i;
            }
        }

        double best = 1e23;

        d[s] = 0;
        int j = s;
        while (j != -1) {
            int i = j;
            mask[i] = true;

            if (k == e[i] && d[i] < best) {
                best = d[i];
            }

            for (j = 0; j < n + 1; ++j) {
                if ((e[i] >= b[j] && e[i] < e[j]) || (e[i] > e[j] && e[i] <= b[j])) {
                    double l = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
                    if (d[i] + l < d[j]) {
                        d[j] = d[i] + l;
                    }
                }
            }

            j = -1;
            for (i = 0; i < n + 1; ++i) {
                if (!mask[i] && d[i] < 1e20 && (j == -1 || d[i] < d[j])) {
                    j = i;
                }
            }
        }

        if (best < 1e20) {
            println(best);
        } else {
            println(-1);
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
        new A().solve();
    }
}
