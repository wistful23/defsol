import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("poker.in"));
        out = new PrintWriter("poker.out");
        while (in.ready()) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String s = st.nextToken();
            int a1 = value(s.charAt(0));
            int a2 = value(s.charAt(1));
            if (a1 < a2) {
                int t = a1; a1 = a2; a2 = t;
            }
            s = st.nextToken();
            int b1 = value(s.charAt(0));
            int b2 = value(s.charAt(1));
            if (b1 < b2) {
                int t = b1; b1 = b2; b2 = t;
            }
            boolean win = false;
            if (a1 == a2) {
                win = b1 != b2 || a1 > b1;
            } else if (b1 != b2) {
                win = a1 > b1 || (a1 == b1 && a2 > b2);
            }
            if (win) {
                out.println("win");
            } else {
                out.println("loss");
            }
        }
        out.close();
    }

    int value(char c) {
        if (c >= '2' && c <= '9') {
            return c - '0';
        }
        switch (c) {
            case 't': return 10;
            case 'j': return 11;
            case 'q': return 12;
            case 'k': return 13;
            case 'a': return 14;
        }
        return -1;
    }

    BufferedReader in;
    PrintWriter out;
}
