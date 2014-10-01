import java.io.*;
import java.util.*;

public class B {

    final static long M = 1000000007;

    class XY {
        long x, y;

        XY(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    XY egcd(long a, long b) {
        if (a == 0) return new XY(0, 1);
        XY r = egcd(b % a, a);
        return new XY(r.y - (b / a) * r.x, r.x);
    }

    long inv(long v) {
        XY r = egcd(v, M);
        long t = r.x % M;
        if (t < 0) t += M;
        return t;
    }

    long pow(long b, int p) {
        long r = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                r = r * b % M;
            }
            b = b * b % M;
            p >>= 1;
        }
        return r;
    }

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        char[] s0 = in.readToken().toCharArray();
        char[] s1 = in.readToken().toCharArray();
        char[] s2 = in.readToken().toCharArray();

        int n = s0.length;
        int[] l = new int[4];
        for (int i = 0; i < n; ++i) {
            if (s0[i] == s1[i]) {
                if (s0[i] == s2[i]) {
                    ++l[3];
                } else {
                    ++l[0];
                }
            } else {
                if (s0[i] == s2[i]) {
                    ++l[1];
                } else {
                    ++l[2];
                }
            }
        }

        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] * i % M;
        }

        long[][] c = new long[3][];
        for (int j = 0; j < 3; ++j) {
            c[j] = new long[l[j] + 1];
            for (int i = 0; i <= l[j]; ++i) {
                c[j][i] = inv(f[l[j] - i]) * inv(f[i]) % M;
                c[j][i] = c[j][i] * f[l[j]] % M;
            }
        }

        long r = 0;
        for (int x2 = 0; x2 <= l[2]; ++x2) {
            int x0 = l[0] - l[2] + 2 * x2;
            int x1 = l[1] - l[2] + 2 * x2;
            if (x0 >= 0 && x1 >= 0 && (x0 & 1) == 0 && (x1 & 1) == 0) {
                x0 >>= 1;
                x1 >>= 1;
                if (x0 <= l[0] && x1 <= l[1]) {
                    long v = c[0][x0] * c[1][x1] % M;
                    v = v * c[2][x2] % M;
                    r = (r + v) % M;
                }
            }
        }

        r = r * pow(2, l[3]) % M;

        out.println(r);

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
        new B().solve();
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
