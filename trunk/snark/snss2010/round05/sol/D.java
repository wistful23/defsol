import java.io.*;
import java.util.*;

public class D {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int k = n * n / 4;
        char[][] s = new char[n][n];
        for (int i = 0; i < n; ++i) {
            s[i] = readLine().toCharArray();
            for (int j = 0; j < n; ++j) {
                if (s[i][j] == '0') --k;
            }
        }

        for (int i = 0; i < n && k > 0; ++i) {
            for (int j = 0; j < n && k > 0; ++j) {
                if (s[i][j] == '1') {
                    int ii = i;
                    int jj = j;
                    boolean flag = true;
                    for (int r = 0; r < 3 && flag; ++r) {
                        int t = ii;
                        ii = jj;
                        jj = n - t - 1;
                        flag = s[ii][jj] == '1';
                    }
                    if (flag) {
                        --k;
                        s[i][j] = '0';
                        ii = i;
                        jj = j;
                        for (int r = 0; r < 3; ++r) {
                            int t = ii;
                            ii = jj;
                            jj = n - t - 1;
                            s[ii][jj] = '2';
                        }
                    }
                }
            }
        }

        if (k == 0) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    print(s[i][j] == '0' ? '0' : '1');
                }
                println();
            }
        } else {
            println("No solution");
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
        new D().solve();
    }
}
