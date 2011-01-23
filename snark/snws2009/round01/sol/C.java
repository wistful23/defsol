import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("crabs.in"));
        out = new PrintWriter("crabs.out");

        int k = Integer.parseInt(in.readLine());
        for (int x = 1; x <= k; ++x) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int[] c = new int[n];
            int[] p = new int[n];
            int[] s = new int[m];
            boolean[] v = new boolean[m];
            for (int i = 0; i < n; ++i) {
                c[i] = Integer.parseInt(in.readLine());
                p[i] = i;
                v[i] = true;
            }
            List[] l = new List[m];
            for (int j = 0; j < m; ++j) {
                s[j] = Integer.parseInt(in.readLine());
                l[j] = new ArrayList<Integer>();
            }
            int ct = 0;
            while (true) {
                int dt = Integer.MAX_VALUE;
                for (int i = 0; i < n; ++i) {
                    if (p[i] != -1 && s[p[i]] - c[i] < dt) {
                        dt = s[p[i]] - c[i];
                    }
                }
                if (dt == Integer.MAX_VALUE || ct + dt > t) {
                    break;
                }
                for (int i = 0; i < n; ++i) {
                    if (p[i] != -1) {
                        c[i] += dt;
                        if (s[p[i]] == c[i]) {
                            v[p[i]] = false;
                        }
                    }
                }
                for (int i = 0; i < n; ++i) {
                    if (p[i] != -1 && s[p[i]] == c[i]) {
                        p[i] = -1;
                        for (int j = 0; j < m; ++j) {
                            if (!v[j] && s[j] > c[i] && c[i] >= s[j] - d) {
                                if (p[i] == -1 || s[j] > s[p[i]]) {
                                    p[i] = j;
                                }
                            }
                        }
                        if (p[i] != -1) {
                            l[p[i]].add(i);
                        }
                    }
                }
                for (int j = 0; j < m; ++j) {
                    if (l[j].size() > 0) {
                        v[j] = true;
                        int best = 0;
                        for (Object o : l[j]) {
                            int i = (Integer) o;
                            int w = c[i];
                            if (w > best) {
                                best = w;
                            }
                        }
                        for (Object o : l[j]) {
                            int i = (Integer) o;
                            if (c[i] < best) {
                                p[i] = -1;
                            }
                        }
                        l[j].clear();
                    }
                }
                ct += dt;
            }
            out.println("Data Set " + x + ":");
            for (int i = 0; i < n; ++i) {
                if (p[i] != -1) {
                    out.println(i + 1);
                }
            }
            out.println();
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
