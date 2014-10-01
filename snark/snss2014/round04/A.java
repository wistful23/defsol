import java.io.*;
import java.util.*;

public class A {

    final static int MOD = 1000000007;

    class Link {
        char t;
        int b;

        Link(char t, int b) {
            this.t = t;
            this.b = b;
        }
    }

    int n, m;
    List<Link>[] g;
    int[][][] d;

    int[] calc(int a, int w) {
        if (d[a][w] == null) {
            int[][] c = new int[2][m + 1];
            int t = 0;
            c[t][w] = 1;
            for (Link l : g[a]) {
                int[] r1 = calc(l.b, 0);
                int[] r2 = calc(l.b, 1);
                for (int i = 0; i <= m; ++i) {
                    for (int j = 0; j <= m - i; ++j) {
                        int v = r1[j];
                        if (w == 0) {
                            v += r2[j];
                        } else if (l.t == 'D') {
                            v = r2[j];
                        }
                        c[1 - t][i + j] = (int) (c[1 - t][i + j] + ((long) c[t][i] * v) % MOD) % MOD;
                    }
                }
                Arrays.fill(c[t], 0);
                t = 1 - t;
            }
            d[a][w] = c[t];
        }
        return d[a][w];
    }

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        n = in.readInt();
        m = in.readInt();

        if (m == 0) {
            out.println(1);
            exit();
        }

        int s = in.readInt();
        g = new List[n];
        for (int a = 0; a < n; ++a) {
            g[a] = new ArrayList<Link>();
        }
        while (s-- > 0) {
            char t = in.readToken().charAt(0);
            int a = in.readInt() - 1;
            int b = in.readInt() - 1;
            g[a].add(new Link(t, b));
        }

        d = new int[n][2][];
        int[][] c = new int[2][m + 1];
        int t = 0;
        c[t][0] = 1;
        for (int a = 0; a < n; ++a) {
            if (d[a][0] == null) {
                int[] r1 = calc(a, 0);
                int[] r2 = calc(a, 1);
                for (int i = 0; i <= m; ++i) {
                    for (int j = 0; j <= m - i; ++j) {
                        int v = r1[j] + r2[j];
                        c[1 - t][i + j] = (int) (c[1 - t][i + j] + ((long) c[t][i] * v) % MOD) % MOD;
                    }
                }
                Arrays.fill(c[t], 0);
                t = 1 - t;
            }
        }

        out.println(c[t][m]);

        exit();
    }

    void exit() {
        //System.err.println((System.currentTimeMillis() - startTime) + " ms");
        out.close();
        System.exit(0);
    }

    InputReader in;
    OutputWriter out;

    //long startTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    class InputReader {

        private InputStream stream;

        private byte[] buffer = new byte[1024];
        private int pos, len;

        private int cur;

        private StringBuilder sb = new StringBuilder(32);

        InputReader(String name) throws IOException {
            if (name.equals("__std")) {
                stream = System.in;
            } else {
                stream = new FileInputStream(name);
            }
            cur = read();
        }

        private int read() throws IOException {
            if (len == -1) {
                throw new EOFException();
            }
            if (pos >= len) {
                pos = 0;
                len = stream.read(buffer);
                if (len == -1) return -1;
            }
            return buffer[pos++];
        }

        char readChar() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            char res = (char) cur;
            cur = read();
            return res;
        }

        int readInt() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            while (whitespace()) {
                cur = read();
            }
            if (cur == -1) {
                throw new EOFException();
            }
            int sign = 1;
            if (cur == '-') {
                sign = -1;
                cur = read();
            }
            int res = 0;
            while (!whitespace()) {
                if (cur < '0' || cur > '9') {
                    throw new NumberFormatException();
                }
                res *= 10;
                res += cur - '0';
                cur = read();
            }
            return res * sign;
        }

        long readLong() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            return Long.parseLong(readToken());
        }

        double readDouble() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            return Double.parseDouble(readToken());
        }

        String readLine() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            sb.setLength(0);
            while (cur != -1 && cur != '\r' && cur != '\n') {
                sb.append((char) cur);
                cur = read();
            }
            if (cur == '\r') {
                cur = read();
            }
            if (cur == '\n') {
                cur = read();
            }
            return sb.toString();
        }

        String readToken() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            while (whitespace()) {
                cur = read();
            }
            if (cur == -1) {
                throw new EOFException();
            }
            sb.setLength(0);
            while (!whitespace()) {
                sb.append((char) cur);
                cur = read();
            }
            return sb.toString();
        }

        boolean whitespace() {
            return cur == ' ' || cur == '\t' || cur == '\r' || cur == '\n' || cur == -1;
        }

        boolean eof() {
            return cur == -1;
        }
    }

    class OutputWriter {

        private PrintWriter writer;

        OutputWriter(String name) throws IOException {
            if (name.equals("__std")) {
                writer = new PrintWriter(System.out);
            } else {
                writer = new PrintWriter(name);
            }
        }

        void print(String format, Object ... args) {
            writer.print(new Formatter(Locale.US).format(format, args));
        }

        void println(String format, Object ... args) {
            writer.println(new Formatter(Locale.US).format(format, args));
        }

        void print(Object value) {
            writer.print(value);
        }

        void println(Object value) {
            writer.println(value);
        }

        void println() {
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}
