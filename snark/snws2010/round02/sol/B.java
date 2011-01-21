import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("robots.in"));
        out = new PrintWriter("robots.out");

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] l = new int[3];
        l[0] = n;
        while (k-- > 0) {
            int m = 0;
            int i = 0;
            while (n - i * 5 >= 0) {
                m = Math.max(m, i * 9 + (n - i * 5) / 3 * 5);
                ++i;
            }
            n -= l[2];
            l[2] = l[1];
            l[1] = l[0];
            l[0] = m;
            n += m;
        }
        out.println(n);

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
