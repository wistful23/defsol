import java.io.*;
import java.util.*;

public class F {
    public static void main(String args[]) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("chess.in"));
        out = new PrintWriter("chess.out");

        StringTokenizer st = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = 0;

        if(m > s - n + 1) {
            m = s - m + 1;
            n = s - n + 1;
            k = 1;
        }

        int v = (m - 1) - (n - 1);

        if(v < 0) {
            v = 1 - v;
        }

        v /= 2;

        if(v % 2 == 0) {
            out.println(k);
        } else {
            out.println(1 - k);
        }

        out.close();
    }

    int s = 1000000000;

    BufferedReader in;
    PrintWriter out;
}
