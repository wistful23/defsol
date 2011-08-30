import java.io.*;
import java.util.*;

public class B {

    final static int di[] = {-1, 0, 1, 0};
    final static int dj[] = {0, -1, 0, 1};

    int n;
    int[][] a;
    int[][][] d, mk;

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        int b = readInt();
        int e = readInt();
        a = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = readInt();
            }
        }
        if (n == 1) {
            if ((b + a[0][0]) % e == 0) {
                println(b + " " + a[0][0] + " " + e);
            } else {
                println("Impossible");
            }
        } else {
            d = new int[n][n][4];
            mk = new int[n][n][4];
            walk(0, 0, 0, -1, b, 1);
            int s = n - 1;
            int bk = -1;
            for (int k = 0; k < 4; ++k) {
                if (d[s][s][k] != 0 && (bk == -1 || d[s][s][k] < d[s][s][bk])) {
                    if ((a[s + di[k]][s + dj[k]] + a[s][s]) % e == 0) {
                        bk = k;
                    }
                }
            }
            if (bk != -1) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(e);
                int i = s;
                int j = s;
                int k = bk;
                while (k != -1) {
                    ans.add(a[i][j]);
                    int kk = mk[i][j][k];
                    i += di[k];
                    j += dj[k];
                    k = kk;
                }
                ans.add(b);
                Collections.reverse(ans);
                for (int v : ans) print(v + " ");
                println();
            } else {
                println("Impossible");
            }
        }

        exit();
    }

    void walk(int i, int j, int k, int lk, int p, int l) {
        if (d[i][j][k] == 0 || d[i][j][k] > l) {
            d[i][j][k] = l;
            mk[i][j][k] = lk;
            for (int kk = 0; kk < 4; ++kk) {
                if (kk != k) {
                    int ii = i + di[kk];
                    int jj = j + dj[kk];
                    if (ii >= 0 && ii < n && jj >= 0 && jj < n && (p + a[i][j]) % a[ii][jj] == 0) {
                        walk(ii, jj, (kk + 2) % 4, k, a[i][j], l + 1);
                    }
                }
            }
        }
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
        new B().solve();
    }
}
