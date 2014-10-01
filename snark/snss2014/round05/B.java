import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        int testCount = in.readInt();
        in.readLine();
        for (int test = 1; test <= testCount; ++test) {
            char[] s = in.readLine().toCharArray();
            if (s.length < 10) {
                out.println("YES");
            } else {
                int n = s.length == 10 ? 5 : 6;
                boolean[][] g = new boolean[n][n];
                int k = 0;
                int[] c = new int[n];
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < i; ++j) {
                        if (s[k++] == '1') {
                            g[i][j] = g[j][i] = true;
                            ++c[i];
                            ++c[j];
                        }
                    }
                }
                if (n == 5) {
                    int r = 0;
                    for (int i = 0; i < n; ++i) {
                        if (c[i] == 4) ++r;
                    }
                    out.println(r == 5 ? "NO" : "YES");
                } else {
                    boolean flag = true;
                    // delete one vertex
                    for (int d = 0; d < n && flag; ++d) {
                        int r = 0;
                        for (int i = 0; i < n; ++i) {
                            if (i != d) {
                                int tc = c[i];
                                if (g[d][i]) --tc;
                                if (tc == 4) ++r;
                            }
                        }
                        flag = r < 5;
                    }
                    // join two vertices
                    for (int d = 0; d < n && flag; ++d) {
                        for (int v = 0; v < n && flag; ++v) {
                            if (g[d][v]) {
                                int[] c2 = Arrays.copyOf(c, n);
                                --c2[d];
                                for (int i = 0; i < n; ++i) {
                                    if (i != d && i != v) {
                                        if (g[d][i] && g[v][i]) {
                                            --c2[i];
                                        }
                                        if (!g[d][i] && g[v][i]) {
                                            ++c2[d];
                                        }
                                    }
                                }
                                int r = 0;
                                for (int i = 0; i < n; ++i) {
                                    if (i != v) {
                                        if (c2[i] == 4) ++r;
                                    }
                                }
                                flag = r < 5;
                            }
                        }
                    }
                    if (flag) {
                        // 3x3
                        for (int s1 = 0; s1 < n && flag; ++s1) {
                            for (int s2 = s1 + 1; s2 < n && flag; ++s2) {
                                for (int s3 = s2 + 1; s3 < n && flag; ++s3) {
                                    flag = false;
                                    for (int i = 0; i < n && !flag; ++i) {
                                        if (i == s1 || i == s2 || i == s3) {
                                            int r = 0;
                                            for (int j = 0; j < n; ++j) {
                                                if (j != s1 && j != s2 && j != s3) {
                                                    if (g[i][j]) ++r;
                                                }
                                            }
                                            flag = r < 3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    out.println(flag ? "YES" : "NO");
                }
            }
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
