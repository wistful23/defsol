import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int m = readInt();
        int[][] t = new int[n * m][];
        for (int i = 0; i < t.length; ++i) {
            int r = readInt();
            t[i] = new int[2 * r];
            for (int j = 0; j < t[i].length; ++j) {
                t[i][j] = readInt();
            }
        }
        int[][] d = new int[n][m];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        Queue<Integer> qi = new LinkedList<Integer>();
        Queue<Integer> qj = new LinkedList<Integer>();
        qi.add(0);
        qj.add(0);
        while (!qi.isEmpty()) {
            int i = qi.poll();
            int j = qj.poll();
            int v = d[i][j];
            int p = i * m + j;
            int l = 1;
            while (l < t[p].length && v >= t[p][l]) {
                l += 2;
            }
            if (l < t[p].length && v >= t[p][l - 1]) {
                v = t[p][l];
            }
            for (int k = 0; k < 4; ++k) {
                int ii = i + di[k];
                int jj = j + dj[k];
                if (ii >= 0 && ii < n && jj >= 0 && jj < m && d[ii][jj] > v) {
                    d[ii][jj] = v;
                    qi.add(ii);
                    qj.add(jj);
                }
            }
        }
        println(d[n - 1][m - 1]);

        exit();
    }

    final static int[] di = {-1, 1, 0, 0};
    final static int[] dj = {0, 0, -1, 1};

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
