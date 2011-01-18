import java.io.*;
import java.util.*;

public class F {

    int n, m;
    int c;
    boolean[] mask;
    int[][] r1, r2;

    boolean can(int j) {
        if (j == m) return true;
        for (int i = 0; i < n; ++i) {
            if (!mask[i] && beat(r1[i], r2[j])) {
                mask[i] = true;
                if (can(j + 1)) return true;
                mask[i] = false;
            }
        }
        return false;
    }

    boolean beat(int[] r1, int[] r2) {
        return (r1[1] == c && r2[1] != c) || (r1[1] == r2[1] && r1[0] > r2[0]);
    }

    int value(char v) {
        if (v <= '9') return v - '0';
        switch (v) {
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
        }
        return 0;
    }

    void solve() throws IOException {
        in("fool.in"); out("fool.out");

        int t = readInt();
        while (t-- > 0) {
            n = readInt();
            m = readInt();
            c = readToken().charAt(0);
            r1 = new int[n][2];
            r2 = new int[m][2];
            for (int i = 0; i < n; ++i) {
                char[] s = readToken().toCharArray();
                r1[i][0] = value(s[0]);
                r1[i][1] = s[1];
            }
            for (int j = 0; j < m; ++j) {
                char[] s = readToken().toCharArray();
                r2[j][0] = value(s[0]);
                r2[j][1] = s[1];
            }
            mask = new boolean[n];
            println(can(0) ? "YES" : "NO");
        }

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

    double readDouble() throws IOException {
        return Double.parseDouble(readToken());
    }

    String readLine() throws IOException {
        st = null;
        return in.readLine();
    }

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            if (!in.ready()) return "";
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    boolean eof() throws IOException {
        return !in.ready();
    }

    void print(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void print(Object value) {
        out.print(value);
    }

    void println(Object value) {
        out.println(value);
    }

    void println() {
        out.println();
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new F().solve();
    }
}
