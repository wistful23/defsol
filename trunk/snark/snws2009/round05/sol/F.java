import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class F {

    public static void main(String[] args) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("insert.in"));
        out = new PrintWriter("insert.out");

        int n = Integer.parseInt(in.readLine());
        while (n > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            Tree t = new Tree(Integer.parseInt(st.nextToken()));
            while (st.hasMoreElements()) {
                insert(t, Integer.parseInt(st.nextToken()));
            }
            out.println(calc(t));
            n = Integer.parseInt(in.readLine());
        }

        out.close();
    }

    BigInteger c[][] = new BigInteger[103][103];

    BigInteger c(int n, int k) {
        if (c[n][k] == null) {
            if (k == 0 || k == n) {
                c[n][k] = BigInteger.ONE;
            } else {
                c[n][k] = c(n - 1, k).add(c(n - 1, k - 1));
            }
        }
        return c[n][k];
    }

    BigInteger calc(Tree t) {
        if (t == null) {
            return BigInteger.ONE;
        }
        BigInteger r = calc(t.left).multiply(calc(t.right));
        if (t.left != null && t.right != null) {
            int c1 = t.left.c;
            int c2 = t.right.c;
            r = r.multiply(c(c1 + c2, c1));
        }
        return r;
    }

    void insert(Tree t, int v) {
        ++t.c;
        if (v < t.v) {
            if (t.left == null) {
                t.left = new Tree(v);
            } else {
                insert(t.left, v);
            }
        } else {
            if (t.right == null) {
                t.right = new Tree(v);
            } else {
                insert(t.right, v);
            }
        }
    }

    class Tree {
        Tree left, right;
        int v, c;

        Tree(int v) {
            this.v = v;
            this.c = 1;
        }
    }

    BufferedReader in;
    PrintWriter out;
}
