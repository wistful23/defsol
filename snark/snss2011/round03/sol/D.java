import java.io.*;
import java.util.*;

public class D {

    int m, n, mn, min, max, p;

    void solve() throws IOException {
        in("__std"); out("__std");

        m = readInt();
        n = readInt();
        mn = n * m;
        min = readInt();
        max = readInt();
        p = readInt();
        int b = 0;
        for (int i = 0; i < m; ++i) {
            char[] l = readLine().toCharArray();
            for (int j = 0; j < n; ++j) {
                if (l[j] == '*') b |= 1 << (i * n + j);
            }
        }
        int s = 1 << mn;
        int[] d = new int[s];
        for (int c = 0; c < s; ++c) {
            d[step(c)] = Integer.MAX_VALUE;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int c = 0; c < s; ++c) {
            if (d[c] == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            int r = step(c);
            if (d[r] > d[c] + 1) {
                d[r] = d[c] + 1;
                q.add(r);
            }
        }
        println(d[b] < Integer.MAX_VALUE ? d[b] : -1);

        exit();
    }

    int step(int c) {
        int r = 0;
        for (int i = 0; i < mn; ++i) {
            int k = f(c, i - n) + f(c, i + n);
            if (i % n > 0) {
                k += f(c, i - n - 1) + f(c, i - 1) + f(c, i + n - 1);
            }
            if (i % n < n - 1) {
                k += f(c, i - n + 1) + f(c, i + 1) + f(c, i + n + 1);
            }
            if (f(c, i) == 0) {
                if (k > p) r |= 1 << i;
            } else {
                if (k >= min && k <= max) r |= 1 << i;
            }
        }
        return r;
    }

    int f(int c, int i) {
        return i >= 0 && (c & (1 << i)) > 0 ? 1 : 0;
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
        new D().solve();
    }
}
