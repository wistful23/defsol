import java.io.*;
import java.util.*;

public class C {

    static int[] di = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dj = {-1, -1, -1, 0, 0, 1, 1, 1};

    int n, m;
    char[][] f;
    boolean[][] mask;

    boolean fill(int i, int j) {
        mask[i][j] = true;
        if (f[i][j] == '*') {
            return true;
        }
        boolean r = false;
        for (int k = 0; k < 8; ++k) {
            int ii = i + di[k];
            int jj = j + dj[k];
            if (ii >= 0 && ii < n && jj >= 0 && jj < m && !mask[ii][jj] && f[ii][jj] != '.') {
                r |= fill(ii, jj);
            }
        }
        return r;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        m = readInt();
        f = new char[n][];
        for (int i = 0; i < n; ++i) {
            f[i] = readLine().toCharArray();
        }
        int a = 0;
        mask = new boolean[n][m];
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!mask[i][j] && f[i][j] != '.') {
                    if (fill(i, j)) ++a;
                }
            }
        }
        int b = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < m - 3; ++j) {
                if (new String(f[i], j, 4).equals("[][]")) {
                    boolean flag = (j == 0 || f[i][j - 1] == '.') && (j == m - 4 || f[i][j + 4] == '.');
                    for (int jj = j - 1; jj < j + 5 && flag; ++jj) {
                        if (jj > 0 && jj < m) {
                            flag = (i == 0 || f[i - 1][jj] == '.') && f[i + 1][jj] == '.';
                        }
                    }
                    if (flag) {
                        ++b;
                    }
                }
            }
        }
        println(a + " " + b);

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
        new C().solve();
    }
}
