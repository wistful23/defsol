import java.io.*;
import java.util.*;

public class C {

    char[] s;
    int pos = 0;

    String getTag() {
        if (pos < s.length && s[pos] == '<') {
            ++pos;
            StringBuffer r = new StringBuffer();
            while (pos < s.length && s[pos] != '>') {
                r.append(s[pos++]);
            }
            if (pos < s.length) {
                ++pos;
                return r.toString();
            }
        }
        return "";
    }

    boolean checkTag() {
        String tag = getTag();
        if (tag.equals("B") || tag.equals("I")) {
            return checkText() && getTag().equals("/" + tag);
        } else if (tag.startsWith("A HREF=http://") && tag.endsWith(".com")) {
            for (int i = 14; i < tag.length() - 4; ++i) {
                char c = tag.charAt(i);
                if (c < 32 || c > 127 || c == '<') return false;
            }
            return checkText() && getTag().equals("/A");
        }
        return false;
    }

    boolean checkText() {
        while (pos < s.length && s[pos] != '<') {
            char c = s[pos++];
            if (c < 32 || c > 127 || c == '>') return false;
        }
        return pos + 1 < s.length && (s[pos + 1] == '/' || (checkTag() && checkText()));
    }

    boolean checkBody() {
        return getTag().equals("BODY") && checkText() && getTag().equals("/BODY");
    }

    boolean checkHTML() {
        return getTag().equals("HTML") && checkBody() && getTag().equals("/HTML") && pos == s.length;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        s = readLine().toCharArray();
        out.println(checkHTML() ? "Yes" : "No");

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
        new C().solve();
    }
}
