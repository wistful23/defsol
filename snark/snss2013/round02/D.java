import java.io.*;
import java.util.*;

public class D {

    void solve() throws IOException {
        in("__std"); out("__std");

        int u = readInt();
        int d = readInt();
        int m = readInt();
        String bad = readLine();
        char[][] f = new char[u][];
        for (int i = 0; i < u; ++i) {
            f[i] = readLine().toCharArray();
        }

        int[][] c = new int[u][d];
        for (int i = 0; i < u; ++i) {
            for (int j = 0; j < d; ++j) {
                c[i][j] = bad.indexOf(f[i][j]) != -1 ? 1 : 0;
                if (i > 0) c[i][j] += c[i - 1][j];
                if (j > 0) c[i][j] += c[i][j - 1];
                if (i > 0 && j > 0) c[i][j] -= c[i - 1][j - 1];
            }
        }

        int a = 0;
        int b = 1;
        for (int i = 0; i < u - m + 1; ++i) {
            for (int j = 0; j < d - m + 1; ++j) {
                for (int p = i + m - 1; p < u; ++p) {
                    for (int q = j + m - 1; q < d; ++q) {
                        int s = (p - i + 1) * (q - j + 1);
                        int r = c[p][q];
                        if (i > 0) r -= c[i - 1][q];
                        if (j > 0) r -= c[p][j - 1];
                        if (i > 0 && j > 0) r += c[i - 1][j - 1];
                        if (r * b > s * a || (r * b == s * a && s > b)) {
                            a = r;
                            b = s;
                        }
                    }
                }
            }
        }
        println(a + "/" + b);

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
        new D().solve();
    }
}
