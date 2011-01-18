import java.io.*;
import java.util.*;

public class D {

    final static int MAX_VAL = 500;

    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine()) - 1;
        int[][] v = new int[n][];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int k = st.countTokens();
            v[i] = new int[k];
            for (int j = 0; j < k; ++j) {
                v[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int[][] d = new int[n][MAX_VAL + 1];
        for (int i = 0; i < n; ++i) {
            for (int val = 1; val <= MAX_VAL; ++val) {
                int cnt = 0;
                for (int j = 0; j < v[i].length; ++j) {
                    if (v[i][j] >= val) ++cnt;
                }
                if (i > 0) {
                    for (int val2 = val; val2 <= MAX_VAL; ++val2) {
                        if (d[i - 1][val2] > d[i][val]) d[i][val] = d[i - 1][val2];
                    }
                }
                d[i][val] += cnt * val;
                if (d[i][val] > ans) ans = d[i][val];
            }
        }

        out.println(ans);

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
