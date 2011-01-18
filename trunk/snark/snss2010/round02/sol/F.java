import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        int[] s = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i < n; ++i) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int[] c = new int[m];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; ++i) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[] f1 = new int[p];
        int[] f2 = new int[p];
        for (int i = 0; i < p; ++i) {
            st = new StringTokenizer(in.readLine());
            f1[i] = Integer.parseInt(st.nextToken()) - 1;
            f2[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        double ans = 0;
        int[] w = new int[m];
        int[] l = new int[p];
        Arrays.fill(w, -1);
        Arrays.fill(l, -1);
        for (int i = 0; i < n; ++i) {
            if (l[k] != -1) {
                int sum = 0;
                for (int j = 0; j < m; ++j) {
                    if (w[j] != -1) {
                        sum += c[j];
                    }
                }
                ans += 1.0 * c[l[k]] / sum * s[i];
            }
            for (int j = 0; j < p; ++j) {
                if (f2[j] == i && l[j] != -1) {
                    w[l[j]] = -1;
                    l[j] = -1;
                }
            }
            for (int j = 0; j < p; ++j) {
                if (f1[j] == i) {
                    int r = -1;
                    for (int t = 0; t < m; ++t) {
                        if (w[t] == -1) {
                            if (r == -1 || c[t] > c[r]) {
                                r = t;
                            }
                        }
                    }
                    if (r != -1) {
                        w[r] = j;
                        l[j] = r;
                    }
                }
            }
        }

        out.println(new Formatter().format("%.2f", ans));

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
