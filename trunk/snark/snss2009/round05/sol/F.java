import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("china.in"));
        out = new PrintWriter("china.out");
        while (in.ready()) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long q = Long.parseLong(st.nextToken());
            long g = Long.parseLong(st.nextToken());
            long d = gcd(q, q + g);
            out.println((q / d) + "/" + ((q + g) / d));
        }
        out.close();
    }

    long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    BufferedReader in;
    PrintWriter out;
}
