import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int m = readInt();
        int l = n + m + 2;
        int[][] g = new int[l][l];
        String[] r = new String[n];
        for (int i = 0; i < n; ++i) {
            String s = readLine();
            int p = s.indexOf(' ');
            g[n + m][i] = Integer.valueOf(s.substring(0, p));
            r[i] = s.substring(p + 1);
        }
        String[] c = new String[m];
        for (int i = 0; i < m; ++i) {
            String s = readLine();
            int p = s.indexOf(' ');
            g[n + i][n + m + 1] = Integer.valueOf(s.substring(0, p));
            c[i] = s.substring(p + 1);
        }
        int k = readInt();
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; ++i) {
            String s = readLine();
            StringTokenizer st = new StringTokenizer(s, "/");
            String sr = st.nextToken();
            String sc = st.nextToken();
            while (!r[a[i]].equals(sr)) ++a[i];
            while (!c[b[i]].equals(sc)) ++b[i];
            g[a[i]][n + b[i]] = Integer.MAX_VALUE;
        }

        int[][] f = new int[l][l];
        for (int i = 0; i < l; ++i) {
            Arrays.fill(f[i], 0);
        }
        int[] v = new int[l];
        int[] p = new int[l];
        Queue<Integer> q = new LinkedList<Integer>();
        while (true) {
            Arrays.fill(v, 0);
            Arrays.fill(p, -1);
            v[n + m] = Integer.MAX_VALUE;
            q.add(n + m);
            while (!q.isEmpty()) {
                int i = q.poll();
                for (int j = 0; j < l; ++j) {
                    int cv = Math.min(v[i], Math.max(g[i][j] - f[i][j], f[j][i]));
                    if (cv > v[j]) {
                        v[j] = cv;
                        p[j] = i;
                        q.add(j);
                    }
                }
            }
            if (v[l - 1] == 0) break;
            int j = l - 1;
            while (p[j] != -1) {
                int i = p[j];
                if (g[i][j] > 0) {
                    f[i][j] += v[l - 1];
                } else {
                    f[j][i] -= v[l - 1];
                }
                j = i;
            }
        }

        for (int i = 0; i < k; ++i) {
            println(r[a[i]] + "/" + c[b[i]] + ": " + f[a[i]][n + b[i]]);
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
        new F().solve();
    }
}
