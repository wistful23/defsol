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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = -1;
        Set<Integer>[] l = new HashSet[m];
        for (int i = 0; i < m; ++i) {
            l[i] = new HashSet<Integer>();
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreElements()) {
                Integer r = Integer.parseInt(st.nextToken());
                l[i].add(r);
                if (a == -1 && r == 1) a = i;
            }
        }

        List<Integer> s = new ArrayList<Integer>();
        boolean[] mask = new boolean[m];
        if (a != -1) {
            Set<Integer> c = new HashSet<Integer>();
            boolean flag = true;
            while (flag) {
                c.addAll(l[a]);
                mask[a] = true;
                s.add(a + 1);
                flag = false;
                for (int i = 0; i < m && !flag; ++i) {
                    if (!mask[i] && !Collections.disjoint(l[i], c)) {
                        a = i;
                        flag = true;
                    }
                }
            }
        }

        if (s.size() == m) {
            for (Integer r : s) {
                out.print(r + " ");
            }
        } else {
            out.println("Impossible");
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
