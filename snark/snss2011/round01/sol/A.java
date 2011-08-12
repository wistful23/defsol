import java.io.*;
import java.util.*;

public class A {

    void solve() throws IOException {
        in("binpal.in"); out("binpal.out");

        int m = readInt() - 1;
        int c = 1;
        int l = 1;
        while (m >= c) {
            m -= c;
            if ((l & 1) == 0) c <<= 1;
            ++l;
        }
        int r = 1;
        for (int i = 1; i < l / 2; ++i) {
            if ((m & (1 << ((l - 1) / 2 - i))) != 0) {
                r |= (1 << i);
            }
        }
        r |= (1 << (l - 1)) | (m << (l / 2));
        println(r);

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
        new A().solve();
    }
}
