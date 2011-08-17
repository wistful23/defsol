import java.io.*;
import java.util.*;

public class D {

    void solve() throws IOException {
        in("message.in"); out("message.out");

        int n = readInt();
        int[] s = new int[2 * n];
        for (int i = 0; i < 2 * n; ++i) {
            s[i] = readInt();
        }
        long[] l = new long[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            l[i] = s[2 * (n - i - 1)];
            if (i > 0) l[i] += l[i - 1];
        }
        long best = Long.MAX_VALUE;
        long c = 0;
        for (int i = 1; i <= n; ++i) {
            long r = s[0] + c;
            if (i < n) r += l[n - i - 1];
            r *= s[0] + s[i];
            if (r < best) best = r;
            c += s[i];
        }
        println(best);

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
        new D().solve();
    }
}
