import java.io.*;
import java.util.*;

public class F {

    int n;
    boolean[][] g;
    boolean[] mask;
    int[] p;

    void solve() throws IOException {
        in("shooting.in"); out("shooting.out");

        n = readInt();
        int m = readInt();
        g = new boolean[n][n];
        while (m-- > 0) {
            int a = readInt() - 1;
            int b = readInt() - 1;
            g[a][b] = g[b][a] = true;
        }

        p = new int[n];
        mask = new boolean[n];
        boolean flag = true;
        Arrays.fill(p, -1);
        for (int i = 0; i < n && flag; ++i) {
            Arrays.fill(mask, true);
            flag = can(i);
        }

        if (flag) {
            for (int i = 0; i < n; ++i) {
                println(p[i] + 1);
            }
        } else {
            println("Impossible");
        }

        exit();
    }

    boolean can(int i) {
        if (!mask[i]) return false;
        mask[i] = false;
        for (int j = 0; j < n; ++j) {
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
        new F().solve();
    }
}
