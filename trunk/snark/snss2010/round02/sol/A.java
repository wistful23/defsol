import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int p[] = new int[m];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; ++i) {
            p[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int x1 = Integer.MIN_VALUE;
        int y1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE;
        int y2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            // left
            boolean flag = true;
            for (int j = 0; j < m && flag; ++j) {
                flag = x[p[j]] >= x[i];
            }
            if (flag && x[i] > x1) x1 = x[i];

            // right
            flag = true;
            for (int j = 0; j < m && flag; ++j) {
                flag = x[p[j]] <= x[i];
            }
            if (flag && x[i] < x2) x2 = x[i];

            // bottom
            flag = true;
            for (int j = 0; j < m && flag; ++j) {
                flag = y[p[j]] >= y[i];
            }
            if (flag && y[i] > y1) y1 = y[i];

            // top
            flag = true;
            for (int j = 0; j < m && flag; ++j) {
                flag = y[p[j]] <= y[i];
            }
            if (flag && y[i] < y2) y2 = y[i];
        }

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (x[i] >= x1 && x[i] <= x2 && y[i] >= y1 && y[i] <= y2) ++cnt;
        }

        out.println(cnt);

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
