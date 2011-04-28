import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class E {
    public static void main(String args[]) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("lucky.in"));
        out = new PrintWriter("lucky.out");

        BigInteger v = new BigInteger(in.readLine(), 36);

        BigInteger r[] = v.divideAndRemainder(BigInteger.valueOf(7));

        out.println(r[1].equals(BigInteger.ZERO) ? "yes" : "no");

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
