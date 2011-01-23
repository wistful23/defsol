import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("domino.in"));
        out = new PrintWriter("domino.out");
        while (in.ready()) {
            Arrays.fill(c, 0);
            for (int i = 0; i < 17; ++i) {
                Arrays.fill(g[i], false);
            }
            int n = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            while (n-- > 0) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                ++c[i];
                ++c[j];
                g[i][j] = true;
                g[j][i] = true;
            }
            n = 0;
            int k = 0;
            for (int i = 0; i < 17; ++i) {
                if ((c[i] & 1) == 1) {
                    ++k;
                }
                if (c[i] > 0) {
                    ++n;
                }
            }
            if (k == 0 || k == 2) {
                int i = 0;
                while (c[i] == 0) {
                    ++i;
                }
                int r = dfs(i);
                if (r == n) {
                    out.println("A chain is possible.");
                    continue;
                }
            }
            out.println("No chain is possible.");
        }
        out.close();
    }

    int dfs(int i) {
        if (c[i] == 0) {
            return 0;
        }
        c[i] = 0;
        int r = 1;
        for (int j = 0; j < 17; ++j) {
            if (g[i][j]) {
                r += dfs(j);
            }
        }
        return r;
    }

    int c[] = new int[17];
    boolean g[][] = new boolean[17][17];

    BufferedReader in;
    PrintWriter out;
}
