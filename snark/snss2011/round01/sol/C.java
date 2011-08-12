import java.io.*;
import java.util.*;

public class C {

    final static int[] di = {-2, -2, -1, -1, 1, 1, 2, 2};
    final static int[] dj = {1, -1, 2, -2, 2, -2, 1, -1};

    int[][] l;
    boolean[] mask;
    int[] p;

    void solve() throws IOException {
        in("knights.in"); out("knights.out");

        int n = readInt();
        char[][] f = new char[n][n];
        for (int i = 0; i < n; ++i) {
            f[i] = readLine().toCharArray();
        }

        int m = n * n;
        l = new int[m][8];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(l[i], -1);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (((i + j) & 1) == 0 && f[i][j] == '.') {
                    for (int k = 0; k < 8; ++k) {
                        int ii = i + di[k];
                        int jj = j + dj[k];
                        if (ii >= 0 && ii < n && jj >= 0 && jj < n && f[ii][jj] == '.') {
                            l[i * n + j][k] = ii * n + jj;
                        }
                    }
                }
            }
        }

        p = new int[m];
        mask = new boolean[m];
        Arrays.fill(p, -1);
        for (int i = 0; i < m; ++i) {
            Arrays.fill(mask, true);
            can(i);
        }

        for (int i = 0; i < m; ++i) {
            if (p[i] != -1) {
                f[i / n][i % n] = 'K';
            }
        }

        for (int i = 0; i < n; ++i) {
            println(String.valueOf(f[i]));
        }

        exit();
    }

    boolean can(int i) {
        if (!mask[i]) return false;
        mask[i] = false;
        for (int k = 0; k < 8; ++k) {
            int j = l[i][k];
            if (j != -1 && (p[j] == -1 || can(p[j]))) {
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


    void println(Object value) {
        out.println(value);
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new C().solve();
    }
}
