import java.io.*;
import java.util.*;

public class B {

    boolean[][] g;
    int[] p;
    boolean[] mask;
    int m;

    void solve() throws IOException {
        in("letters.in"); out("letters.out");

        m = readInt();
        int q = readInt();
        char[][] l = new char[m][];
        for (int i = 0; i < m; ++i) {
            l[i] = readToken().toCharArray();
        }
        int r = 0;
        while (q-- > 0) {
            char[] s = readToken().toCharArray();
            int n = s.length;
            g = new boolean[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m && !g[i][j]; ++j) {
                    for (int k = 0; k < l[j].length && !g[i][j]; ++k) {
                        g[i][j] = s[i] == l[j][k];
                    }
                }
            }
            p = new int[m];
            Arrays.fill(p, -1);
            mask = new boolean[n];
            boolean flag = true;
            for (int i = 0; i < n && flag; ++i) {
                Arrays.fill(mask, true);
                flag = can(i);
            }
            if (flag) ++r;
        }
        println(r);

        exit();
    }

    boolean can(int i) {
        if (!mask[i]) return false;
        mask[i] = false;
        for (int j = 0; j < m; ++j) {
            if (g[i][j] && (p[j] == -1 || can(p[j]))) {
                p[j] = i;
                return true;
            }
        }
        return false;
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

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    void println(Object value) {
        out.println(value);
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new B().solve();
    }
}
