import java.io.*;
import java.util.*;

public class E {

    void solve() throws IOException {
        in("numbers.in"); out("numbers.out");

        int n = readInt();
        int m = readInt();
        int k = readInt();
        int[] a = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt();
            s[i] = a[i] + (i > 0 ? s[i - 1] : 0);
        }
        int[][] d = new int[n][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (i > 0) d[i][j] = d[i - 1][j];
                if (j > 0) {
                    int r = s[i];
                    int t = i - k;
                    if (t >= 0) {
                        r += d[t][j - 1] - s[t];
                    }
                    if (r > d[i][j]) {
                        d[i][j] = r;
                    }
                }
            }
        }
        println(d[n - 1][m]);

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
        new E().solve();
    }
}
