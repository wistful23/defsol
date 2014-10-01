import java.io.*;
import java.util.*;

public class C {

    int[] a;
    boolean[] c;
    Set<Integer>[] g;
    int p;

    boolean dfs() {
        int v = a[p];
        c[v] = true;
        ++p;
        while (p < a.length && g[v].contains(a[p])) {
            if (!dfs()) return false;
        }
        for (Iterator<Integer> i = g[v].iterator(); i.hasNext(); ) {
            int u = i.next();
            if (!c[u]) return false;
            i.remove();
        }
        return true;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int m = readInt();
        g = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new HashSet<Integer>();
        }
        while (m-- > 0) {
            int a = readInt() - 1;
            int b = readInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt() - 1;
        }

        c = new boolean[n];
        p = 0;
        boolean flag = true;
        while (p < n && (flag = dfs())) {
        }

        println(flag ? "YES" : "NO");

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
