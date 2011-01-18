import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int sl = (1 << m) - 1;
        int sr = (1 << m) - 1;
        int k = 0;
        char[] c = new char[m];
        while (n-- > 0) {
            String s = in.readLine();
            int r = s.length() / 2;
            int csl = 0;
            int csr = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (i < r - 1 || i > r + 1) {
                    int id = 0;
                    while (id < k && c[id] != s.charAt(i)) ++id;
                    if (id == k) {
                        c[k++] = s.charAt(i);
                    }
                    if (i < r - 1) {
                        csl |= (1 << id);
                    } else {
                        csr |= (1 << id);
                    }
                }
            }
            char w = s.charAt(r);
            if (w == '<') {
                sl &= csl;
                sr &= csr;
            } else if (w == '>') {
                sl &= csr;
                sr &= csl;
            } else {
                sl &= ~(csl | csr);
                sr &= ~(csl | csr);
            }
        }

        char lc = 0;
        char rc = 0;
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            if ((sl & (1 << i)) != 0) {
                lc = c[i];
                ++cnt;
            }
            if ((sr & (1 << i)) != 0) {
                rc = c[i];
                ++cnt;
            }
        }

        if (cnt == 1) {
            out.println(lc > 0 ? lc + "-" : rc + "+");
        } else {
            out.println("-1");
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
