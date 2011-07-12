import java.io.*;
import java.util.*;

public class F {

    int n;
    char[] s;
    char[][] w;

    int[][] c;

    void solve() throws IOException {
        in("censor.in"); out("censor.out");

        n = readInt();
        while (n > 0) {
            s = readToken().toCharArray();
            w = new char[n][];
            for (int i = 0; i < n; ++i) {
                w[i] = readToken().toCharArray();
            }
            int m = s.length;
            c = new int[m][m];
            for (int i = 0; i < m; ++i) {
                Arrays.fill(c[i], -1);
            }
            println(f(0, m - 1));
            n = readInt();
        }

        exit();
    }

    int f(int i, int j) {
        if (i > j) return 0;
        int len = j - i + 1;
        for (int k = 0; k < n && c[i][j] == -1; ++k) {
            int m = w[k].length;
            if (w[k].length <= len && s[i] == w[k][0] && s[j] == w[k][m - 1]) {
                boolean[][] d = new boolean[m][len];
                d[0][0] = true;
                for (int l = 1; l < m; ++l) {
                    for (int u = l; u < len; ++u) {
                        if (w[k][l] == s[i + u]) {
                            for (int v = l - 1; v < u && !d[l][u]; ++v) {
                                d[l][u] = d[l - 1][v] && f(i + v + 1, i + u - 1) == 0;
                            }
                        }
                    }
                }
                if (d[m - 1][len - 1]) {
                    c[i][j] = 0;
                }
            }
        }
        if (c[i][j] == -1) {
            if (len == 1) {
                c[i][j] = 1;
            } else{
                c[i][j] = Integer.MAX_VALUE;
                for (int l = i; l < j; ++l) {
                    c[i][j] = Math.min(c[i][j], f(i, l) + f(l + 1, j));
                }
            }
        }
        return c[i][j];
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
