import java.io.*;
import java.util.*;

public class D {

    List<Integer>[] l;
    boolean[] mask;

    int c;

    void dfs(int i) {
        if (mask[i]) return;
        mask[i] = true;
        ++c;
        for (int j : l[i]) {
            dfs(j);
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int k = readInt();
        int m = readInt();

        int[] s = new int[k];
        for (int i = 0; i < k; ++i) {
            s[i] = readInt() - 1;
        }

        l = new List[n];
        for (int a = 0; a < n; ++a) {
            l[a] = new ArrayList<Integer>();
        }

        while (m-- > 0) {
            int a = readInt() - 1;
            int b = readInt() - 1;
            l[a].add(b);
        }

        mask = new boolean[n];
        for (int i = 0; i < k; ++i) {
            dfs(s[i]);
        }

        println(c == n ? "yes" : "no");

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
