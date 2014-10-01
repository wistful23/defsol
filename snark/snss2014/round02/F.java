import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        int testCount = in.readInt();
        for (int test = 1; test <= testCount; ++test) {
            int s = in.readInt();
            int n = in.readInt();
            int m = in.readInt();
            int a = in.readInt() - 1;
            int b = in.readInt() - 1;
            int[][][] g = new int[n][n][m];
            for (int l = 0; l < m; ++l) {
                int x = in.readInt();
                int u = in.readInt() - 1;
                int tu = in.readInt();
                while (x-- > 1) {
                    int v = in.readInt() - 1;
                    int tv = in.readInt();
                    g[u][v][l] = g[v][u][l] = tv - tu;
                    u = v;
                    tu = tv;
                }
            }
            int[][] d = new int[n][m];
            for (int v = 0; v < n; ++v) {
                Arrays.fill(d[v], Integer.MAX_VALUE);
            }
            Queue<Integer> qv = new LinkedList<Integer>();
            Queue<Integer> ql = new LinkedList<Integer>();
            for (int l = 0; l < m; ++l) {
                qv.add(a);
                ql.add(l);
                d[a][l] = 0;
            }
            while (!qv.isEmpty()) {
                int v = qv.poll();
                int l = ql.poll();
                for (int u = 0; u < n; ++u) {
                    for (int nl = 0; nl < m; ++nl) {
                        if (g[v][u][nl] > 0) {
                            int val = d[v][l] + g[v][u][nl];
                            if (l != nl) {
                                val += s;
                            }
                            if (val < d[u][nl]) {
                                d[u][nl] = val;
                                qv.add(u);
                                ql.add(nl);
                            }
                        }
                    }
                }
            }
            int best = Integer.MAX_VALUE;
            for (int l = 0; l < m; ++l) {
                if (d[b][l] < best) {
                    best = d[b][l];
                }
            }
            out.println(best);
        }

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
        new F().solve();
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
