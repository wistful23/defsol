import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("matrix.in"); out("matrix.out");

        int m = readInt();
        int n = readInt();
        int k = readInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = readInt();
            }
        }
        while (k-- > 0) {
            int t = readInt();
            int l = readInt();
            int h = readInt();
            int w = readInt();
            int r = 0;
            for (int i = t; i < t + h; ++i) {
                for (int j = l; j < l + w; ++j) {
                    r = gcd(r, a[i][j]);
                }
            }
            println(r);
        }

        exit();
    }

    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
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
        new C().solve();
    }
}
