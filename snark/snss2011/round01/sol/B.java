import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("fold.in"); out("fold.out");

        int t = readInt();
        while (t-- > 0) {
            int x = readInt();
            int y = readInt();
            int x0 = readInt();
            int y0 = readInt();
            int s = readInt();
            int c[][] = new int[2][];
            c[0] = new int[x + 1];
            c[1] = new int[y + 1];
            Arrays.fill(c[0], 1);
            Arrays.fill(c[1], 1);
            while (s-- > 0) {
                int k = readToken().charAt(0) == 'X' ? 0 : 1;
                int n = readInt();
                for (int i = n + 1; i < c[k].length && c[k][i] != 0; ++i) {
                    int j = 2 * n - i;
                    if (j >= 0) {
                        c[k][j] += c[k][i];
                    }
                    c[k][i] = 0;
                }
            }
            if (x0 < c[0].length && y0 < c[1].length) {
                println(c[0][x0] * c[1][y0]);
            } else {
                println(0);
            }
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
