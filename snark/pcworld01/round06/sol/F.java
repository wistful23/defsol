import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class F {
    public static void main(String args[]) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("version.in"));
        pw = new PrintWriter("version.out");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger d0 = new BigInteger(st.nextToken());
        BigInteger h0 = new BigInteger(st.nextToken());
        BigInteger dt = new BigInteger(st.nextToken());
        BigInteger db = new BigInteger(st.nextToken());
        BigInteger h1 = new BigInteger(st.nextToken());

        BigInteger p = dt.multiply(db);
        d0 = d0.multiply(d0);
        dt = dt.multiply(dt);
        db = db.multiply(db);

        BigInteger a = new BigInteger("3").multiply(h0).multiply(d0);
        BigInteger b = new BigInteger("2").multiply(h1).multiply(dt.add(db).add(p));

        BigInteger[] r = a.divideAndRemainder(b);
        if(r[1].compareTo(BigInteger.ZERO) > 0) {
            r[0] = r[0].add(BigInteger.ONE);
        }
        
        pw.println(r[0]);

        pw.close();
    }

    BufferedReader br;
    PrintWriter pw;
}
