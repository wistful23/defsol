import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        Set<State> states = new HashSet<State>();
        for (int i = 0; i < 4; ++i) {
            states.add(new State(readInt(), 1, 1 << i));
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            State[] list = states.toArray(new State[0]);
            for (int i = 0; i < list.length; ++i) {
                for (int j = 0; j < list.length; ++j) {
                    State l = list[i];
                    State r = list[j];
                    if ((l.mask & r.mask) == 0) {
                        int nm = l.mask | r.mask;
                        // *
                        State n = new State(l.a * r.a, l.b * r.b, nm);
                        if (!states.contains(n)) {
                            states.add(n);
                            flag = true;
                        }
                        // +
                        n = new State(l.a * r.b + r.a * l.b, l.b * r.b, nm);
                        if (!states.contains(n)) {
                            states.add(n);
                            flag = true;
                        }
                        // -
                        n = new State(l.a * r.b - r.a * l.b, l.b * r.b, nm);
                        if (!states.contains(n)) {
                            states.add(n);
                            flag = true;
                        }
                        // /
                        if (r.a > 0) {
                            n = new State(l.a * r.b, l.b * r.a, nm);
                            if (!states.contains(n)) {
                                states.add(n);
                                flag = true;
                            }
                        }
                    }
                }
            }

        }

        int best = 123;
        for (Iterator<State> it = states.iterator(); it.hasNext(); ) {
            State st = it.next();
            if (st.b == 1 && st.a >= 0 && st.mask == 15) {
                int cmp = Math.abs(21 - st.a) - Math.abs(21 - best);
                if (cmp < 0 || (cmp == 0 && st.a < best)) {
                    best = st.a;
                }
            }
        }

        println(best);

        exit();
    }

    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    class State {
        int a, b;
        int mask;

        State(int a, int b, int mask) {
            int d = gcd(a, b);
            this.a = a / d;
            this.b = b / d;
            this.mask = mask;
        }

        public int hashCode() {
            return a * 23 + b * 123 + mask * 123;
        }

        public boolean equals(Object o) {
            final State s = (State) o;
            return a == s.a && b == s.b && mask == s.mask;
        }
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

    char readChar() throws IOException {
        return (char) in.read();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readToken());
    }

    long readLong() throws IOException {
        return Long.parseLong(readToken());
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
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    boolean eof() throws IOException {
        return !in.ready();
    }

    void print(String format, Object ... args) {
        out.print(new Formatter(Locale.US).format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter(Locale.US).format(format, args));
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
        new B().solve();
    }
}
