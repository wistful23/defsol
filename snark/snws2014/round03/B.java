import java.io.*;
import java.text.*;
import java.util.*;

public class B {

    final DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US);

    class Connection {
        String a, b;
        int t, d;

        Connection(String a, String b, int t, int d) {
            this.a = a;
            this.b = b;
            this.t = t;
            this.d = d;
        }
    }

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        int testCount = in.readInt();
        for (int test = 1; test <= testCount; ++test) {
            int n = in.readInt();

            Connection[] c = new Connection[n];
            Map<String, TreeSet<Integer>> l = new HashMap<String, TreeSet<Integer>>();
            Map<String, Set<String>> r = new TreeMap<String, Set<String>>();

            for (int i = 0; i < n; ++i) {
                int t = 0;
                try {
                    t = (int) (format.parse(in.readToken() + " " + in.readToken()).getTime() / 1000 / 60);
                } catch (ParseException ignore) {
                }
                int d = in.readInt();
                String a = in.readToken();
                String b = in.readToken();

                String key = a + " " + b;
                TreeSet<Integer> s = l.get(key);
                if (s == null) {
                    s = new TreeSet<Integer>();
                    l.put(key, s);
                }
                s.add(t);

                r.put(a, new TreeSet<String>());
                r.put(b, new TreeSet<String>());

                c[i] = new Connection(a, b, t, d);
            }

            for (int i = 0; i < n; ++i) {
                TreeSet<Integer> s = l.get(c[i].b + " " + c[i].a);
                if (s != null) {
                    Integer t = s.higher(c[i].t);
                    if (t != null && t - c[i].t - c[i].d <= 1440) {
                        r.get(c[i].a).add(c[i].b);
                        r.get(c[i].b).add(c[i].a);
                    }
                }
            }

            for (String a : r.keySet()) {
                out.print(a + ":");
                for (String b : r.get(a)) {
                    out.print(" " + b);
                }
                out.println();
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
