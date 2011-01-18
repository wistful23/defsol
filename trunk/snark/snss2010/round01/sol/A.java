import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        l = 1 << n;
        d = new int[l];
        int c = 0;
        char[] s = in.readLine().toCharArray();
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'O') {
                c |= (1 << i);
            }
        }
        if (c == l - 1) {
            out.println(n % 4 != 0 ? "Yes" : "No");
        } else {
            out.println(win(c) ? "Yes" : "No");
        }

        out.close();
    }

    int l;
    int[] d;

    boolean win(int c) {
        if (d[c] == 0) {
            d[c] = 2;
            for (int i = 0; i < l; ++i) {
                if ((c & (1 << i)) != 0) {
                    int nc = c & ~(1 << i);
                    if (i > 0) nc = nc & ~(1 << (i - 1));
                    if (i < l - 1) nc = nc & ~(1 << (i + 1));
                    if (!win(nc)) {
                        d[c] = 1;
                        break;
                    }
                }
            }
        }
        return d[c] == 1;
    }

    BufferedReader in;
    PrintWriter out;
}
