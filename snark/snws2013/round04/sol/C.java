import java.io.*;
import java.util.*;

public class C {

    int n, k;

    boolean[][] g;
    boolean[] mask;
    int[] r;

    boolean can(int i) {
        if (mask[i]) return false;
        mask[i] = true;
        for (int j = 0; j < k; ++j) {
            if (g[i][j] && (r[j] == -1 || can(r[j]))) {
                r[j] = i;
                return true;
            }
        }
        return false;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        k = readInt();
        boolean[][] a = new boolean[n][k];
        for (int i = 0; i < n; ++i) {
            int m = readInt();
            while (m-- > 0) {
                int j = readInt() - 1;
                a[i][j] = true;
            }
        }
        int q = readInt();
        while (q-- > 0) {
            g = new boolean[n][k];
            boolean[] bad = new boolean[n];
            boolean[] used = new boolean[k];
            int cnt = 0;
            int t = readInt();
            while (t-- > 0) {
                int p = readInt() - 1;
                bad[p] = true;
                for (int i = 0; i < p; ++i) {
                    if (!bad[i]) {
                        for (int j = 0; j < k; ++j) {
                            if (!used[j] && a[p][j] && a[i][j]) {
                                g[i][j] = true;
                            }
                        }
                    }
                }
                for (int j = 0; j < k; ++j) {
                    if (!used[j] && a[p][j]) {
                        used[j] = true;
                        ++cnt;
                    }
                }
            }
            mask = new boolean[n];
            r = new int[k];
            Arrays.fill(r, -1);
            for (int i = 0; i < n; ++i) {
                if (!bad[i]) {
                    Arrays.fill(mask, false);
                    if (can(i)) --cnt;
                }
            }
            println(cnt == 0 ? "Yes" : "No");
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
        new C().solve();
    }
}
