import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt() / 3;
        int k = readInt();
        int[][] m = new int[k][3];
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < 3; ++j) {
                m[i][j] = readInt();
            }
        }

        boolean[][][] d = new boolean[n + 1][n + 1][n + 1];
        d[0][0][0] = true;
        for (int i = 0; i < k; ++i) {
            for (int a = n - m[i][0]; a >= 0; --a) {
                for (int b = n - m[i][1]; b >= 0; --b) {
                    for (int c = n - m[i][2]; c >= 0; --c) {
                        if (d[a][b][c]) {
                            d[a + m[i][0]][b + m[i][1]][c + m[i][2]] = true;
                        }
                    }
                }
            }
        }

        println(d[n][n][n] ? "YES" : "NO");
        
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
        out.println(new Formatter().format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
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
